/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementjava.Admin;

import connection.AdminTableModel;
import connection.CourseTableModel;
import connection.SemesterTableModel;
import connection.StudentTableModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import connection.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import studentmanagementjava.SLogIn;
import studentmanagementjava.SRegister;

/**
 *
 * @author ASUS
 */
public class AdminHome extends javax.swing.JFrame {

    javax.swing.JFrame StudentDetailsWindow=null;
    /**
     * Creates new form Home
     */
    javax.swing.JLabel activeLable ;
    Color color =new java.awt.Color(7, 47, 95);
    public AdminHome() {
        initComponents();
        this.updateProfille();
//        this.loadImages();
        activeLable = null;
        activeClass(jLabel6);
        addSemesterList();
        fillTables(); 
        loadImages();
        hidePassword();
    }
    
     private void loadImages(){
        
        BufferedImage img = null;
        try {
            //img = ImageIO.read(new File("..\\..\\Images\\search.png"));
            img = ImageIO.read(getClass().getResource("../../Images/search.png"));
            Image dimg = img.getScaledInstance(searchLabel.getWidth(), searchLabel.getHeight(),
            Image.SCALE_SMOOTH);
            searchLabel.setIcon(new ImageIcon(dimg));
           // System.out.println(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void addSemesterList(){
        
        try{
            ResultSet rs = SemesterTableModel.getAllSemesters();
            while(rs.next()){
                homeSemesterList.addItem(rs.getString("name"));
                resultsSemesterList.addItem(rs.getString("name"));
                studentSemesterList.addItem(rs.getString("name"));
            }
  
        }catch(SQLException e){
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
      private void fillTables(){
        
//        try{
//           ResultSet rs = CourseTableModel.getCoursesForTable();
//           ListTableModel model = ListTableModel.createModelFromResultSet( rs );
//           courseTable3.setModel(model);
//        }catch(SQLException e){
//           System.out.println(e.getMessage());
//           Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
//        }
        
//        try {
//            ResultSet rs = StudentTableModel.getStudentsForFirstSemester();
//            ListTableModel model = ListTableModel.createModelFromResultSet( rs );
//            courseTable3.setModel(model);
//        } catch (Exception e) {
//            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
//        }
        
    }
    
//    private void loadImages(){
//        
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("..\\Images\\man.png"));
//            Image dimg = img.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(),
//            Image.SCALE_SMOOTH);
//            jLabel7.setIcon(new ImageIcon(dimg));
//            System.out.println(img);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    private void refreshProfilePanel(){
        this.updateProfille();
      //this.hidePassword();
 
    }
    
    private void hidePassword(){
         psLabel.setVisible(false);
         psField.setVisible(false);
         psField.setEditable(false);
    }

    private void updateProfille() {
        
        try{
             ResultSet rs = AdminTableModel.getUser(User.getUname());
             while(rs.next()){
                uname.setText(rs.getString("uname"));
                fname.setText(rs.getString("fname"));
                lname.setText(rs.getString("lname"));
                email.setText(rs.getString("email"));
                age.setText(rs.getString("age"));
                nic.setText(rs.getString("nic"));
                psField.setText(rs.getString("password"));
             }
               
        }catch(SQLException e){
            Logger.getLogger(this.getName()).log(Level.SEVERE,null,e);
        }
       
    }
    
     private void activeClass(javax.swing.JLabel lable){
        lable.setBackground(Color.blue);
        if(activeLable!=null)
        activeLable.setBackground(color);
        activeLable = lable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        parentPanel = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        UName = new javax.swing.JLabel();
        email2 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        email7 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        email6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        email3 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        email4 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        psLabel = new javax.swing.JLabel();
        psField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        coursesPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        courseTable3 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        homeSemesterList = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        resultsPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        courseTable4 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        resultsSemesterList = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        studentPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        courseTable5 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        studentSemesterList = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(java.awt.Color.blue);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1268, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sign-out-96.png"))); // NOI18N
        jLabel1.setToolTipText("Sign Out");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(java.awt.SystemColor.inactiveCaption);

        jLabel6.setBackground(new java.awt.Color(7, 47, 95));
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Profile");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);
        jLabel6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel6FocusGained(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(7, 47, 95));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Courses");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(7, 47, 95));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Results");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(7, 47, 95));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Student");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        parentPanel.setLayout(new java.awt.CardLayout());

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/person avatar.png"))); // NOI18N

        uname.setEditable(false);
        uname.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        uname.setBorder(null);
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });

        UName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        UName.setText("User Name   ");

        email2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        email2.setText("First Name    ");

        fname.setEditable(false);
        fname.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        fname.setBorder(null);
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        email7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        email7.setText("Last Name    ");

        lname.setEditable(false);
        lname.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lname.setBorder(null);
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        email6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        email6.setText("Email             ");

        email.setEditable(false);
        email.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        email3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        email3.setText("Age                ");

        age.setEditable(false);
        age.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        age.setBorder(null);
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });

        email4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        email4.setText("NIC                 ");

        nic.setEditable(false);
        nic.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        nic.setBorder(null);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });

        psLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        psLabel.setText("Password     ");

        psField.setEditable(false);
        psField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        psField.setBorder(null);
        psField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psFieldActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(102, 102, 255));
        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Refresh");
        jLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel13.setOpaque(true);
        jLabel13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel13FocusGained(evt);
            }
        });
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(102, 102, 255));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Edit");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel11.setOpaque(true);
        jLabel11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel11FocusGained(evt);
            }
        });
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(102, 102, 255));
        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel12.setOpaque(true);
        jLabel12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel12FocusGained(evt);
            }
        });
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(email2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(UName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uname)
                            .addComponent(fname, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(psLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(psField))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email)
                                    .addComponent(lname)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(email3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(age))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(email4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nic)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UName)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email2)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email7)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email6)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email3)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email4)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psLabel)
                    .addComponent(psField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(842, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(profilePanel, "card5");

        coursesPanel1.setBackground(new java.awt.Color(255, 255, 255));

        courseTable3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        courseTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Module Name", "Semester", "Enroll Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        courseTable3.setMinimumSize(new java.awt.Dimension(60, 200));
        courseTable3.setRowHeight(25);
        courseTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTable3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                courseTable3MousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(courseTable3);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(java.awt.Color.blue);
        jLabel14.setText("Course Modules");

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-add-64.png"))); // NOI18N
        jButton4.setText("Add Course");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        homeSemesterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeSemesterListActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Select Semester");

        javax.swing.GroupLayout coursesPanel1Layout = new javax.swing.GroupLayout(coursesPanel1);
        coursesPanel1.setLayout(coursesPanel1Layout);
        coursesPanel1Layout.setHorizontalGroup(
            coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(homeSemesterList, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        coursesPanel1Layout.setVerticalGroup(
            coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(coursesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeSemesterList, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parentPanel.add(coursesPanel1, "card4");

        resultsPanel.setBackground(new java.awt.Color(255, 255, 255));

        courseTable4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        courseTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Module Name", "Semester", "Enroll Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        courseTable4.setMinimumSize(new java.awt.Dimension(60, 200));
        courseTable4.setRowHeight(25);
        courseTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTable4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                courseTable4MousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(courseTable4);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(java.awt.Color.blue);
        jLabel15.setText("Search results by course");

        resultsSemesterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsSemesterListActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel16.setText("Select Semester");

        javax.swing.GroupLayout resultsPanelLayout = new javax.swing.GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
        resultsPanelLayout.setHorizontalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(resultsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 634, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(resultsSemesterList, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        resultsPanelLayout.setVerticalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultsSemesterList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        parentPanel.add(resultsPanel, "card4");

        studentPanel.setBackground(new java.awt.Color(255, 255, 255));

        courseTable5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        courseTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_Id", "Name", "Nic"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        courseTable5.setMinimumSize(new java.awt.Dimension(60, 200));
        courseTable5.setRowHeight(25);
        courseTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTable5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                courseTable5MousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(courseTable5);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(java.awt.Color.blue);
        jLabel17.setText("Students");

        studentSemesterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSemesterListActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel18.setText("Select Semester");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-add-user-male-48.png"))); // NOI18N
        jButton1.setText("Register Student");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(java.awt.Color.red);
        jLabel19.setText("*Note : Please select the student to view");

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(studentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(studentSemesterList, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentPanelLayout.createSequentialGroup()
                                .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(9, 9, 9)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(studentSemesterList, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );

        parentPanel.add(studentPanel, "card4");

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel6FocusGained
          
    }//GEN-LAST:event_jLabel6FocusGained

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
         jLabel6.setCursor(Cursor.getPredefinedCursor(12));
         jLabel6.setBackground(Color.blue);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setCursor(Cursor.getPredefinedCursor(12));
        jLabel3.setBackground(Color.blue);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setCursor(Cursor.getPredefinedCursor(12));
        jLabel4.setBackground(Color.blue);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setCursor(Cursor.getPredefinedCursor(12));
        jLabel5.setBackground(Color.blue);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
       if(activeLable != jLabel6) jLabel6.setBackground(color);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        if(activeLable != jLabel3) jLabel3.setBackground(color);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
       if(activeLable != jLabel4) jLabel4.setBackground(color);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
      if(activeLable != jLabel5)  jLabel5.setBackground(color);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        parentPanel.removeAll();
        parentPanel.add(profilePanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        this.refreshProfilePanel();
        if(activeLable!=jLabel6) activeClass(jLabel6);
        
               fname.setEditable(false);
        lname.setEditable(false);
        age.setEditable(false);
        email.setEditable(false);
        uname.setEditable(false);
        nic.setEditable(false);
        psLabel.setVisible(false);
        psField.setVisible(false);
        psField.setEditable(false);
        
        fname.setBackground(Color.white);
        lname.setBackground(Color.white);
        age.setBackground(Color.white);
        email.setBackground(Color.white);
        uname.setBackground(Color.white);
        nic.setBackground(Color.white);
        psField.setBackground(Color.white);
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        parentPanel.removeAll();
        parentPanel.add(coursesPanel1);
        parentPanel.repaint();
        parentPanel.revalidate();
        if(activeLable!=jLabel3) activeClass(jLabel3);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        parentPanel.removeAll();
        parentPanel.add(resultsPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        if(activeLable!=jLabel4) activeClass(jLabel4);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        parentPanel.removeAll();
        parentPanel.add(studentPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        if(activeLable!=jLabel5) activeClass(jLabel5);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        User.resetUser();
        dispose();
        new SLogIn().setVisible(true);        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        javax.swing.JFrame moduleWindow = new AddCourse();
        moduleWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        moduleWindow.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void homeSemesterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeSemesterListActionPerformed
        
        String selectedSem = homeSemesterList.getSelectedItem().toString();
        try {
            ResultSet rs = CourseTableModel.getCoursesBySemester(selectedSem);
            ListTableModel model = ListTableModel.createModelFromResultSet( rs );
            courseTable3.setModel(model);
        } catch (Exception e) {
            Logger.getLogger(this.getName()).log(null,e.getMessage());
        }
    }//GEN-LAST:event_homeSemesterListActionPerformed

    private void courseTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTable3MouseClicked
//        int column = 0;
//        int row = courseTable3.getSelectedRow();
//        String value = courseTable3.getModel().getValueAt(row, column).toString();
//        System.out.println("selected value of column 0 "+value);
    }//GEN-LAST:event_courseTable3MouseClicked

    private void courseTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTable3MousePressed
           try {
            int column = 0;
            int row = courseTable3.getSelectedRow();
            String moduleId = courseTable3.getModel().getValueAt(row, column).toString();
            String semester = homeSemesterList.getSelectedItem().toString();
            
            javax.swing.JFrame updateCourseWindow = new UpdateCourse(moduleId,semester);
            updateCourseWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            updateCourseWindow.setVisible(true);
   
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Select course module from the table to update!");
        }
    }//GEN-LAST:event_courseTable3MousePressed

    private void courseTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTable4MouseClicked
     
    }//GEN-LAST:event_courseTable4MouseClicked

    private void courseTable4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTable4MousePressed
           try {
            int column = 0;
            int row = courseTable4.getSelectedRow();
            String moduleId = courseTable4.getModel().getValueAt(row, column).toString();
            String semester = homeSemesterList.getSelectedItem().toString();
            
            javax.swing.JFrame ResultsByCourseWindow = new ResultsByCourse(moduleId);
            ResultsByCourseWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            ResultsByCourseWindow.setVisible(true);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }//GEN-LAST:event_courseTable4MousePressed

    private void resultsSemesterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsSemesterListActionPerformed
             
        String selectedSem = resultsSemesterList.getSelectedItem().toString();
        try {
            ResultSet rs = CourseTableModel.getCoursesBySemester(selectedSem);
            ListTableModel model = ListTableModel.createModelFromResultSet( rs );
            courseTable4.setModel(model);
        } catch (Exception e) {
            Logger.getLogger(this.getName()).log(null,e.getMessage());
        }
                                             
    }//GEN-LAST:event_resultsSemesterListActionPerformed

    private void courseTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_courseTable5MouseClicked

    private void courseTable5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTable5MousePressed
        if(StudentDetailsWindow==null){
             try {
            int column = 0;
            int row = courseTable5.getSelectedRow();
            String studentId = courseTable5.getModel().getValueAt(row, column).toString();
          
            this.StudentDetailsWindow = new StudentDetails(studentId);
            StudentDetailsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            StudentDetailsWindow.setLocationRelativeTo(null);
            StudentDetailsWindow.setVisible(true);
            
            StudentDetailsWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    StudentDetailsWindow=null;
                }
                });
    
            } catch (ArrayIndexOutOfBoundsException e) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }else{
           JOptionPane.showMessageDialog(this,"Student Details window is already open");
        }
       
    }//GEN-LAST:event_courseTable5MousePressed

    private void studentSemesterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSemesterListActionPerformed
        String selectedSem = studentSemesterList.getSelectedItem().toString();
        try {
            ResultSet rs = StudentTableModel.getStudentsBySemesterForTable(selectedSem);
            ListTableModel model = ListTableModel.createModelFromResultSet( rs );
            courseTable5.setModel(model);
        } catch (Exception e) {
            Logger.getLogger(this.getName()).log(null,e.getMessage());
        }
    }//GEN-LAST:event_studentSemesterListActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
      
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
         
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
         //System.out.println(jTextField1.getText());
        String nameSegment = jTextField1.getText();
        String semester = studentSemesterList.getSelectedItem().toString();
        try {
            ResultSet rs = StudentTableModel.getStudentsFromSearch(nameSegment,semester);
            ListTableModel model = ListTableModel.createModelFromResultSet( rs );
            courseTable5.setModel(model);
        } catch (Exception e) {
            Logger.getLogger(this.getName()).log(null,e.getMessage());
        }
         
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         javax.swing.JFrame StudentRegisterWindow = new SRegister();
         StudentRegisterWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         StudentRegisterWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setCursor(Cursor.getPredefinedCursor(12));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        AdminTableModel.updateAdmin(User.getId(), fname.getText().toString(),
            lname.getText().toString(), uname.getText().toString(),
            psField.getText().toString(), nic.getText().toString(),
            email.getText().toString(), Integer.parseInt(age.getText().toString()));
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel12FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12FocusGained

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setCursor(Cursor.getPredefinedCursor(12));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        fname.setEditable(true);
        lname.setEditable(true);
        age.setEditable(true);
        email.setEditable(true);
        uname.setEditable(true);
        nic.setEditable(true);
        psLabel.setVisible(true);
        psField.setVisible(true);
        psField.setEditable(true);

        //        fname.setBackground(Color.yellow);
        //        lname.setBackground(Color.yellow);
        //        age.setBackground(Color.yellow);
        //        email.setBackground(Color.yellow);
        //        uname.setBackground(Color.yellow);
        //        nic.setBackground(Color.yellow);
        //        psField.setBackground(Color.yellow);
        //fname.setOpaque(true);

    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel11FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11FocusGained

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jLabel13.setCursor(Cursor.getPredefinedCursor(12));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        this.refreshProfilePanel();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel13FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13FocusGained

    private void psFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psFieldActionPerformed

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UName;
    private javax.swing.JTextField age;
    private javax.swing.JTable courseTable3;
    private javax.swing.JTable courseTable4;
    private javax.swing.JTable courseTable5;
    private javax.swing.JPanel coursesPanel1;
    private javax.swing.JTextField email;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel email3;
    private javax.swing.JLabel email4;
    private javax.swing.JLabel email6;
    private javax.swing.JLabel email7;
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox<String> homeSemesterList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField nic;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JTextField psField;
    private javax.swing.JLabel psLabel;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JComboBox<String> resultsSemesterList;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JComboBox<String> studentSemesterList;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
