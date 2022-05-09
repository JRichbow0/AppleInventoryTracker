/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author jrichb2
 */
public class MySqlTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
         System.out.println(e);
        }
        final String ID = "jrichb2";
        final String PW = "COSC*jopbp";
        final String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/"+ID+"db";
        
        try{
         Connection con = DriverManager.getConnection(SERVER, ID, PW);
         Statement stmt = con.createStatement();
         
         ResultSet rs = stmt.executeQuery("Select * from jrichb2db.Customer");
         
         while(rs.next()){
             String Name = rs.getString("Name");
             String DeviceType = rs.getString("DeviceType");
             String SerialNumber = rs.getString("SerialNumber");
             String PurchaseKind = rs.getString("PurchaseKind");
             String Color = rs.getString("Color");
             String Storage = rs.getString("Storage");
             System.out.println(Name + ", " + DeviceType + ", " + SerialNumber + ", "
             + PurchaseKind + ", " + Color + ", " + Storage);        
         }
        }catch(SQLException e){
          System.err.println(e);
        }
        
    } //end of main
} //end of class
