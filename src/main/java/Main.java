import service.MatchSimulation;

/**
 * Created by apurvagu on 28/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        MatchSimulation matchSimulation = new MatchSimulation();
        String commentary = matchSimulation.start();
        System.out.print(commentary);
    }
}
