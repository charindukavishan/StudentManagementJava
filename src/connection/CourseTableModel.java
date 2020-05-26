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
    
    public static ResultSet getCoursesForTable() throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select moduleid,name,description,"
                + "fee from course where idsem=(select idsemester from semester ORDER BY idsemester LIMIT 1)");      
        return  preparedStatement.executeQuery();
    }
    
    public static ResultSet getCoursesBySemester(String semsester) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select moduleid,name,description,"
                + "fee from course where idsem=(select idsemester from semester where name=?)");  
        preparedStatement.setString(1, semsester);
        return  preparedStatement.executeQuery();
    }
    
    public static ResultSet getCoursesByModuleId(String moduleId) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select * from course where moduleid=?");  
        preparedStatement.setString(1, moduleId);
        return  preparedStatement.executeQuery();
    }
    
    public static void updateCourse(String moduleid,String name,String semesterName,
            double fee,String description,String selectedModuleId) throws SQLException{
        
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("UPDATE course set moduleid=?, name=?,"
                + "idsem=(select idsemester from semester where name=?),fee=?,description=? where moduleid=?");
        preparedStatement.setString(1, moduleid);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, semesterName);
        preparedStatement.setDouble(4, fee);
        preparedStatement.setString(5, description);
        preparedStatement.setString(6, selectedModuleId);
 
        preparedStatement.executeUpdate();
    }
    
    
}
