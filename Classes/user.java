/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DB.Connection1;
import static classes.admin.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Instant.now;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class user {

    public ResultSet log(String username, String password) {
        Connection con;
        Connection1 conn = new Connection1();
        PreparedStatement pst;
        try {

            con = conn.connect();
            String query = "select * from users where username = ? and password = ? and approval = 1";

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
     public String Calender(){
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String date = year+"-"+(month+1)+"-"+day;
        return date;
    }

    public  void insert (String username,String password,String email , String region, String gender , String image){
           Connection con;
           Connection1 db = new Connection1();
           PreparedStatement  pst2;
         //  String date = Calender();
           
        try {            
            
            con = db.connect();            
            String query = "insert into users(username,password,email,region, gender,image) VALUES (?,?,?,?,?,?)";
            pst2 = con.prepareStatement(query);
            pst2.setString(1, username);
            pst2.setString(2, password);
            pst2.setString(3, email);
            pst2.setString(4, region);
            pst2.setString(5, gender);
            try {
            InputStream img = new FileInputStream(new File(image));
            pst2.setBlob(6, img);
            
            pst2.execute();
            JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, " Sorry \n You have not been registrated", "Registeration", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception ex){
            ex.printStackTrace();
       }
       
       }
    
    
     public int Calender2(){
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        return month+1;
    }
     public int Calender3(){
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        return year;
    }
    public  void pay (int  money , int userid  ,int mreading){
           Connection con;
           Connection1 db = new Connection1();
           PreparedStatement  pst2;
           int date = Calender2();
           int year = Calender3();
        try {            
            
            con = db.connect();            
            String query = "insert into bill(bill,month,userid,mreading,year) VALUES (?,?,?,?,?)";
            pst2 = con.prepareStatement(query);
            pst2.setInt(1, money);
            pst2.setInt(2, date);
            pst2.setInt(3, userid);
            pst2.setInt(4, mreading);
            pst2.setInt(5, year);
            pst2.execute();
            JOptionPane.showMessageDialog(null, " Congratz \n You Have Been Payed", "Registeration", JOptionPane.CANCEL_OPTION);
    
        }catch (Exception ex){
            ex.printStackTrace();
       }
       
       }
}
