/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibility;

/**
 *
 * @author Admin
 */
public abstract class PRHandler {
    
    private PRHandler nextHandler;
    private String name;
    private double authorizationLimit;
    
    public PRHandler(String name){
        this.name = name;
    }
    
    public void setAuthorizationLimit(double limit){
        this.authorizationLimit = limit;
    }
    
    public void setNextHandler(PRHandler handler){
        this.nextHandler = handler;
    }
    
    public void authorize(BizCardRequest request){
        Boolean isAuthorized = false;
        if(this.authorizationLimit > request.getAmount()){
            //can authorize
            System.out.println(this.getClass().getSimpleName() + " " + name + " has authorized the PR - "
         + request.getAmount());
            isAuthorized = true;
        }
        
        //if not authorized yet
        else if(this.nextHandler !=null){
            nextHandler.authorize(request);
        }
        
        //if not authorized yet
        else if(!isAuthorized){
            System.out.println("PR-" + request.getAmount() + "couldn't be authorized.\n" +
" Executive Board needs to be consulted for approval \n" +
"reason: Amount too large");
        }
    }
    
    
}
