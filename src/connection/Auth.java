/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Charindu Kavishan
 */
public class Auth {
    public static boolean signin(String uName, String password,boolean isAdmin) throws SQLException{
        
        if(isAdmin){
            ResultSet user = AdminTableModel.getUser(uName);
            while (user.next()) {
                if (user.getString("password").equals(password)){
                    System.out.println(password);
                    System.out.println(user.getString("password"));
                    User.setUser(user.getInt("idadmin"), user.getString("uname"), user.getString("email"), user.getString("fname"), user.getString("age"), user.getString("nic"),true);
                    return true;
                }            
            }
        
        return false;
        }else{
            ResultSet user = StudentTableModel.getUser(uName);
            while (user.next()) {
                if (user.getString("password").equals(password)){
                    System.out.println(password);
                    System.out.println(user.getString("password"));
                    User.setUser(user.getInt("id"), user.getString("uname"), user.getString("email"), user.getString("fname"), user.getString("age"), user.getString("nic"),false);
                    return true;
                }            
            }

            return false;
        }
        
    }
    
}
