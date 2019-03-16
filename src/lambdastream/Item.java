/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdastream;

import java.util.Objects;

/**
 *
 * @author ssoch
 */
public class Item {

    private final Integer quantity;
    private final String offerer;
    private final String city;

    public Item(Integer quantity, String offerer, String city) {
        this.quantity = quantity;
        this.offerer = offerer;
        this.city = city;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getOfferer() {
        return offerer;
    }

    public String getCity() {
        return city;
    }
}
