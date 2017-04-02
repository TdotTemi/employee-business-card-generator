/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeebusinesscardgenerator;

/**
 * Composite class pattern will have the uniform methods for its subclasses
 * Here we are creating all concrete methods with an exception
 * They can choose to override it when implementing it or the default exception
 * @author Admin
 */
public abstract class ContactComponent {
    
    public ContactComponent(){
        
    }
    
    //choose to override wih own implementation or will throw this when called
    //if doesnt implement this
    public void add(ContactComponent nContactComponent){
        throw new UnsupportedOperationException();
    }
    
    public void listContactDetails(){
        throw new UnsupportedOperationException();
    }
    
    //abstract methods
    //abstract void add(ContactComponent contactComponent);
    
    // abstract void listContactDetails();
             

}
