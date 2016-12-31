package model;

/**
 * Created by apurvagu on 24/12/2016.
 */
public class Score {

    private Integer totalScore;

    public Integer getTotalScore() {
        return totalScore;
    }

    public Score(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public void addScore(Integer runOnTheBall) {
        this.totalScore += runOnTheBall;
    }

}

