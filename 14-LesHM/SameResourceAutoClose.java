package krg.petr.otus.javabasic;

// класс заглушка типа ресурсы

public class SameResourceAutoClose implements AutoCloseable {
    public void execute() {

    }

    public void close() {
        System.out.println("Закрылся");
    }
}


