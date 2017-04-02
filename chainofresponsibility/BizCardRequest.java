/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibility;

/**
 *
 * @author Admin
 */
public class BizCardRequest {
        private int amount;
    
    public BizCardRequest(int amount){
        this.amount = amount;
    }
    
    public double getAmount(){
        return amount;
    }   
}
