/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeebusinesscardgenerator;

/**
 * Without interface, wont have access to any of these methods in FlyWeightClass because 
 * @author Admin
 */
public interface FlyWeightIntr {
    
    
    public String getCompany();

    public String getAddress();

    public String getCity();

    public String getState();

    public String getZip();
}
