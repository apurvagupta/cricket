package service;

import utils.ProbabilityChart;

/**
 * Created by apurvagu on 24/12/2016.
 */
public class MatchSimulation {

    public static final int BALLS_IN_OVER = 6;
    public static final int BALLS_OVER_ALL = 24;
    public static final int TOTAL_OVER = 4;
    public static final int TOTAL_RUNS = 40;

    public MatchSimulation() {
        ProbabilityChart.initProbability();
    }


    public String start() {
        String commentary = "";
        Integer overNumber = -1;
        Integer ballInOver = 0;
        String ballStatus;
        Integer totalScore = 0;
        int currentBall = 0;

        Game game = new Game();

        for (; currentBall < BALLS_OVER_ALL; currentBall++) {

            if (game.isOverStarting(currentBall, BALLS_IN_OVER)) {
                ballInOver = 0;
                overNumber++;
                commentary += Commentary.overCommentary(TOTAL_OVER - overNumber, TOTAL_RUNS - totalScore);
            }

            ballStatus = ProbabilityChart.getStatus(game.getOnStrike());

            commentary += Commentary.ballCommentary(overNumber, ballInOver, ballStatus, game.getOnStrike());
            ballInOver++;

            game.changeBasedOnBallStatus(ballStatus);

            totalScore = game.getTotalScore();

            if (game.isLost() || game.isWon()) {
                break;
            }

        }

        return finalMatchCommentary(TOTAL_RUNS - totalScore, commentary, game, currentBall);

    }

    private String finalMatchCommentary(Integer runsLeft, String commentary, Game game, int currentBall) {
        Integer ballsRemaining = BALLS_OVER_ALL <= currentBall ? BALLS_OVER_ALL - currentBall : BALLS_OVER_ALL - (currentBall + 1);

        String finalMatchCommentary = Commentary.finalMatchCommentary(game, ballsRemaining, runsLeft);

        String finalScoreCommentary = Commentary.finalScoreCommentary(game);

        return commentary + finalMatchCommentary + finalScoreCommentary;
    }

}
