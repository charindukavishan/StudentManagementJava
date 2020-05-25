/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementjava;

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
import javax.swing.table.DefaultTableModel;
import connection.StudentTableModel;
import connection.Module;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    javax.swing.JLabel activeLable ;
    DefaultTableCellRenderer cellRenderer;
    Module module;
    DefaultTableModel myCourseModel;
    String[] courseColom = {"Course ID","Course Name","Semester"};
    DefaultTableModel myResultModel;
    String[] resultColom = {"Course ID","Course Name","Result"};
    DefaultTableModel semesterCourseModel;
    String[] semesterCourseColom = {"Course ID","Course Name","Semester","Enroll State"};
    
    public Home() {
        initComponents();
        
        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);        
        this.updateProfille();
//        this.updateCourses();
//        this.updateResult();
        this.updateSemesterCourses();
        activeLable = jLabel6;
        activeClass(activeLable);
    }
    
    private void loadImages(){
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("..\\Images\\man.png"));
            Image dimg = img.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(),
            Image.SCALE_SMOOTH);
            jLabel7.setIcon(new ImageIcon(dimg));
            System.out.println(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProfille(){
        uName.setText(User.getUname());
        fName.setText(User.getFname());
        email.setText(User.getEmail());
        age.setText(User.getAge());
        nic.setText(User.getNic());
    }
    
    private void activeClass(javax.swing.JLabel lable){
        lable.setBackground(Color.blue);
        activeLable.setBackground(new java.awt.Color(102, 102, 255));
        activeLable = lable;
    }
    
    private void updateCourses(){
        myCourseModel = null;
        myCourseModel = new DefaultTableModel();
        myCourseModel.setColumnIdentifiers(courseColom);
        courseTable.setModel(myCourseModel);
        courseTable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        courseTable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        courseTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        
        try {
            ResultSet cm =  StudentTableModel.getEnrolledCourses(User.getId());
            while(cm.next()){
                ResultSet selectModule = StudentTableModel.getModule(cm.getInt("course_idcourse"));
            while (selectModule.next()) {
                module = new Module(selectModule.getInt("idcourse"), selectModule.getString("name"),selectModule.getString("description"),selectModule.getString("semester"),selectModule.getInt("fee"));
            }
                myCourseModel.addRow(new Object[]{module.getId(), module.getName(),module.getSemestor()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateResult(){
        myResultModel = null;
        myResultModel = new DefaultTableModel();
        myResultModel.setColumnIdentifiers(resultColom);
        resultTable.setModel(myResultModel);
        
        try {
            ResultSet cm =  StudentTableModel.getResults(User.getId());
            while(cm.next()){
                myResultModel.addRow(new Object[]{cm.getInt("id"), cm.getString("name"),cm.getString("Result")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateSemesterCourses(){
        semesterCourseModel = null;
        semesterCourseModel = new DefaultTableModel();
        semesterCourseModel.setColumnIdentifiers(semesterCourseColom);
        semesterCourses.setModel(semesterCourseModel);
        semesterCourses.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        semesterCourses.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        semesterCourses.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        semesterCourses.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        
        try {
            ResultSet cm =  StudentTableModel.getSemesterCourses(User.getSemester());
            while(cm.next()){
                boolean isEnrolled = StudentTableModel.isEnrolled(User.getId(),cm.getInt("idcourse"));
                module = new Module(cm.getInt("idcourse"), cm.getString("name"),cm.getString("description"),cm.getString("semester"),cm.getInt("fee"));
                module.setIsEnroll(isEnrolled);
                semesterCourseModel.addRow(new Object[]{module.getId(), module.getName(),module.getSemestor(),module.isIsEnroll()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moduleWindow = new javax.swing.JFrame();
        moduleName = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        moduleDescription = new javax.swing.JTextArea();
        enroll = new javax.swing.JButton();
        unenroll = new javax.swing.JButton();
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
        email4 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        email3 = new javax.swing.JLabel();
        email2 = new javax.swing.JLabel();
        fName = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        uName = new javax.swing.JTextField();
        UName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        email5 = new javax.swing.JLabel();
        semester = new javax.swing.JTextField();
        email6 = new javax.swing.JLabel();
        coursesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        enrollPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        semesterCourses = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        viewAllCoursesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        profilePanel1 = new javax.swing.JPanel();
        email7 = new javax.swing.JLabel();
        nic1 = new javax.swing.JTextField();
        age1 = new javax.swing.JTextField();
        email8 = new javax.swing.JLabel();
        email9 = new javax.swing.JLabel();
        fName1 = new javax.swing.JTextField();
        email1 = new javax.swing.JTextField();
        uName1 = new javax.swing.JTextField();
        UName1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        email10 = new javax.swing.JLabel();
        semester1 = new javax.swing.JTextField();
        email11 = new javax.swing.JLabel();

        moduleWindow.setTitle("Course Module");
        moduleWindow.setBackground(new java.awt.Color(255, 255, 255));
        moduleWindow.setLocationByPlatform(true);
        moduleWindow.setMinimumSize(new java.awt.Dimension(919, 581));
        moduleWindow.setResizable(false);
        moduleWindow.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                moduleWindowWindowClosing(evt);
            }
        });

        moduleName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        moduleName.setForeground(java.awt.Color.blue);

        moduleDescription.setEditable(false);
        moduleDescription.setColumns(20);
        moduleDescription.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        moduleDescription.setLineWrap(true);
        moduleDescription.setRows(5);
        moduleDescription.setWrapStyleWord(true);
        moduleDescription.setAutoscrolls(false);
        moduleDescription.setBorder(null);
        moduleDescription.setCaretColor(new java.awt.Color(255, 255, 255));
        moduleDescription.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        moduleDescription.setEnabled(false);
        jScrollPane6.setViewportView(moduleDescription);

        enroll.setText("Enroll");
        enroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollActionPerformed(evt);
            }
        });

        unenroll.setText("Unenroll");
        unenroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unenrollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout moduleWindowLayout = new javax.swing.GroupLayout(moduleWindow.getContentPane());
        moduleWindow.getContentPane().setLayout(moduleWindowLayout);
        moduleWindowLayout.setHorizontalGroup(
            moduleWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduleWindowLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(moduleName, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduleWindowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enroll, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(unenroll, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(moduleWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        moduleWindowLayout.setVerticalGroup(
            moduleWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduleWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moduleName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(moduleWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enroll, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unenroll, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(java.awt.Color.blue);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1143, Short.MAX_VALUE))
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
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel6.setBackground(new java.awt.Color(102, 102, 255));
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

        jLabel3.setBackground(new java.awt.Color(102, 102, 255));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("My Courses");
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

        jLabel4.setBackground(new java.awt.Color(102, 102, 255));
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

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Enroll");
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
                .addContainerGap(66, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        parentPanel.setLayout(new java.awt.CardLayout());

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));

        email4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email4.setText("NIC             :");

        nic.setEditable(false);
        nic.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nic.setBorder(null);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });

        age.setEditable(false);
        age.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        age.setBorder(null);
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });

        email3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email3.setText("Age             :");

        email2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email2.setText("Full Name    :");

        fName.setEditable(false);
        fName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fName.setBorder(null);
        fName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameActionPerformed(evt);
            }
        });

        email.setEditable(false);
        email.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        uName.setEditable(false);
        uName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        uName.setBorder(null);
        uName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uNameActionPerformed(evt);
            }
        });

        UName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        UName.setText("User Name   :");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/person avatar.png"))); // NOI18N

        email5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email5.setText("Semester      :");

        semester.setEditable(false);
        semester.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        semester.setBorder(null);
        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });

        email6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email6.setText("Email           :");

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(uName)
                            .addComponent(fName)
                            .addComponent(email)
                            .addComponent(semester)
                            .addComponent(age)
                            .addComponent(nic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(810, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UName)
                    .addComponent(uName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email2)
                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email6)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email5)
                    .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email3)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email4)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(profilePanel, "card5");

        coursesPanel.setBackground(new java.awt.Color(255, 255, 255));

        courseTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        courseTable.setMinimumSize(new java.awt.Dimension(60, 200));
        courseTable.setRowHeight(20);
        jScrollPane1.setViewportView(courseTable);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(java.awt.Color.blue);
        jLabel8.setText("Course Modules");

        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coursesPanelLayout = new javax.swing.GroupLayout(coursesPanel);
        coursesPanel.setLayout(coursesPanelLayout);
        coursesPanelLayout.setHorizontalGroup(
            coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(coursesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 789, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
        coursesPanelLayout.setVerticalGroup(
            coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        parentPanel.add(coursesPanel, "card4");

        resultPanel.setBackground(new java.awt.Color(255, 255, 255));

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course ID", "Modulde Name", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(resultTable);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(java.awt.Color.blue);
        jLabel12.setText("Results");

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        parentPanel.add(resultPanel, "card3");

        enrollPanel.setBackground(new java.awt.Color(255, 255, 255));

        semesterCourses.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        semesterCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course ID", "Module Name", "Semester", "Enroll Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        semesterCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semesterCourses.setEnabled(false);
        semesterCourses.setRowHeight(25);
        semesterCourses.getTableHeader().setReorderingAllowed(false);
        semesterCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                semesterCoursesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(semesterCourses);
        semesterCourses.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(java.awt.Color.blue);
        jLabel11.setText("Select course to enroll");

        javax.swing.GroupLayout enrollPanelLayout = new javax.swing.GroupLayout(enrollPanel);
        enrollPanel.setLayout(enrollPanelLayout);
        enrollPanelLayout.setHorizontalGroup(
            enrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(enrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        enrollPanelLayout.setVerticalGroup(
            enrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        parentPanel.add(enrollPanel, "card2");

        viewAllCoursesPanel.setBackground(new java.awt.Color(255, 255, 255));

        courseTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        jScrollPane2.setViewportView(courseTable1);
        if (courseTable1.getColumnModel().getColumnCount() > 0) {
            courseTable1.getColumnModel().getColumn(0).setHeaderValue("Course ID");
            courseTable1.getColumnModel().getColumn(1).setHeaderValue("Module Name");
            courseTable1.getColumnModel().getColumn(2).setHeaderValue("Semester");
            courseTable1.getColumnModel().getColumn(3).setHeaderValue("Enroll Status");
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("All Course Modules");

        javax.swing.GroupLayout viewAllCoursesPanelLayout = new javax.swing.GroupLayout(viewAllCoursesPanel);
        viewAllCoursesPanel.setLayout(viewAllCoursesPanelLayout);
        viewAllCoursesPanelLayout.setHorizontalGroup(
            viewAllCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewAllCoursesPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(viewAllCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        viewAllCoursesPanelLayout.setVerticalGroup(
            viewAllCoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewAllCoursesPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );

        parentPanel.add(viewAllCoursesPanel, "card6");

        profilePanel1.setBackground(new java.awt.Color(255, 255, 255));

        email7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email7.setText("NIC             :");
        profilePanel1.add(email7);

        nic1.setEditable(false);
        nic1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nic1.setBorder(null);
        nic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        profilePanel1.add(nic1);

        age1.setEditable(false);
        age1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        age1.setBorder(null);
        age1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        profilePanel1.add(age1);

        email8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email8.setText("Age             :");
        profilePanel1.add(email8);

        email9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email9.setText("Full Name    :");
        profilePanel1.add(email9);

        fName1.setEditable(false);
        fName1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fName1.setBorder(null);
        fName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameActionPerformed(evt);
            }
        });
        profilePanel1.add(fName1);

        email1.setEditable(false);
        email1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        email1.setBorder(null);
        email1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        profilePanel1.add(email1);

        uName1.setEditable(false);
        uName1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        uName1.setBorder(null);
        uName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uNameActionPerformed(evt);
            }
        });
        profilePanel1.add(uName1);

        UName1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        UName1.setText("User Name   :");
        profilePanel1.add(UName1);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/person avatar.png"))); // NOI18N
        profilePanel1.add(jLabel10);

        email10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email10.setText("Semester      :");
        profilePanel1.add(email10);

        semester1.setEditable(false);
        semester1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        semester1.setBorder(null);
        semester1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });
        profilePanel1.add(semester1);

        email11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email11.setText("Email           :");
        profilePanel1.add(email11);

        parentPanel.add(profilePanel1, "card5");

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
       if(activeLable != jLabel6) jLabel6.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        if(activeLable != jLabel3) jLabel3.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
       if(activeLable != jLabel4) jLabel4.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
      if(activeLable != jLabel5)  jLabel5.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        parentPanel.removeAll();
        parentPanel.add(profilePanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        activeClass(jLabel6);
        updateProfille();
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        parentPanel.removeAll();
        parentPanel.add(coursesPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        activeClass(jLabel3);
        updateCourses();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        parentPanel.removeAll();
        parentPanel.add(resultPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        activeClass(jLabel4);
        updateResult();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        parentPanel.removeAll();
        parentPanel.add(enrollPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        activeClass(jLabel5);
        updateSemesterCourses();
    }//GEN-LAST:event_jLabel5MousePressed

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void fNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void uNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//            parentPanel.removeAll();
//            parentPanel.add(viewAllCoursesPanel);
//            parentPanel.repaint();
//            parentPanel.revalidate();
//            jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void semesterCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semesterCoursesMouseClicked
            JTable source = (JTable)evt.getSource();
            int row = source.rowAtPoint( evt.getPoint() );
//            int column = source.columnAtPoint( evt.getPoint() );
            int moduleId= (int) source.getModel().getValueAt(row, 0);
            enroll.setEnabled(!(boolean) source.getModel().getValueAt(row, 3));
            unenroll.setEnabled((boolean) source.getModel().getValueAt(row, 3));
        try {
            ResultSet selectModule = StudentTableModel.getModule(moduleId);
            while (selectModule.next()) {
                module = null;
                module = new Module(selectModule.getInt("idcourse"), selectModule.getString("name"),selectModule.getString("description"),selectModule.getString("semester"),selectModule.getInt("fee"));
                moduleName.setText(selectModule.getString("idcourse")+" : "+selectModule.getString("name"));
                moduleDescription.setText(selectModule.getString("description"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
//
            moduleWindow.setVisible(true);
    }//GEN-LAST:event_semesterCoursesMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        User.resetUser();
        dispose();
        new SLogIn().setVisible(true);        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void enrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollActionPerformed
        try {
            StudentTableModel.enrollModule(User.getId(), module.getId());
            enroll.setEnabled(false);
            unenroll.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_enrollActionPerformed

    private void unenrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unenrollActionPerformed
        try {
            StudentTableModel.unEnrollModule(User.getId(), module.getId());
            enroll.setEnabled(true);
            unenroll.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_unenrollActionPerformed

    private void moduleWindowWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_moduleWindowWindowClosing
        updateSemesterCourses();
    }//GEN-LAST:event_moduleWindowWindowClosing

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UName;
    private javax.swing.JLabel UName1;
    private javax.swing.JTextField age;
    private javax.swing.JTextField age1;
    private javax.swing.JTable courseTable;
    private javax.swing.JTable courseTable1;
    private javax.swing.JPanel coursesPanel;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JLabel email10;
    private javax.swing.JLabel email11;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel email3;
    private javax.swing.JLabel email4;
    private javax.swing.JLabel email5;
    private javax.swing.JLabel email6;
    private javax.swing.JLabel email7;
    private javax.swing.JLabel email8;
    private javax.swing.JLabel email9;
    private javax.swing.JButton enroll;
    private javax.swing.JPanel enrollPanel;
    private javax.swing.JTextField fName;
    private javax.swing.JTextField fName1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea moduleDescription;
    private javax.swing.JLabel moduleName;
    private javax.swing.JFrame moduleWindow;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField nic1;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JPanel profilePanel1;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField semester;
    private javax.swing.JTextField semester1;
    private javax.swing.JTable semesterCourses;
    private javax.swing.JTextField uName;
    private javax.swing.JTextField uName1;
    private javax.swing.JButton unenroll;
    private javax.swing.JPanel viewAllCoursesPanel;
    // End of variables declaration//GEN-END:variables
}
