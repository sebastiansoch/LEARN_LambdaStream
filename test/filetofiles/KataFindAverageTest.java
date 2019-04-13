/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ssoch
 */
public class KataFindAverageTest {

    private static final double DELTA = 1e-15;

    public KataFindAverageTest() {
    }

    @Test
    public void testFind_average() {

//        assertEquals(1, KataFindAverage.find_average(new int[]{1, 1, 1}), DELTA);
//        assertEquals(2, KataFindAverage.find_average(new int[]{1, 2, 3}), DELTA);
        assertEquals(0, KataFindAverage.find_average(new int[]{}), DELTA);
    }

}
