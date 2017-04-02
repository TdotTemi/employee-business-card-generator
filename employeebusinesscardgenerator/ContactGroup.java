/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeebusinesscardgenerator;

import java.util.ArrayList;
import java.util.List;

/**
 *A group of contacts
 * @author Admin
 */
public class ContactGroup extends ContactComponent {
    
    //list to hold both types of contacts
    //define final if value not change for e.g if only called in constructor once
    //for collections, can still add to it just cant change what variable is referencing
    
    private List<ContactComponent> contactBook = new ArrayList<>();
    private String groupName;
    private String groupDescription;
    
        public ContactGroup(String groupName, String groupDescription){
            this.groupName = groupName;
            this.groupDescription = groupDescription;
        }

    public String getGroupName() {
        return groupName;
    }
    
     public String getGroupDescription() {
        return groupDescription;
    }
        
        
    
        
        /*
         * Adds a contact component to this contact group's contact book
         */
        
        @Override
        public void add(ContactComponent contactComponent){
            
            contactBook.add(contactComponent);
            
        }
        
        /*
         * List contents of contact group
         */
        
        @Override
        public void listContactDetails(){
            for (ContactComponent contact : contactBook){ //loop through contact book
                /*if ("ContactGroup".equals(contact.getClass().getSimpleName())){ //check time - if another book loop through again
                    System.out.println(((ContactGroup)contact).getGroupName());
                    ((ContactGroup)contact).listContactDetails(); //cast contact Group to correct class and recursively call method
                }else{
                    ((Contact)contact).listContactDetails(); //if contact, cast and call its listContactDetails method to print
                }*/
                
                //above is unneccesary, if depending on its type, it will call the correct method in the correct class - no need to check and specify
                
                contact.listContactDetails();
            }
        }
}
