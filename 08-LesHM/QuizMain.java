package krg.petr.otusjava;

import java.util.Scanner;

public class QuizMain {

    public static void main(String[] args) {

        /* for (int i = 0; i <= QuizData.questions.length - 1; i++) {
            System.out.println(i+1 + "] " + QuizData.questions[i]);
            for (int j = 1; j < QuizData.answerOptions[i].length; j++) {
                System.out.println(j + ") " + QuizData.answerOptions[i][j]);
            }
            System.out.println("Правильный ответ: " + (QuizData.correctAnswers[i] + 1) + " " + QuizData.answerOptions[i][QuizData.correctAnswers[i]+1]);
        } */
        String inputRandomQuestion;

        Scanner scanner = new Scanner(System.in);

        QuizGame game = new QuizGame();

        System.out.print("Введите своё имя: ");
        game.setNamePlayer(scanner.next());

        System.out.printf("Введите количестов вопросов для викторины в дипазоне от %d до %d: ", game.MIN_QUESTIONS, game.MAX_QUESTIONS);
        do {
            if (game.setCountQustions(scanner.nextInt())) {
                break;
            }
        } while (true);

        System.out.print("Выводить вопросы в произволном порядке Y/N: ");
        inputRandomQuestion = scanner.next();

        if (inputRandomQuestion.equalsIgnoreCase("y")) {
            game.setRandomQuestion(true);
        }

        game.StartQuiz();
    }

}
