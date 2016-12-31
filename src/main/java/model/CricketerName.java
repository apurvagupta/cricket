package model;

/**
 * Created by apurvagu on 24/12/2016.
 */
public enum CricketerName {
    KIRAL_BOLI("Kirat"), NS_NODHI("N.S Nodhi"), R_RUMRAH("R Rumrah"), SASHI_HENRA("Sashi Henra");

    private String name;

    public String getName() {
        return name;
    }

    CricketerName(String name) {

        this.name = name;
    }

}
