package observer;

import model.Score;

/**
 * Created by apurvagu on 27/12/2016.
 */
public class ScoreObserver implements  Observer {

    private Score score;

    public ScoreObserver() {
        score = new Score(0);
    }
    public void update(Integer ballScore) {
        score.addScore(ballScore);
    }

    public Integer getTotalScore() {
        return score.getTotalScore();
    }
}
