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
public class StudentHasCourseTableModel {
    
    public static ResultSet getResultsForTable(String moduleId) throws SQLException{
        System.out.println(moduleId);
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("SELECT student_id as Student_Id,"
                + " fname as Student_Name,marks as Results"
                + " FROM student_has_course join student join course"
                + " on student_has_course.student_id=student.id"
                + " and student_has_course.course_idcourse=course.idcourse where moduleid=?");  
        preparedStatement.setString(1, moduleId);
        return  preparedStatement.executeQuery();
    }
    
     public static void UpdateResults(Double marks,String moduleId,int studentId) throws SQLException{
         System.out.println(moduleId);
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("update student_has_course"
                + " set marks="+marks+" where student_id=? and course_idcourse=(select idcourse"
                + " from course where moduleid=?)"); 
        //preparedStatement.setDouble(1, marks);
        preparedStatement.setInt(1, studentId);
        preparedStatement.setString(2, moduleId);
        
        preparedStatement.executeUpdate();
     }
    
}
