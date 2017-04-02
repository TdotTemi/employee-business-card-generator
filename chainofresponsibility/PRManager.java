/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibility;

/**
 *  Client
 * @author Admin
 */
public class PRManager {

    private BranchManager branchManager;
    private RegionalDirector regionalDirector;
    private VicePresident vicePresident;
    private PresidentCOO coo;

    public static void main(String[] args) {
        PRManager manager = new PRManager();
        manager.createAuthorizationFlow();
        BizCardRequest request = new BizCardRequest(10000);
        manager.branchManager.authorize(request);
        request = new BizCardRequest(175000);
        manager.branchManager.authorize(request);
        request = new BizCardRequest(800000);
        manager.branchManager.authorize(request);
    }

    public void createAuthorizationFlow() {
        branchManager = new BranchManager("Robin");
        regionalDirector = new RegionalDirector("Oscar");
        vicePresident = new VicePresident("Kate");
        coo = new PresidentCOO("Drew");
        branchManager.setNextHandler(regionalDirector);
        regionalDirector.setNextHandler(vicePresident);
        vicePresident.setNextHandler(coo);
    }

}
