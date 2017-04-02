/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeebusinesscardgenerator;

/**
 *
 * @author Admin
 */
public class VCard {

    String name;
    String title;
    String phone;
    FlyWeightIntr objFW;

    public VCard(String n, String t, String phone, FlyWeightIntr fw) {
        name = n;
        title = t;
        this.phone = phone;
        objFW = fw;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
    
     public String getPhone() {
        return phone;
    }

    public FlyWeightIntr getObjFW() {
        return objFW;
    }
    
    

    public void print() {
        System.out.println(name);
        System.out.println(title);
        System.out.println(objFW.getAddress() + "-"
                + objFW.getCity() + "-"
                + objFW.getState() + "-"
                + objFW.getZip());
        System.out.println(" - - - - - - - ");
    }
}
