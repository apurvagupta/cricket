package service;

import model.BallStatus;
import model.Cricketer;
import model.Cricketers;
import model.GameStatus;

import java.util.List;

public class Game {

    public static GameStatus status = GameStatus.loose;
    private Cricketer onStrike;
    private Cricketer offStrike;
    private Cricketers cricketers;

    public Cricketer getOnStrike() {
        return onStrike;
    }

    public Cricketer getOffStrike() {
        return offStrike;
    }

    public Game() {
        cricketers = new Cricketers();
        onStrike = cricketers.getOpeners();
        offStrike = cricketers.getOpeners();
    }

    public void changeStrike() {
        Cricketer temp = offStrike;
        offStrike = onStrike;
        onStrike = temp;
    }

    public Cricketer changePlayer() {
        onStrike = cricketers.getNextCricketer(onStrike);
        return onStrike;
    }

    public boolean isLost() {
        boolean isLoss = onStrike == null && MatchSimulation.TOTAL_RUNS > getTotalScore();
        if (isLoss) status = GameStatus.loose;
        return isLoss;
    }

    public boolean isWon() {
        boolean isWon = MatchSimulation.TOTAL_RUNS < getTotalScore();
        if (isWon) status = GameStatus.won;
        return isWon;
    }

    public void  updatePlayer(String ballStatus) {
        if (ballStatus != BallStatus.out.name()) {
            onStrike.setScore(Integer.parseInt(ballStatus));
        }
        onStrike.increaseBallsFaced();
    }

    public void changeBasedOnBallStatus(String ballStatus) {
        updatePlayer(ballStatus);
        if (ballStatus == BallStatus.out.name())
            changePlayer();
        else if (isOdd(ballStatus))
            changeStrike();
    }

    private static boolean isOdd(String status) {
        return Integer.parseInt(status) % 2 != 0;
    }

    public boolean isOverStarting(int currentBall, Integer ballsInTheOver) {
        boolean overFinished = currentBall % ballsInTheOver == 0;
        if (overFinished && currentBall!= 0) changeStrike();
        return overFinished;
    }

    public boolean isTie(Integer runsLeft, Cricketer onStrike) {
        return MatchSimulation.TOTAL_RUNS == runsLeft && onStrike == null;
    }

    public Integer getTotalScore() {
        return cricketers.getObserver().getTotalScore();
    }

    public Integer getRemainWickets() {
        return cricketers.size() + 1;
    }

    public List<Cricketer> getOutCricketers() {
        return cricketers.getOutCricketer();
    }
}
