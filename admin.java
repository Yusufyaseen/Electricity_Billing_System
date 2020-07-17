/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.*;
import DB.Connection1;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author hp
 */

public class admin implements login{
    //    static Connection con;
     //   static PreparedStatement pst;
        static ResultSet s ;
        String name;
        String password;
        int age;
        
      
       public  void insertuser (String name,String password,String email,String region,String gender,String image) throws FileNotFoundException{
           Connection con;
           Connection1 db = new Connection1();
           PreparedStatement  pst2;
        try {            
            
            con = db.connect();            
            String query = "insert into users(username,password,region,email,gender,image) VALUES (?,?,?,?,?,?)";

            pst2 = con.prepareStatement(query);
            pst2.setString(1, name);
            pst2.setString(2, password);
            pst2.setString(3, region);
            pst2.setString(4, email);
            pst2.setString(5, gender);
            try{
            InputStream img = new FileInputStream(new File(image));
            pst2.setBlob(6, img);
            
      
            pst2.execute();
            JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, " Sorry \n You have not been registrated", "Registeration", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
       }
       
       }
       
       /* public  ResultSet log(){
           Connection con;
           Connection1 db = new Connection1();
            PreparedStatement  pst2;
        try {            
            
            con = db.connect();            
            String query = "select * from admin where username = ? and password = ?";

            pst2 = con.prepareStatement(query);
            s = pst2.executeQuery();
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
            finally{return s;}
       
        }*/

    @Override
    public ResultSet log(String name, String password) {
        Connection con;
        Connection1 conn = new Connection1(); 
        PreparedStatement  pst;
        try {            
            
            con = conn.connect();            
            String query = "select * from admin where username = ? and password = ?";

            pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, password);
            s = pst.executeQuery();
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
       finally{return s;}
        }
    public void deleteuser(int id){
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
    public void updateuser(String username , String region , String email,int id){
        Connection con;
        Connection1 conn = new Connection1(); 
        PreparedStatement  pst;
         try {            
            
            con = conn.connect();            
            String query = "update users set username = ?,region = ?,email = ?  where id = ?";

            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, region);
            pst.setString(3, email);
            pst.setInt(4, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "You have been updated");
            
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
         
    }
     public void deleteoperator(int id){
        Connection con;
        Connection1 conn = new Connection1(); 
        PreparedStatement  pst;
         try {            
            
            con = conn.connect();            
            String query = "delete from operator where id = ?";

            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "You have been deleted");
            
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
    }
      public void updateoperator(String username,int password){
        Connection con;
        Connection1 conn = new Connection1(); 
        PreparedStatement  pst;
         try {            
            
            con = conn.connect();            
            String query = "update operator set username = ? where id = ?";

            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setInt(2, password);
            pst.execute();
            JOptionPane.showMessageDialog(null, "You have been updated");
            
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
         
    }
       public  void insertoperator (String name,String password){
           Connection con;
           Connection1 db = new Connection1();
           PreparedStatement  pst2;
        try {            
            
            con = db.connect();            
            String query = "insert into operator(username,password) VALUES(?,?)";

            pst2 = con.prepareStatement(query);
            pst2.setString(1, name);
            pst2.setString(2, password);
            pst2.execute();
            JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
    
        }catch (SQLException ex){
            ex.printStackTrace();
       }
       
       }
       
       
        public void deleteadmin(int id){
        Connection con;
        Connection1 conn = new Connection1(); 
        PreparedStatement  pst;
         try {            
            
            con = conn.connect();            
            String query = "delete from admin where id = ?";

            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "You have been deleted");
            
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
    }
      public void updateadmin(String username,String email,int id){
        Connection con;
        Connection1 conn = new Connection1(); 
        PreparedStatement  pst;
         try {            
            
            con = conn.connect();            
            String query = "update admin set username = ?,email = ? where id = ?";

            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setInt(3, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "You have been updated");
            
            
            //JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
            
        }catch (SQLException ex){
            ex.printStackTrace();
       }
         
    }
       public  void insertadmin (String name,String password,String email){
           Connection con;
           Connection1 db = new Connection1();
           PreparedStatement  pst2;
        try {            
            
            con = db.connect();            
            String query = "insert into admin(username,password,email) VALUES(?,?,?)";

            pst2 = con.prepareStatement(query);
            pst2.setString(1, name);
            pst2.setString(2, password);
            pst2.setString(3, email);
            pst2.execute();
            JOptionPane.showMessageDialog(null, " Congratz \n You have been registrated", "Registeration", JOptionPane.CANCEL_OPTION);
    
        }catch (SQLException ex){
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
       public ResultSet showByRegion(String region){
           Connection con;
           Connection1 db = new Connection1();
           PreparedStatement  pst2;
           int month = Calender2();
           int year = Calender3();
        try {            
            
            con = db.connect();            
            String query = "select billing.* ,  bill.bill , bill.mreading , users.username from billing  join bill on billing.userid  = bill.userid join users on billing.userid  = users.id where region = ? and month = ? and year = ?";
            pst2 = con.prepareStatement(query);
            pst2.setString(1,region);
            pst2.setInt(2,month);
            pst2.setInt(3,year);
            s = pst2.executeQuery();   
             
        }catch (SQLException ex){
            
       }finally{
            return s;
        }
      
       }
       public ResultSet totalCollected(){
           Connection con;
           Connection1 db = new Connection1();
           PreparedStatement  pst2;
           int month = Calender2();
           int year = Calender3();
        try {            
            
            con = db.connect();            
            String query = "select sum(bill) from bill where month = ? and year = ?";
            pst2 = con.prepareStatement(query);
            pst2.setInt(1,month);
            pst2.setInt(2,year);
            s = pst2.executeQuery();   
             
        }catch (SQLException ex){
            
       }finally{
            return s;
        }
       }
    }
