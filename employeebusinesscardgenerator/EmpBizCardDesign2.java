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
public class EmpBizCardDesign2 implements BusinessCardDesigner {

    @Override
    public String designBusinessCard(VCard vCard) {
        FlyWeightIntr flyWeightIntr = vCard.getObjFW();
        String design ="";
        design+= "________________________________________________________\n";
        String logo = "\n(͡° ͜ʖ ͡°)\n\n";
        design +=logo;
         design += vCard.getName() + ", " + vCard.getTitle() + "\n" 
                 + vCard.getPhone() + "\n"+ flyWeightIntr.getCompany()
                + "\n"  + flyWeightIntr.getAddress() +  ", "
                + flyWeightIntr.getCity() ;
        String footer = "\n(◕‿◕✿)\n\n";
        design+=footer;
        design+= "\n________________________________________________________\n";
        return design;
    }
    
}
