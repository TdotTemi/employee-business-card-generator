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
public class PresidentCOO extends PRHandler {

    public PresidentCOO(String name) {
        super(name);
        setAuthorizationLimit(400000);
    }
}
