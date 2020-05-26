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
public class CourseTableModel {
    
    public static ResultSet getAllCourses() throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select * from course");      
        return  preparedStatement.executeQuery();
    }
    
    public static void addCourse(String moduleid,String name,String semesterName,double fee,String description) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO course (moduleid,name,idsem,fee,description)"
                + " VALUES (?, ?,(select idsemester from semester where name=?), ?, ?)");
        preparedStatement.setString(1, moduleid);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, semesterName);
        preparedStatement.setDouble(4, fee);
        preparedStatement.setString(5, description);
 
        preparedStatement.executeUpdate();
    }
}
