package employeebusinesscardgenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Emp {

    private String name;
    private String title;
    private String division;
    private VCard vCard;
    private String phone;
    

    public Emp(String n, String t, String d, String phone) {
        name = n;
        title = t;
        division = d;
        this.phone = phone; //employee's primary contact
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDivision() {
        return division;
    }

    public VCard getvCard() {
        return vCard;
    }

    public void setvCard(VCard vCard) {
        this.vCard = vCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    
    
    
}
