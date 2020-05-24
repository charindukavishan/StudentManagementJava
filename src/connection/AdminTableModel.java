/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Charindu Kavishan
 */
public class AdminTableModel {

    public static void insert(String fname,String lname,String uname,String password,String nic,String email) throws SQLException{
        PreparedStatement query = MySqlConnection.getInstance().connection.prepareStatement("insert into admin (fname,lname,uname,password,nic,email) values (?,?,?,?,?,?)");
        query.setString(1, fname);
        query.setString(2, lname);
        query.setString(3, uname);
        query.setString(4, password);
        query.setString(5, nic);
        query.setString(6, email);
        
        query.executeUpdate();
    }
    
    public static ResultSet getUser(String uname) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        //System.out.println(con);
        PreparedStatement query = MySqlConnection.getInstance().connection.prepareStatement("select * from admin where uname=?");
        query.setString(1, uname);
        return  query.executeQuery();
    }
    
}
