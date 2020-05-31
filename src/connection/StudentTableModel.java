/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import static java.lang.Math.E;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Charindu Kavishan
 */
public class StudentTableModel {

    public static void insert(String uname,String email,String password,String fname,int age,String nic,double regFee,double paidAmount, String semester) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("insert into student"
                + " (uname,email,password,fname,age,nic,registrationFee,paidAmount,idsem)"
                + " values (?,?,?,?,?,?,?,?,(select idsemester from semester where name=?))");
        quary.setString(1, uname);
        quary.setString(2, email);
        quary.setString(3, password);
        quary.setString(4, fname);
        quary.setInt(5, age);
        quary.setString(6, nic);
        quary.setDouble(7,regFee);
        quary.setDouble(8,paidAmount);
        quary.setString(9, semester);
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
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from student_has_course left join course on student_has_course.course_idcourse=course.idcourse where student_id=?");
        quary.setInt(1, sId);
        return  quary.executeQuery();
    }
    
    public static ResultSet getResults(int sId,int semId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from student_has_course left join course on student_has_course.course_idcourse=course.idcourse where student_has_course.student_id=? and course.idsem=?");
        quary.setInt(1, sId);
        quary.setInt(2, semId);
        return  quary.executeQuery();
    }
    
    public static ResultSet getSemesterCourses(int semester) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from course where idsem=?");
        quary.setInt(1, semester);
        return  quary.executeQuery();
    }
    
    public static ResultSet getAllCourses() throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from course order by idsem");
        return  quary.executeQuery();
    }
    
    public static boolean isEnrolled(int sId, int cId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from student_has_course where student_id=? and course_idcourse=?");
        quary.setInt(1, sId);
        quary.setInt(2, cId);
        return  quary.executeQuery().next();
    }
    
    public static ResultSet getModule(String moduleId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from course where moduleid=?");
        quary.setString(1, moduleId);
        return  quary.executeQuery();
    }
    
    public static ResultSet getModule(Integer courseId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select * from course where idcourse=?");
        quary.setInt(1, courseId);
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
    
    public static ResultSet avgMarks(int sId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select avg(marks) as avgMarks from student_has_course where student_id=? and marks > 0");
        quary.setInt(1, sId);
        return  quary.executeQuery();
    }
    
    public static ResultSet noOfEnrolled(int sId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select count(marks) as count from student_has_course where student_id=?");
        quary.setInt(1, sId);
        return  quary.executeQuery();
    }
    
    public static ResultSet getPaidAmout(int sId,int semId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select sum(course.fee) as amount from student_has_course left join course on student_has_course.course_idcourse=course.idcourse where student_has_course.student_id=? and course.idsem=? and student_has_course.feePaid=1");
        quary.setInt(1, sId);
        quary.setInt(2, semId);
        return  quary.executeQuery();
    }
    
    public static ResultSet getPayableAmout(int sId,int semId) throws SQLException{
        PreparedStatement quary = MySqlConnection.getInstance().connection.prepareStatement("select sum(course.fee) as amount from student_has_course left join course on student_has_course.course_idcourse=course.idcourse where student_has_course.student_id=? and course.idsem=? and student_has_course.feePaid=0");
        quary.setInt(1, sId);
        quary.setInt(2, semId);
        return  quary.executeQuery();
    }
    
    public static ResultSet getStudentsBySemesterForTable(String semester) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select id as Student_Id,fname as Name,nic from student "
                + "where idsem=(select idsemester from semester where name=?)");
        preparedStatement.setString(1, semester);
        return  preparedStatement.executeQuery();
    }
    
    public static ResultSet getStudentsForFirstSemester() throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select id as Student_Id,fname as Name,nic from student "
                + "where idsem=(select idsemester from semester ORDER BY idsemester LIMIT 1)");   
        return  preparedStatement.executeQuery();
    }
    
    public static ResultSet getStudentsFromSearch(String name,String semester) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select id as Student_Id,fname as Name,nic from student "
                + "where idsem=(select idsemester from semester where name=?) and fname like '"+name+"%'"); 
        preparedStatement.setString(1, semester);
        return  preparedStatement.executeQuery();
    }
    
      public static ResultSet getStudentDetails(int id) throws SQLException{
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("select id,uname,email,password,fname,"
                + "age,nic,registrationFee,paidAmount,(select name from semester where idsemester=idsem)"
                + " as semester from student where id=?");
        preparedStatement.setInt(1, id);
        return  preparedStatement.executeQuery();
    }
      
      
    public static void updateStudent(int id,String uname,String email,String password,String fname,int age,String nic,
            double registrationFee,double paidAmount,String semester) throws SQLException{
        
        
        Connection con = MySqlConnection.getInstance().connection;
        PreparedStatement preparedStatement = con.prepareStatement("UPDATE student set uname=?, email=?,password=?,"
                + " fname=?, age=?, nic=?, registrationFee=?, paidAmount=?,"
                + "idsem=(select idsemester from semester where name=?)"
                + "where id=?");
        preparedStatement.setString(1, uname);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, fname);
        preparedStatement.setInt(5, age);
        preparedStatement.setString(6, nic);
        preparedStatement.setDouble(7, registrationFee);
        preparedStatement.setDouble(8, paidAmount);
        preparedStatement.setString(9, semester);
        preparedStatement.setInt(10, id);
        
        
        preparedStatement.executeUpdate();
    }
    
}
