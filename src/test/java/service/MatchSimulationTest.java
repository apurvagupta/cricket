package service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by apurvagu on 23/12/2016.
 */
public class MatchSimulationTest {


    @Test
    public void shouldGiveCommentary() {
        MatchSimulation matchSimulation = new MatchSimulation();

        String commentary = matchSimulation.start();

        String[] commentaries = commentary.split("\n");
        String[] wordsInCommentary = commentaries[3].split(" ");

        Assert.assertNotNull(commentaries);
        Assert.assertEquals("0.0", wordsInCommentary[0]);
        Assert.assertEquals("Kirat", wordsInCommentary[1]);
    }

}
