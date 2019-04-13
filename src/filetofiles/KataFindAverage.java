/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

import static java.util.Arrays.stream;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 *
 * @author ssoch
 */
public class KataFindAverage {

//    public static double find_average(int[] array) {
//        final DoubleWrapper sum = new DoubleWrapper();
//        stream(array).forEach(x -> sum.sum += x);
//        return sum.sum / array.length;
//    }
//
//    private static class DoubleWrapper {
//
//        public double sum = 0;
//    }
    
    public static double find_average(int[] array) {
        return stream(array).average().orElse(0);
//        return stream(array).average().getAsDouble();
    }
}
