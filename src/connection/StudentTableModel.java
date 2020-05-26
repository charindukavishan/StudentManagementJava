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
    
    public static ResultSet getEnrolledCourses(int sId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from student_has_course where student_id=?");
        quary.setInt(1, sId);
        return  quary.executeQuery();
    }
    
    public static ResultSet getResults(int sId,int sem) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from student_has_course left join course on student_has_course.course_idcourse=course.idcourse where student_has_course.student_id=? and course.semester=?");
        quary.setInt(1, sId);
        quary.setInt(2, sem);
        return  quary.executeQuery();
    }
    
    public static ResultSet getSemesterCourses(int semester) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from course where semester=?");
        quary.setInt(1, semester);
        return  quary.executeQuery();
    }
    
    public static boolean isEnrolled(int sId, int cId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from student_has_course where student_id=? and course_idcourse=?");
        quary.setInt(1, sId);
        quary.setInt(2, cId);
        return  quary.executeQuery().next();
    }
    
    public static ResultSet getModule(int cId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from course where idcourse=?");
        quary.setInt(1, cId);
        return  quary.executeQuery();
    }
    
    public static void enrollModule(int sId,int cId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("insert into student_has_course (student_id,course_idcourse,feePaid) values (?,?,0)");
        quary.setInt(1, sId);
        quary.setInt(2, cId);
        quary.executeUpdate();
    }
    
    public static void unEnrollModule(int sId,int cId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("delete from student_has_course where student_id=? and course_idcourse=?");
        quary.setInt(1, sId);
        quary.setInt(2, cId);
        quary.executeUpdate();
    }
    
}
