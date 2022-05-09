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
public class Device {

    
    private String DeviceName, SerialNumber, Color, Warranty;
    private int Storage;
    
    public Device(String DeviceName, String SerialNumber, String Color,  int Storage, String Warranty)
    {
     this.Color = Color;
     this.Storage = Storage;
     this.DeviceName = DeviceName;
     this.SerialNumber = SerialNumber;
     this.Warranty = Warranty;
    }
    public String getDeviceName(){
     return DeviceName;
    }
    
    public String getSerialNumber(){
    return SerialNumber;
    }
    
    public String getColor(){
    return Color;
    }
    
    public int getStorage(){
     return Storage;
    }
    
    public String getWarranty(){
     return Warranty;
    }
} 

