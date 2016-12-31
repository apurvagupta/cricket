package model;

import observer.Observer;

/**
 * Created by apurvagu on 24/12/2016.
 */
public class Cricketer {
    private Observer observer;
    private CricketerName name;
    private Score score;
    private Integer ballsFaced;

    public Cricketer(CricketerName name) {
        this.name = name;
        this.score = new Score(0);
        this.ballsFaced = 0;
    }

    public Integer getBallsFaced() {
        return ballsFaced;
    }

    public Score getScore() {
        return score;
    }

    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    public void increaseBallsFaced() {
        this.ballsFaced++;
    }

    public void setScore(Integer ballScore) {
        this.score.addScore(ballScore);
        observer.update(ballScore);
    }

    public CricketerName getName() {
        return name;
    }

    public String getActualName() {
        return name.getName();
    }
}
