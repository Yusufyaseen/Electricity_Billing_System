/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author karim hassan
 */
public class login extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;

    public login() {
        
        this.setSize(600, 600);
        this.setTitle("Log in");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setLocationRelativeTo(null);
       
        b1 = new JButton("Log in for Admins");
        b2 = new JButton("Log in for Operators");
        b3 = new JButton("Log in for users");
        this.setLayout(null);
        b1.setBounds(200, 150, 200, 30);
        b2.setBounds(200, 250, 200, 30);
        b3.setBounds(200, 350, 200, 30);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1)
            {
                this.dispose();
              new Login_admin().setVisible(true);
              
            }
            if(e.getSource()==b2)
            {
                this.dispose();
              new Login_operator().setVisible(true);
              
            }
            if(e.getSource()==b3)
            {
                this.dispose();
              new User_login().setVisible(true);
              
            }
    }
    
    
    
    
    
    
    
    
}
