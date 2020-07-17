  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

//import classes.toolss;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Connection1 {
    private static Connection c;
    private final String dbname = "electricity";
    private final String url = "jdbc:mysql://localhost:3306/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
    
        
    

    public Connection connect() throws SQLException {
       // m = DriverManager.getConnection(url, "root", "");
        c = (Connection)DriverManager.getConnection(url , "root" , "");
        return c;
 
    }
}
