/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeebusinesscardgenerator;
import chainofresponsibility.BranchManager;
import chainofresponsibility.PresidentCOO;
import chainofresponsibility.BizCardRequest;
import chainofresponsibility.RegionalDirector;
import chainofresponsibility.VicePresident;

/**
 *
 * @author Admin
 */
public class EmpBizCardGenFacade {
    
    private Emp emp;
    private BusinessCardDesigner bizCardDesigner;
    FlyWeightFactory factory;
    private FlyWeightIntr flygweightIntr;
    private BizCardRequest purchaseRequest;
    private BranchManager branchManager;
    private int amountToOrder ;
    
    //Constructor
    public EmpBizCardGenFacade(Emp emp, BusinessCardDesigner bizCardDesigner, int amountToOrder){
        this.emp = emp;
        this.bizCardDesigner = bizCardDesigner;
        this.amountToOrder = amountToOrder;
              
    }
    
    //Service Methods
    public VCard getBizCardTemplate(){
        //use flyweight to generate business card template with needed emp info
         factory = FlyWeightFactory.getInstance();
         flygweightIntr = factory.getFlyweight(emp.getDivision());
         VCard card = new VCard(emp.getName(), emp.getTitle(),emp.getPhone(), flygweightIntr);
        //set emps current biz card
        emp.setvCard(card);
        return card;
    }
    
        public String designBusinessCard(){
        //bridge pattern
        //use the appropriate bizCardDesigner user passed
        //call interface design method
        String design = bizCardDesigner.designBusinessCard(emp.getvCard());
        
        return design;
    }
    
    public void orderBusinessCard(){
        //creates purchase request with amounth specified
        purchaseRequest = new BizCardRequest(this.amountToOrder);
        //send out chain of responsiblity call with purchase request
         createAuthorizationFlow();  //this method can be in another class prmanager
         branchManager.authorize(purchaseRequest);
        
    }
    
    public String generateBusinessCard(){
        //calls all three method
        //getBizTemplate
        getBizCardTemplate();
        //designBizCard
        String bizCardDesign = designBusinessCard();
        //orderBizCard
        orderBusinessCard();
        //finally print biz card
        return printBusinessCard(bizCardDesign);
    }
    
    public String printBusinessCard(String bizCardDesign){
        System.out.println("Printing " + this.amountToOrder + " of business cards:");
        return bizCardDesign;
    }
    
        public void createAuthorizationFlow() {
        branchManager = new BranchManager("Robin");
        RegionalDirector regionalDirector = new RegionalDirector("Oscar");
        VicePresident vicePresident = new VicePresident("Kate");
        PresidentCOO coo = new PresidentCOO("Drew");
        branchManager.setNextHandler(regionalDirector);
        regionalDirector.setNextHandler(vicePresident);
        vicePresident.setNextHandler(coo);
    }
}
