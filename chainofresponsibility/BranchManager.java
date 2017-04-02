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
public class BranchManager extends PRHandler{
    
    public BranchManager(String name){
        super(name);
        setAuthorizationLimit(25000);
    }
    
    
}
