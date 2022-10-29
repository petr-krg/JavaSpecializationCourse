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

        // Примечание - можете придумать как хранить всю информацию в одном массиве
        // Реализовал двумерный массив, последний элемент всегда вариант правильного ответа и
        // данная реализация не привязана к количеству вариантов ответа
        String[][] testArray = {
                {"A. Какой месяц короче всех?",
                        "1. Февраль",
                        "2. Май",
                        "3. Октябрь",
                        "2. Май"},
                {"Б. Может ли страус назвать себя птицей?",
                        "1. Нет, так как он не умеет говорить",
                        "2. Нет, так как он не летает",
                        "3. Страус не птица",
                        "4. Да он птица",
                        "5. Да черт его знает))",
                        "1. Нет, так как он не умеет говорить"},
                {"В. Что с земли легко поднимешь, но далеко не закинешь?",
                        "1. Песок",
                        "2. Деревяшку",
                        "3. Пух",
                        "3. Пух"},
        };

        do {
            int choiceAnswer = -1;
            String testAnswer = null;
            boolean errorInputValue;
            String errorChoiceAnswer;
            Scanner scanner = new Scanner(System.in);
            // Вывод вопроса и вариантов ответа на экран
            for (String[] strings : testArray) {
                for (int j = 0; j < strings.length - 1; j++) {
                    System.out.println(strings[j]);
                    // этот вариант проверки не нравиться, как то колхозно, но, что-то не придумал как по феншую в jave
                    if (j+1 == strings.length - 1) {
                        testAnswer = strings[j+1];
                    }
                }

                do {
                    errorInputValue = true;
                    System.out.print("Ваш ответ: ");
                    if (scanner.hasNextInt()) {
                        choiceAnswer = scanner.nextInt();
                        if (choiceAnswer < 1 | choiceAnswer > strings.length - 2) {
                            System.out.println("Вы ввели число в не диапазона от 1 до " + (strings.length - 2) + "!");
                            System.out.println("\nВведите число в диапазоне от 1 до " + (strings.length - 2) +
                                    "\n или <N> для завершения программы.");
                        } else {
                            errorInputValue = false;
                        }
                    } else {
                        errorChoiceAnswer = scanner.next();
                        if (errorChoiceAnswer.equalsIgnoreCase("n")) {
                            System.exit(0);
                        }
                        System.out.println("Вы ввели не целое число");
                    }
                } while (errorInputValue);

                if (strings[choiceAnswer].equalsIgnoreCase(testAnswer)) {
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