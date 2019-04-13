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
@FunctionalInterface
public interface Bloker {
    boolean isAllowed(String name);
}
