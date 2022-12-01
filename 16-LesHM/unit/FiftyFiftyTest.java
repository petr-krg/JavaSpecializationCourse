package krg.petr.otus.javabasic.unit;

import krg.petr.otus.javabasic.assertions.Assertions;
import krg.petr.otus.javabasic.game.DiceImpl;

public class FiftyFiftyTest {
    public void testFiftyFifty() {
        String scenario = "Тест на равные значения";
        try {
            DiceImpl diceRoll = new DiceImpl();
            Assertions.assertFiftyFifty(diceRoll.roll(), diceRoll.roll());
            System.out.printf("\"%s\" " + ColorConst.ANSI_GREEN + " passed %n" + ColorConst.ANSI_RESET, scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\"%n", scenario, e.getMessage());
        }
    }
}
