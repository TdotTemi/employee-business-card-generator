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
public class Contact extends ContactComponent{
    
    private String fname;
    private String lname;
    private String email;
    private String phone;
    
    public Contact(String fname, String lname, String email, String phone){
        
        this.fname =fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
       
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    
    /**
     * Adds this contact to a specified contact group
     * @param contactComponent contact group to be added too
     */
    
   /* @Override
    public void add(ContactComponent contactComponent){
        
        contactComponent.add(this); //adds this contact to the specified contact component's group
    }*/
    
    @Override
    public void listContactDetails(){
        
        System.out.println( "Name: " +  fname + " " + lname + " Email: " +  email + " Phone Number : " + phone);
    }
}
