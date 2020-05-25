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
 * @author ASUS
 */
public class SemesterTableModel {
     public static ResultSet getAllSemesters() throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select * from semester");
      
        return  preparedStatement.executeQuery();
    }
}
