package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.InInterface;
import krg.petr.otusjava.interfaces.OutInterface;

import java.util.Scanner;

public class ConsoleInput implements InInterface {

    @Override
    public int inputUserAnswer(int arrayLength) {
        int inputUserAnswer;
        String inputError;
        Scanner sc = new Scanner(System.in);
        OutInterface print = new ConsoleOutput();

        do {
            System.out.print("Ваш ответ: ");
            if (sc.hasNextInt()) {
                inputUserAnswer = sc.nextInt();
                if (inputUserAnswer < 1 | inputUserAnswer > arrayLength) {
                    print.printMessage("Вы ввели число в не диапазона от 1 до %d!\n", arrayLength - 1);
                    print.printMessage("Введите число в диапазоне от 1 до %d или <N> для завершения программы.\n",
                            arrayLength - 1);
                } else {
                    return --inputUserAnswer;
                }
            } else {
                inputError = sc.next();
                if (inputError.equalsIgnoreCase("n")) {
                    System.exit(0);
                }
                print.printMessage("Ошибка! Вы ввели не целое число, введите число в диапазоне от 1 до %d или " +
                        "введите <N> для завершения программы.\n", arrayLength - 1);
            }
        } while (true);
    }
}
