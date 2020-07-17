/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import DB.Connection1;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class nnn {
    static Connection con;
    static String query;
    static Statement ss;
    static Scanner s = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection1 conn = new Connection1();
        try{
            con = conn.connect();
            System.out.println(" good");
        }
        catch(Exception e){
            System.out.println("not good");
        }
    }
    
}
