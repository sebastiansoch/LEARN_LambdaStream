/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

/**
 *
 * @author ssoch
 */
public class BlokerFactory {

    static Bloker create() {
//        return new Bloker() {
//            @Override
//            public boolean isAllowed(String name) {
//                if (name.startsWith("A")) {
//                    return true;
//                }
//                return false;
//            }
//        };
        return name -> name.startsWith("A");
    }
}
