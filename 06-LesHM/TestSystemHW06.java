package krg.petr.otusjava;

import java.util.Scanner;

/*
  Написать систему тестирования.
  На экран выводится вопрос и варианты ответа, с клавиатуры вводится номер ответа.
  Вопросы и ответы должны быть зашиты в коде, внешнего хранения в файлах или базах данных не нужно.
  Должно быть три вопроса, каждый с 3-5 вариантами ответов.
  Все вопросы с одним правильным вариантом ответа.
  После прохождения теста отображается результат.
  Использовать только циклы, массивы, условия и другие структуры, которые были пройдены на данный момент в рамках курса.
  В этом задании не нужно использовать ООП (создавать классы), вопросы и варианты ответов надо хранить в массиве (массивах).
 */

public class TestSystemHW06 {
    public static void main(String[] args) {

        // Переменные для хранения количества правильных и неправильных ответов
        int correctCount = 0, wrongCount = 0;
        // Переменная для повторного запуска теста
        String startAgain;

        String[] questions = {"A. Какой месяц короче всех?", "Б. Может ли страус назвать себя птицей?",
                "В. Что с земли легко поднимешь, но далеко не закинешь?"};

        String[][] answerOptions = {
                {"A. Какой месяц короче всех?", "1. Февраль", "2. Май", "3. Октябрь"},
                {"Б. Может ли страус назвать себя птицей?", "1. Нет, так как он не умеет говорить", "2. Нет, так как он не летает",
                        "3. Страус не птица", "4. Да он птица", "5. Да черт его знает))"},
                {"В. Что с земли легко поднимешь, но далеко не закинешь?","1. Песок", "2. Деревяшку", "3. Пух"},
        };

        int[] correctAnswers = {1, 0, 2};

        do {
            int inputAnswer;
            String inputError;

            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                for (int j = 1; j < answerOptions[i].length; j++) {
                    System.out.println(answerOptions[i][j]);
                }

                do {
                    System.out.print("Ваш ответ: ");
                    if (scanner.hasNextInt()) {
                        inputAnswer = scanner.nextInt();
                        if (inputAnswer < 1 | inputAnswer > answerOptions[i].length) {
                            System.out.printf("Вы ввели число в не диапазона от 1 до %d!\n", answerOptions[i].length - 1);
                            System.out.printf("Введите число в диапазоне от 1 до %d или <N> для завершения программы.\n",
                                    answerOptions[i].length - 1);
                        } else {
                            break;
                        }
                    } else {
                        inputError = scanner.next();
                        if (inputError.equalsIgnoreCase("n")) {
                            System.exit(0);
                        }
                        System.out.printf("Ошибка! Вы ввели не целое число, введите число в диапазоне от 1 до %d или " +
                                "введите <N> для завершения программы.\n", answerOptions[i].length - 1);
                    }
                } while (true);

                if (inputAnswer == correctAnswers[i]) {
                    correctCount++;
                } else {
                    wrongCount++;
                }
                System.out.println();
            }

            //Выводим общий результат
            System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
            System.out.println("\n\nВы хотите повторить (y/n)?");
            startAgain = scanner.next();
        } while (startAgain.equalsIgnoreCase("y"));
    }
}