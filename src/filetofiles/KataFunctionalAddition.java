/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

import java.util.function.IntUnaryOperator;

/**
 *
 * @author ssoch
 */
public class KataFunctionalAddition {

    public static IntUnaryOperator add(int n) {

    return operand -> operand + n;
//        return new IntUnaryOperator() {
//            @Override
//            public int applyAsInt(int operand) {
//                return operand + n;
//            }
//        };
    }
}
