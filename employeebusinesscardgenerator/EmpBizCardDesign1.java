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
public class EmpBizCardDesign1 implements BusinessCardDesigner {

    @Override
    public String designBusinessCard(VCard vCard) {
        FlyWeightIntr flyWeightIntr = vCard.getObjFW();
        String design ="";
        design+= "________________________________________________________\n";
        String logo = "\n( ͡°( ͡° ͜ʖ( ͡° ͜ʖ ͡°)ʖ ͡°) ͡°)\n\n";
        design +=logo;
         design += "Name: " + vCard.getName() + "\nTitle: " + vCard.getTitle()
                 + "\nTitle: " + vCard.getPhone() +
                "\nAddress: " + flyWeightIntr.getAddress() +  "\nCity: "
                + flyWeightIntr.getCity() + "\nCompany: " + flyWeightIntr.getCompany();
        String footer = "\n(ง'̀-'́)ง\n\n";
        design+=footer;
        design+= "\n________________________________________________________\n";
        return design;
    }

}
