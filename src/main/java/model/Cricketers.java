package model;

import observer.Observer;
import observer.ScoreObserver;

import java.util.ArrayList;

/**
 * Created by apurvagu on 26/12/2016.
 */
public class Cricketers {
    private ArrayList<Cricketer> cricketers = new ArrayList<Cricketer>();
    private ArrayList<Cricketer> outCricketer = new ArrayList<Cricketer>();
    private Observer observer;

    public Cricketers() {
        observer = new ScoreObserver();

        Cricketer first = new Cricketer(CricketerName.KIRAL_BOLI);
        first.registerObserver(observer);
        cricketers.add(first);

        Cricketer second = new Cricketer(CricketerName.NS_NODHI);
        second.registerObserver(observer);
        cricketers.add(second);

        Cricketer third = new Cricketer(CricketerName.R_RUMRAH);
        third.registerObserver(observer);
        cricketers.add(third);

        Cricketer fourth = new Cricketer(CricketerName.SASHI_HENRA);
        fourth.registerObserver(observer);
        cricketers.add(fourth);

    }

    public Observer getObserver() {
        return observer;
    }

    public Cricketer getNextCricketer(Cricketer onStriker) {
        Cricketer cricketer = cricketers.size() != 0 ? cricketers.get(0) : null;
        outCricketer.add(onStriker);
        cricketers.remove(cricketer);
        return cricketer;
    }

    public Cricketer getOpeners() {
        Cricketer cricketer = cricketers.get(0);
        cricketers.remove(cricketer);
        return cricketer;
    }
    public ArrayList<Cricketer> getOutCricketer() {
        return outCricketer;
    }

    public Integer size() {
        return cricketers.size();
    }
}
