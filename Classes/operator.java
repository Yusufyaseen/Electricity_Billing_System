/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DB.Connection1;
import static classes.admin.s;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class operator {

    static ResultSet s;
    static ResultSet s2;

    public ResultSet log(String username, String password) {
        Connection con;
        Connection1 conn = new Connection1();
        PreparedStatement pst;
        try {

            con = conn.connect();
            String query = "select * from operator where username = ? and password = ?";

            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            s = pst.executeQuery();

            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return s;
        }
    }

    public ResultSet payments(int metercode) {
        Connection con;
        Connection1 db = new Connection1();
        PreparedStatement pst2;
        try {

            con = db.connect();
            String query = "select billing.* , sum(bill) ,  users.username from billing  join bill on billing.userid  = bill.userid join users on billing.userid  = users.id where metercode = ? ";
            pst2 = con.prepareStatement(query);
            pst2.setInt(1, metercode);
            s = pst2.executeQuery();

        } catch (SQLException ex) {

        } finally {
            return s;
        }

    }

    public int Calender2() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        return month + 1;
    }

    public int Calender3() {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public ResultSet bill(int metercode) {
        Connection con;
        Connection1 db = new Connection1();
        PreparedStatement pst0;
        int month = Calender2();
        int year = Calender3();
        try {
            con = db.connect();
            String query = "select billing.* ,  bill.bill , bill.mreading , users.username  from billing  join bill on billing.userid  = bill.userid join users on billing.userid  = users.id where metercode = ? and month = ? and year = ? ";
            pst0 = con.prepareStatement(query);
            pst0.setInt(1, metercode);
            pst0.setInt(2, month);
            pst0.setInt(3, year);
            s2 = pst0.executeQuery();
        } catch (SQLException ex) {

        }
        return s2;

    }

    public ResultSet showByRegion(String region) {
        Connection con;
        Connection1 db = new Connection1();
        PreparedStatement pst2;
        int month = Calender2();
        int year = Calender3();
        try {

            con = db.connect();
            String query = "select billing.* ,  bill.bill , bill.mreading , users.username from billing  join bill on billing.userid  = bill.userid join users on billing.userid  = users.id where region = ? and month = ? and year = ?";
            pst2 = con.prepareStatement(query);
            pst2.setString(1, region);
            pst2.setInt(2, month);
            pst2.setInt(3, year);
            s = pst2.executeQuery();

        } catch (SQLException ex) {

        } finally {
            return s;
        }

    }

    public void setTarrif(int tarrif) {
        Connection con;
        Connection1 db = new Connection1();
        PreparedStatement pst2;
        try {
            con = db.connect();
            String query = "update tarrif set tarrif = ?";
            pst2 = con.prepareStatement(query);
            pst2.setInt(1, tarrif);
            pst2.execute();
            JOptionPane.showMessageDialog(null, "You Have Been Updated The Tarrif");

        } catch (SQLException ex) {

        }
    }
    
     public void deleteUser(int id){
        Connection con;
        Connection1 conn = new Connection1(); 
        PreparedStatement  pst;
         try {            
            
            con = conn.connect();            
            String query = "delete from users where id = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "You have been deleted");
            
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
    }

}
