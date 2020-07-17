/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import DB.Connection1;
import classes.operator;
import static gui.admin1.con;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author karim hassan
 */
public class Login_operator extends JFrame implements ActionListener {

    
    JButton b1,b2;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    
    static PreparedStatement pst;
    static PreparedStatement pst2;
    static Connection con;
    static ResultSet s;
    static ResultSet s2;
    static ResultSet s3;
    public Login_operator() {
     
        this.setSize(600, 600);
        this.setTitle("Log in as operator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Connection1 conn = new Connection1();
        try {
            con = (Connection) conn.connect();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        l1 = new JLabel("Full name :");
        l2 = new JLabel("Password :");
        t1 = new JTextField();
        t2 = new JPasswordField();
        b1 = new JButton("Log in");
        b2 = new JButton("Back");
        
        this.setLayout(null);
        l1.setBounds(50, 150, 100, 30);
        l2.setBounds(50, 250, 100, 30);
        t1.setBounds(190, 150, 250, 30);
        t2.setBounds(190, 250, 250, 30);
        b1.setBounds(190, 350, 100, 30);
        b2.setBounds(310, 350, 100, 30);
        this.add(l1);this.add(l2);
        this.add(t1);this.add(t2);
        this.add(b1);this.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getSource()==b1)
            {
                operator op = new operator();
        s = op.log(t1.getText() , t2.getText());
         try {
            if(s.next()){
                this.dispose();
                new operator1().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Your name or password is incorrect","Warning",JOptionPane.ERROR_MESSAGE);
                t2.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_login.class.getName()).log(Level.SEVERE, null, ex);
        }
              
            }
             if(e.getSource()==b2)
            {
              this.dispose();
              new login().setVisible(true);
              
            }
    }
    
    
    
    
    
    
    
}
