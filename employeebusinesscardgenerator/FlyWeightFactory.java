/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeebusinesscardgenerator;

import java.util.HashMap;

/**
 * Only FlyWeightFactory can create flWeight based on particular division
 * @author Admin
 */

//make private constructor
public class FlyWeightFactory {
    
    //hash map that will be used to retrive flyweight obj
    private static final HashMap<String,FlyWeight> lstFlyWeight = new HashMap(); 
    private static FlyWeightFactory factory; //singleton design
    
    static{
        lstFlyWeight.put("north", new FlyWeight("North Company","North Address","North City","North State","North Zip"));
        lstFlyWeight.put("east", new FlyWeight("East Company","East Address","East City","East State","East Zip"));
        lstFlyWeight.put("south", new FlyWeight("South Company","South Address","South City","South State","South Zip"));
        lstFlyWeight.put("west", new FlyWeight("West Company","West Address","West City","West State","West Zip"));
    }
    
    /*this flyweight class will not be accessible outside this factory . only accessible through interface*/
    static class FlyWeight implements FlyWeightIntr{
 
    //fields
    private String company;
    private String address;
    private String city;
    private String state;
    private String zip;
    
    public FlyWeight(String company, String address, String city, String state, String zip){
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }   
    
}

    
    /*
     *  Get the sole object FlyWeight for a specific division
     *  Employees of the same division share the same object
     */
    
    //factory design - get the flyweight based on input
    public synchronized FlyWeightIntr getFlyweight(String division){
        
          FlyWeightIntr flyWeight = lstFlyWeight.get(division.toLowerCase());
          //contains keys forst to checkif there
          
          //if no division exist, i.e. no unique obj, create it and add to HashMap
         /* if(flyWeight == null) {
            flyWeight = new FlyWeight(division);
            lstFlyWeight.put(division, flyWeight);
            System.out.println("Creating flyWeight of division : " + division);
          }*/ 
          
          return flyWeight;
          
    }
    
    /*
     * Get the single instance of the FlyWeight Factory
     * Part of Singleton Design Pattern
     */
    public static FlyWeightFactory getInstance(){
        
           if (factory == null)
            factory = new FlyWeightFactory();
        return factory;
    }

}
