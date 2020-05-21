/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementjava;
import connection.MySqlConnection;
import java.sql.SQLException;

/**
 *
 * @author Charindu Kavishan
 */
public class StudentManagementJava {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        System.out.println(MySqlConnection.getInstance());
    }
    
}
