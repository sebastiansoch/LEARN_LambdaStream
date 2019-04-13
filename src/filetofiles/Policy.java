/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetofiles;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 *
 * @author ssoch
 */
public class Policy implements Comparable<Policy>{
    private int number;
    private int price;
    private int status;

    public Policy(int number, int price, int status) {
        this.number = number;
        this.price = price;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public int compareTo(Policy other) {
        if (this.price > other.price) {
            return 1;
        }
        if (this.price < other.price) {
            return -1;
        }
        
        return 0;
    }

    @Override
    public String toString() {
        return "Policy{" + "number=" + number + ", price=" + price + ", status=" + status + '}';
    }
    
    
}
