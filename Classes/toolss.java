package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class toolss {
    public static void msgbox(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }
    
    public static void openform(JFrame form){
        
        try {
            form.setLocationRelativeTo(null);
            Image img = ImageIO.read(toolss.class.getResource("cam.png"));
            form.setIconImage(img);
            form.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(toolss.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Object inputbox(String title){
        return JOptionPane.showInputDialog(title);
   //     return obj;
    }
}

