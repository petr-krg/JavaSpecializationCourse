package krg.petr.otusjava;

import java.util.Scanner;

public class QuizGame {
    final int MAX_QUESTIONS = QuizData.questions.length;
    final int MIN_QUESTIONS = 3;
    private int correctCount;
    private int wrongCount;
    private int countQuestions;
    private Boolean randomQuestion;
    private String namePlayer;

    {
        correctCount   = 0;
        wrongCount     = 0;
        countQuestions = 0;
        randomQuestion = false;
        namePlayer     = "Undefined";
    }

    public boolean setCountQustions(int value) {
        if (value >= MIN_QUESTIONS && value <= MAX_QUESTIONS) {
            this.countQuestions = value;
        } else {
            System.out.printf("%s, укажите количестов вопросов в диапзоне от %d до %d: ", namePlayer, MIN_QUESTIONS, MAX_QUESTIONS);
            return false;
        }

        return true;
    }

    public int getCountQuestions() {

        return this.countQuestions;
    }

    private void setCorrectCount() {
        this.correctCount++;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    private void setWrongCount() {
        this.wrongCount++;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void setRandomQuestion(Boolean value) {
        this.randomQuestion = value;
    }

    public Boolean getRandomQuestion() {
        return this.randomQuestion;
    }

    public void setNamePlayer(String name) {
        this.namePlayer = name;
    }

    public String getNamePlayer() {
        return this.namePlayer;
    }



    private void PrintQuestion (int arrayIndex, int numberIndex) {
        System.out.println(numberIndex + "] " + QuizData.questions[arrayIndex]);

        for (int i = 1; i < QuizData.answerOptions[arrayIndex].length; i++) {
            System.out.println("    " + i + ") " + QuizData.answerOptions[arrayIndex][i]);
        }
    }

    public void StartQuiz() {

        String startAgain;

        System.out.printf("Добро пожаловать в игру %s!\n", namePlayer);

        do {
            int indexArray = 0;
            int inputAnswer;
            String inputError;

            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < countQuestions; i++) {
                if (randomQuestion) {
                    indexArray = (int) (Math.random()*100);
                } else {
                    indexArray = i;
                }

                PrintQuestion(indexArray, i+1);

                do {
                    System.out.print("Ваш ответ: ");
                    if (scanner.hasNextInt()) {
                        inputAnswer = scanner.nextInt();
                        if (inputAnswer < 1 | inputAnswer > QuizData.answerOptions[indexArray].length) {
                            System.out.printf("Вы ввели число в не диапазона от 1 до %d!\n", QuizData.answerOptions[indexArray].length - 1);
                            System.out.printf("Введите число в диапазоне от 1 до %d или <N> для завершения программы.\n",
                                    QuizData.answerOptions[indexArray].length - 1);
                        } else {
                            break;
                        }
                    } else {
                        inputError = scanner.next();
                        if (inputError.equalsIgnoreCase("n")) {
                            System.exit(0);
                        }
                        System.out.printf("Ошибка! Вы ввели не целое число, введите число в диапазоне от 1 до %d или " +
                                "введите <N> для завершения программы.\n", QuizData.answerOptions[indexArray].length - 1);
                    }
                } while (true);

                if (inputAnswer == QuizData.correctAnswers[indexArray]) {
                    setCorrectCount();
                } else {
                    setWrongCount();
                }
                System.out.println();
            }

            //Выводим общий результат
            System.out.println("Результат: правильно " + getCorrectCount() + ", неправильно " + getWrongCount());
            System.out.println("\n\nВы хотите повторить (y/n)?");
            startAgain = scanner.next();
        } while (startAgain.equalsIgnoreCase("y"));
    }

}
