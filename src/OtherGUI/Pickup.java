/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherGUI;

/**
 *
 * @author jrichb2
 */
public class Pickup {

    private final String Name;
    private final String DeviceName;
    private final String SerialNumber;

    
    private final String PickupDate;
    private final String PaidFor;
    
    
    public Pickup(String Name, String DeviceName, String SerialNumber, String PickupDate, String PaidFor)
    {
     this.Name = Name;
     this.DeviceName = DeviceName;
     this.SerialNumber = SerialNumber;
     this.PickupDate = PickupDate;
     this.PaidFor = PaidFor;
    }
    public String getName(){
    return Name;
    }
    public String getDeviceName(){
     return DeviceName;
    }
    
    public String getSerialNumber(){
    return SerialNumber;
    }
    
    public String getPickupDate(){
    return PickupDate;
    }
    
    public String getPaidFor(){
     return PaidFor;
    }
    
} 
