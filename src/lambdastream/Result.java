/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdastream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ssoch
 */
public class Result {
    private Set<String> offerers = new TreeSet<>();
    private Integer quantity = 0;

    public Result() {
    }

    public void putOfferers(String offerer) {
        offerers.add(offerer);
    }
    
    public void addTickets(int count) {
        quantity += count;
    }
    
    public Set<String> getOfferers() {
        return offerers;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return quantity + " ; " + offerers;
    }
    
    
}
