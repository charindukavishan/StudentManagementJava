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
     public static String getSemestersName(int sId) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select * from semester where idsemester=?");
        preparedStatement.setInt(1, sId);
        ResultSet rs = preparedStatement.executeQuery();
        String sName = null;
        while(rs.next()){
            sName =  rs.getString("name");
        } 
        return sName;
    }
}
