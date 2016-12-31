package service;

import model.BallStatus;
import model.Cricketer;
import model.GameStatus;

/**
 * Created by apurvagu on 26/12/2016.
 */
public class Commentary {

    static String ballCommentary(Integer overNumber, Integer ballNumber, String status, Cricketer onStrike) {
        String scoreStatus;

        if (status.equalsIgnoreCase(BallStatus.out.name())) {
            scoreStatus = " is out";
        } else if (status.equalsIgnoreCase("1") || status.equalsIgnoreCase("dot")) {
            scoreStatus = " scores " + status + " run";
        } else {
            scoreStatus = " scores " + status + " runs";
        }
        return overNumber + "." + ballNumber + " " + onStrike.getActualName() + scoreStatus + "\n";
    }

    static String overCommentary(Integer overLeft, Integer runsLeft) {
        return "\n"+ overLeft + " overs left. " + runsLeft + " runs to win \n\n";
    }


    public static String finalMatchCommentary(Game game, int ballsRemaining, Integer runsLeft) {
        String commentary;
        if (game.status == GameStatus.loose)
            commentary = " by " + runsLeft + " runs";
        else
            commentary = " by " + game.getRemainWickets() + " wickets";

        return "\nLengaburu " + game.status + commentary + " and " + ballsRemaining + " balls remaining \n\n";
    }

    public static String finalScoreCommentary(Game game) {
        String commentary = "";
        for (Cricketer cricketer : game.getOutCricketers()) {
            commentary += cricketer.getActualName() + " - " + cricketer.getScore().getTotalScore() + "(" + cricketer.getBallsFaced() + ")\n";
        }

        commentary += game.getOffStrike().getActualName() + " - " + game.getOffStrike().getScore().getTotalScore() + "* (" + game.getOffStrike().getBallsFaced() + ")\n";
        if (game.getOnStrike() != null)
            commentary += game.getOnStrike().getActualName() + " - " + game.getOnStrike().getScore().getTotalScore() + "* (" + game.getOnStrike().getBallsFaced() + ")\n";
        return commentary;
    }
}
