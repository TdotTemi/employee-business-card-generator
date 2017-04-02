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
public class ContactClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ContactComponent myFriends = new ContactGroup("Friends","All my friends");
        ContactComponent myRelatives = new ContactGroup("Relatives","All my relatives");

        ContactComponent allContact = new ContactGroup("All Contacts", "All My Contacts");

        allContact.add(myFriends);

        myFriends.add(new Contact("Jack", "Baur", "jack.baur@somemail.com", "416-999-3333"));
        myFriends.add(new Contact("George", "Mason", "George.mason@somemail.com", "416-999-3334"));
        myFriends.add(new Contact("Nina", "Mason", "Nina.Mason@somemail.com", "416-999-3335"));

        allContact.add(myRelatives);

        myRelatives.add(new Contact("Ron", "Baur", "jack.baur@somemail.com", "416-999-3333"));
        myRelatives.add(new Contact("Rose", "Mason", "George.mason@somemail.com", "416-999-3334"));
        myRelatives.add(new Contact("Ram", "Mason", "Nina.Mason@somemail.com", "416-999-3335"));

        allContact.listContactDetails(); 
    }
    
}
