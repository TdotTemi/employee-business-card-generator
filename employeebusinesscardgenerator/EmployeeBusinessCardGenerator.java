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
public class EmployeeBusinessCardGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Emp emp1 = new Emp("Tom", "CEO", "North", "647-575-4628");
        EmpBizCardDesign1 design1 = new EmpBizCardDesign1();
        EmpBizCardGenFacade empBizCardGenFacade = new EmpBizCardGenFacade(emp1,design1,100);
        empBizCardGenFacade.generateBusinessCard();
        
        EmpBizCardDesign2 design2 = new EmpBizCardDesign2();
        EmpBizCardGenFacade empBizCardGenFacade2 = new EmpBizCardGenFacade(emp1,design2,100);
        empBizCardGenFacade2.generateBusinessCard();
    }
    
}
