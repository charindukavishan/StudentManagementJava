/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Charindu Kavishan
 */
public class MySqlConnection {
    private static MySqlConnection instance;
    static Connection connection;
    
    private MySqlConnection() throws SQLException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmgtdb","root","");
            System.out.println(connection);
        }catch(Exception e){
           e.printStackTrace();
        }
       
    }
    
    public static MySqlConnection getInstance() throws SQLException{
        if(instance==null){
            instance = new MySqlConnection();
            System.out.println("mysql connection get instance "+connection);
        }
        
        return instance;
    }
    
}
