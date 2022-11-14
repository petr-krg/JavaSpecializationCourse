package krg.petr.otusjava;

import krg.petr.otusjava.interfaces.OutInterface;

public class ConsoleOutput implements OutInterface {
    @Override
    public void printMessage(String message) {

        System.out.print(message);
    }

    @Override
    public void printMessage(String message, Object ... args) {

        System.out.printf(message, args);
    }
}
