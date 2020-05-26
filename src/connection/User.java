/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author Charindu Kavishan
 */
public class User {
    
    private static User user;
    private static boolean isAdmin;
    private static Integer id;
    private static String uname;
    private static String email;
    private static String fname;
    private static String age;
    private static String nic;
    private static int semester;
    
    /**
     *
     * @param id
     * @param uname
     * @param email
     * @param fname
     * @param age
     * @param nic
     */
    public static void setUser(Integer id,String uname,String email,String fname,String age,String nic,int semester,boolean isAdmin){
        User.id = id;
        User.uname = uname;
        User.email = email;
        User.fname = fname;
        User.age = age;
        User.nic = nic;
        User.semester = semester;
        User.isAdmin = isAdmin;
    }
    
    public static void resetUser(){
        User.id = null;
        User.uname = null;
        User.email = null;
        User.fname = null;
        User.age = null;
        User.nic = null;
        User.isAdmin = false;
    }

    public static User getUser() {
        return user;
    }

    public static Integer getId() {
        return id;
    }

    public static String getUname() {
        return uname;
    }

    public static String getEmail() {
        return email;
    }

    public static String getFname() {
        return fname;
    }

    public static String getAge() {
        return age;
    }

    public static String getNic() {
        return nic;
    }

    public static int getSemester() {
        return semester;
    }
}
