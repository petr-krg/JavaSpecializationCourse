package krg.petr.otus.javabasic.unit;

import krg.petr.otus.javabasic.assertions.Assertions;
import krg.petr.otus.javabasic.game.DiceImpl;

public class OutOfRangeTest {

    public void testOutOfRange() {
        String scenario = "Тест выхода из диопозона";
        try {
            DiceImpl diceRoll = new DiceImpl();
            Assertions.assertMoreLessValue(6, 1, diceRoll.roll());
            System.out.printf("\"%s\" " + ColorConst.ANSI_GREEN + " passed %n"  + ColorConst.ANSI_RESET, scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\"%n", scenario, e.getMessage());
        }
    }
}
