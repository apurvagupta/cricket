package service;

import model.Cricketer;
import model.CricketerName;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by apurvagu on 30/12/2016.
 */
public class GameTest {
    @Test
    public void shouldChangeStrikeOnEachOver() {
        Game game = new Game();
        game.isOverStarting(12, 6);
        Cricketer onStrike = game.getOnStrike();
        Cricketer offStrike = game.getOffStrike();

        Assert.assertEquals(onStrike.getName(), CricketerName.NS_NODHI);
        Assert.assertEquals(offStrike.getName(), CricketerName.KIRAL_BOLI);
    }

    @Test
    public void shouldChangeStrikeWhenOddRunsAreScored() {
        Game game = new Game();
        game.changeBasedOnBallStatus("1");
        Cricketer onStrike = game.getOnStrike();
        Cricketer offStrike = game.getOffStrike();

        Assert.assertEquals(onStrike.getName(), CricketerName.NS_NODHI);
        Assert.assertEquals(offStrike.getName(), CricketerName.KIRAL_BOLI);
    }

    @Test
    public void shouldChangePlayerWhenOut() {
        Game game = new Game();
        game.changeBasedOnBallStatus("out");
        Cricketer onStrike = game.getOnStrike();
        Cricketer offStrike = game.getOffStrike();

        Assert.assertEquals(onStrike.getName(), CricketerName.R_RUMRAH);
        Assert.assertEquals(offStrike.getName(), CricketerName.NS_NODHI);
    }

    @Test
    public void shouldUpdatePlayerScoreAndBallsOnEachBall() {
        Game game = new Game();
        game.changeBasedOnBallStatus("2");
        Cricketer onStrike = game.getOnStrike();

        Assert.assertEquals(new Integer(2), onStrike.getScore().getTotalScore());
        Assert.assertEquals(new Integer(1), onStrike.getBallsFaced());
    }

    @Test
    public void shouldDeclareLoose() {
        Game game = new Game();
        boolean won = game.isWon();

        Assert.assertFalse(won);

        game.changeBasedOnBallStatus("out");
        game.changeBasedOnBallStatus("out");
        game.changeBasedOnBallStatus("out");

        boolean lost = game.isLost();

        Assert.assertTrue(lost);
    }

    @Test
    public void shouldDeclareWin() {
        Game game = new Game();
        boolean won = game.isWon();

        Assert.assertFalse(won);

        game.changeBasedOnBallStatus("6");
        game.changeBasedOnBallStatus("6");
        game.changeBasedOnBallStatus("6");
        game.changeBasedOnBallStatus("6");
        game.changeBasedOnBallStatus("6");
        game.changeBasedOnBallStatus("6");
        game.changeBasedOnBallStatus("6");

        boolean won1 = game.isWon();

        Assert.assertTrue(won1);
    }

}
