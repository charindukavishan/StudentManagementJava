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
public class StudentTableModel {

    public static void insert(String uname,String email,String password,String fname,String age,String nic) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("insert into student (uname,email,password,fname,age,nic) values (?,?,?,?,?,?)");
        quary.setString(1, uname);
        quary.setString(2, email);
        quary.setString(3, password);
        quary.setString(4, fname);
        quary.setString(5, age);
        quary.setString(6, nic);
        
        quary.executeUpdate();
    }
    
    public static ResultSet getUser(String uname) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        System.out.println(con);
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from student where uname=?");
        quary.setString(1, uname);
        return  quary.executeQuery();
    }
    
}
