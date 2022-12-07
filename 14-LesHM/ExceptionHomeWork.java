package krg.petr.otus.javabasic;

import java.io.*;

public class ExceptionHomeWork {
    public static void main( String[] args ) {

        double d;
        double a = 1;
        double b = 1;
        double c = 1;
        double x1;
        double x2;


        ResourceWork resourceWork = new ResourceWork("C:\\1234.txt");

        try {
            String readLine = resourceWork.readFile();
            System.out.println(readLine);
        } catch (IOException e) {
            System.out.println("Ошибка! Файл не найден!");
        }

        try {
            SeveralException.rethrowException("123");
        } catch (SeveralException.Exception01 | SeveralException.Exception02 | SeveralException.Exception03 e) {
            System.out.println(e.getMessage());
        }

        try {
            d = b * b - 4 * a * c;

            if (a == 0) {
                throw new ArithmeticException("Деление на 0.");
            }

            if (d < 0) {
                throw new ArithmeticException("Уравнение не имеет корней.");
            }

            x1 = (-b - Math.sqrt(d))/(2*a);
            x2 = (-b + Math.sqrt(d))/(2*a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }


    }
}

