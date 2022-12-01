package krg.petr.otus.javabasic.unit;

import krg.petr.otus.javabasic.assertions.Assertions;
import krg.petr.otus.javabasic.game.*;

public class PlayGameTest {
    private final Player player1;
    private final Player player2;
    private final int player1Result;
    private final int player2Result;
    public PlayGameTest( Player player1, Player player2, int player1Result, int player2Result) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Result = player1Result;
        this.player2Result = player2Result;
    }
    public void testPlayGame(Player expectedWinner) {
        String scenario = "Тест проверки победителя";

        Dice dice = new DiceImpl();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);

        Player winner = (this.player1Result > this.player2Result)? this.player1: this.player2;
        try {
            Assertions.assertEquals(expectedWinner.getName(), winner.getName());
            System.out.printf("\"%s\" " + ColorConst.ANSI_GREEN + " passed %n"  + ColorConst.ANSI_RESET, scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\"%n", scenario, e.getMessage());
        }


    }
}
