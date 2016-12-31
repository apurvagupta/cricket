package utils;

import model.Cricketer;
import model.CricketerName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apurvagu on 24/12/2016.
 */
public class ProbabilityChart {

    private static Map cricketerProbability = new HashMap<CricketerName, Map<String, Double>>();

    public static void initProbability() {
        Map kirat = new HashMap();
        kirat.put("0", 5d);
        kirat.put("1", 30d);
        kirat.put("2", 25d);
        kirat.put("3", 10d);
        kirat.put("4", 15d);
        kirat.put("5", 1d);
        kirat.put("6", 9d);
        kirat.put("out", 5d);
        Map dhoni = new HashMap();
        dhoni.put("0", 10d);
        dhoni.put("1", 40d);
        dhoni.put("2", 20d);
        dhoni.put("3", 5d);
        dhoni.put("4", 10d);
        dhoni.put("5", 1d);
        dhoni.put("6", 4d);
        dhoni.put("out", 10d);
        Map rumrah = new HashMap();
        rumrah.put("0", 20d);
        rumrah.put("1", 10d);
        rumrah.put("2", 15d);
        rumrah.put("3", 5d);
        rumrah.put("4", 5d);
        rumrah.put("5", 1d);
        rumrah.put("6", 4d);
        rumrah.put("out", 20d);
        Map henra = new HashMap();
        henra.put("0", 30d);
        henra.put("1", 25d);
        henra.put("2", 5d);
        henra.put("3", 0d);
        henra.put("4", 5d);
        henra.put("5", 1d);
        henra.put("6", 4d);
        henra.put("out", 30d);
        cricketerProbability.put(CricketerName.KIRAL_BOLI, kirat);
        cricketerProbability.put(CricketerName.NS_NODHI, dhoni);
        cricketerProbability.put(CricketerName.R_RUMRAH, rumrah);
        cricketerProbability.put(CricketerName.SASHI_HENRA, henra);
    }

    public static String getStatus(Cricketer onStrike) {
        Map<String, Double> chart = (Map) cricketerProbability.get(onStrike.getName());
        double bestValue = Double.MAX_VALUE;
        String status = "";

        for (String element : chart.keySet()) {
            double value = Math.random() / chart.get(element);

            if (value < bestValue) {
                bestValue = value;
                status = element;
            }
        }

        return status;
    }
}
