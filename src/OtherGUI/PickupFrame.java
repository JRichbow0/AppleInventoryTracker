/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherGUI;

import OtherGUI.Pickup;
import OtherGUI.DeviceFrame;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.awt.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mysqltest.MainFrame;
/**
 *
 * @author jrichb2
 */
public class PickupFrame extends javax.swing.JPanel {

    
    private static final String ID = "jrichb2";
    private static final String PW = "COSC*jopbp";
    private static final String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/"+ID+"db";
      
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    
    public PickupFrame() {
        initComponents();
        show_pickup();
    }

  public ArrayList<Pickup> pickupDateList(){
      ArrayList<Pickup> pickupDatesList = new ArrayList<>();
       try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection(SERVER, ID, PW); 
         stmt = con.prepareStatement("SELECT * FROM jrichb2db.Pickup");
         rs = stmt.executeQuery();
         Pickup pickup;
         while(rs.next()){
          pickup = new Pickup(rs.getString("Name"),rs.getString("DeviceName"),rs.getString("SerialNumber"),rs.getString("PickupDate"),rs.getString("PaidFor"));
          pickupDatesList.add(pickup);
         }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
       return pickupDatesList;
    }

 public final void show_pickup(){
        ArrayList<Pickup> list = pickupDateList();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i <list.size(); i++){
         row[0]=list.get(i).getName();
         row[1]=list.get(i).getDeviceName();
         row[2]=list.get(i).getSerialNumber();
         row[3]=list.get(i).getPickupDate();
         row[4]=list.get(i).getPaidFor();
         model.addRow(row);
        }
    }
     public void upDateDB(){
       try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection(SERVER, ID, PW);
         stmt = con.prepareStatement("select * from jrichb2db.Pickup");
         rs = stmt.executeQuery();
           java.sql.ResultSetMetaData stData = rs.getMetaData();
         
         q = stData.getColumnCount();
         DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
         RecordTable.setRowCount(0);
         
         while(rs.next()){
             Vector columnData = new Vector();
             for(i=1; i <= q; i++){
              columnData.add(rs.getString("Name"));
              columnData.add(rs.getString("DeviceName"));
              columnData.add(rs.getString("SerialNumber"));
              columnData.add(rs.getString("PickupDate"));
              columnData.add(rs.getString("PaidFor"));
             }
             RecordTable.addRow(columnData);
         }
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);
        }
    
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbtnAdd = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnPrint = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        toCustomer = new javax.swing.JButton();
        toDevice = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setForeground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText(" Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 260, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Device Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Serial Number");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pickup Date");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Paid For");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 260, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 260, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 260, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 260, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "DeviceName", "SerialNumber", "PickupDate", "PaidFor"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 660, 460));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 690, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Apple Inventory Tracker");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 470, -1));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnAdd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnAdd.setText("Add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 50, 218, -1));

        jbtnDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 353, 218, -1));

        jbtnReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnReset.setText("Reset");
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 281, 218, -1));

        jbtnPrint.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnPrint.setText("Print");
        jbtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 211, 218, -1));

        jbtnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 136, 218, -1));

        jbtnExit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 424, 218, 35));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 240, 500));

        toCustomer.setBackground(new java.awt.Color(0, 153, 153));
        toCustomer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        toCustomer.setText("Customer");
        toCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(toCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 170, -1));

        toDevice.setBackground(new java.awt.Color(0, 153, 153));
        toDevice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        toDevice.setText("Device");
        toDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDeviceActionPerformed(evt);
            }
        });
        jPanel1.add(toDevice, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();

        jTextField1.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        jTextField2.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        jTextField3.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        jTextField4.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        jTextField5.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(SERVER, ID, PW);
            stmt = con.prepareStatement("insert into jrichb2db.Pickup(Name, DeviceName, SerialNumber, PickupDate, PaidFor) value(?,?,?,?,?)");
            stmt.setString(1, jTextField1.getText());
            stmt.setString(2, jTextField2.getText());
            stmt.setString(3, jTextField3.getText());
            stmt.setString(4, jTextField4.getText());
            stmt.setString(5, jTextField5.getText());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added");
            upDateDB();
        }catch(ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(PickupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(PickupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        try{
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm that you want to delete item", "WARNING", JOptionPane.YES_NO_OPTION);
            if(deleteItem == JOptionPane.YES_OPTION){
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(SERVER, ID, PW);
                stmt = con.prepareStatement("delete from jrichb2db.Pickup where id =?");
                stmt.setInt(1, id);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Pickup Record Updated.");
                upDateDB();

                jTextField1.setText("");
                jTextField1.requestFocus();
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");

            }
        } catch(ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(PickupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");

    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintActionPerformed
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("Page (0, number, integer)");

        try{
            jTable1.print(JTable.PrintMode.NORMAL,header,footer);
        }
        catch(java.awt.print.PrinterException e){
            System.err.format("No Printer Found", e.getMessage());
        }
    }//GEN-LAST:event_jbtnPrintActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(SERVER, ID, PW);
            stmt = con.prepareStatement("update jrichb2db.Pickup set Name =? DeviceName =?, SerialNumber =?, PickupDate =? PaidFor =? where id =?");
            stmt.setString(1, jTextField1.getText());
            stmt.setString(2, jTextField2.getText());
            stmt.setString(3, jTextField3.getText());
            stmt.setString(4, jTextField4.getText());
            stmt.setString(5, jTextField5.getText());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Updated");
            upDateDB();
        }catch(ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(PickupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed
    private JFrame frame;
    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Confirm Exit", "Apple Inventory Tracker", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void toCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCustomerActionPerformed
        //This will open the Customer JFrame
        MainFrame mf1 = new MainFrame();
        mf1.show();
        mf1.dispose();
    }//GEN-LAST:event_toCustomerActionPerformed

    private void toDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDeviceActionPerformed
        //This will open the Device JFrame
        DeviceFrame df = new DeviceFrame();
        df.show();
        df.dispose();
    }//GEN-LAST:event_toDeviceActionPerformed

public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PickupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PickupFrame().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JButton toCustomer;
    private javax.swing.JButton toDevice;
    // End of variables declaration//GEN-END:variables
}
