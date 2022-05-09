/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;

/**
 *
 * @author jrichb2
 */
class User {
    private String Name, DeviceType, SerialNumber, PurchaseKind, Color;
    private int Storage;
    
    public User(String Name, String DeviceType, String SerialNumber, String PurchaseKind, String Color, int Storage)
    {
     this.Color = Color;
     this.Storage = Storage;
     this.Name = Name;
     this.DeviceType = DeviceType;
     this.SerialNumber = SerialNumber;
     this.PurchaseKind = PurchaseKind;
    }
    public String getName(){
     return Name;
    }
    public String getDeviceType(){
    return DeviceType;
    }
    public String getSerialNumber(){
    return SerialNumber;
    }
    public String getPurchaseKind(){
    return PurchaseKind; 
    }
    public String getColor(){
    return Color;
    }
    public int getStorage(){
     return Storage;
    }
}
