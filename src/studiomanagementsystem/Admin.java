package studiomanagementsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Madu
 */
public class Admin extends javax.swing.JFrame {

    DBConnect db = new DBConnect();

    public String id;
    public String date_time;
    public String category;
    public String soldout;
    public String damaged;
    public String price;
    public String adduser;
    public String updateuser;
    public String msgdel;
    public String msgwarning;
    public String msgcorrect;
    public String name;
    public String password;
    public String msgcorname;
    //btn
    public String btnhome;
    public String btnitemin;
    public String btncategory;
    public String btnuser;
    public String btnadd;
    public String btnupdate;
    public String btndelete;
    public String btndeleteall;
    public String btnreset;
    public String btnprint;
    public static boolean x;

    public Admin() {
        initComponents();
        /*--------------- Full Screen Code ----------------------*/
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        /*--------------- ------------------------------------ ----------------------*/
        lang();
        panelMainAdmin.setVisible(false);
        x = false;

        /*--------------- ------------------------------------ ----------------------*/
 /*--------------- admin and user permission change ----------------------*/
        if (DBConnect.x == false) {
            btnDeleteAll.hide();
        } else {
            btnDeleteAll.show();
        }

    }

    public void lang() {

        if (DBConnect.lang == true) {
            id = "ID";
            name = "Name";
            password = "Password";
            category = "Category";
            soldout = "Sold Out";
            damaged = "Damaged";
            price = "Price";
            adduser = "Added by";
            updateuser = "Updated by";
            msgdel = "Delete All Data in This Page";
            msgwarning = "Warning..!";
            msgcorrect = "Retry with Correct Data";
            msgcorname = "Can't add same Name to User and Admin";
            //btns
            btnhome = "Home";
            btnitemin = "Item In";
            btncategory = "Category";
            btnuser = "User";
            btnadd = "Add";
            btnupdate = "Update";
            btndelete = "Delete";
            btndeleteall = "Delete All";
            btnreset = "Reset";
            btnprint = "Print";
            btnHome.setText(btnhome);
            btnItemIn.setText(btnitemin);
            btnCategory.setText(btncategory);
            btnAdmin.setText(btnuser);
            btnAdd.setText(btnadd);
            btnUpdate.setText(btnupdate);
            btnDelete.setText(btndelete);
            btnDeleteAll.setText(btndeleteall);
            btnPrint.setText(btnprint);

        } else {
            id = "අංක​ය";
            name = "නම";
            password = "මුරපදය";
            category = "කාඩ් වර්ග";
            soldout = "විකිණුනු කාඩ්";
            damaged = "පලුදු වූ කා​ඩ්";
            price = "මිල";
            adduser = "ඇතුලත් කලේ";
            updateuser = "වෙනස් ක​ලේ";
            msgdel = "මෙම පිටුවෙහි ඇති සියලුම දත්ත මකන්න.";
            msgwarning = "අවවාදයයි..!";
            msgcorrect = "කරුණාකර නිවැරදි දත්ත ඇතුලත් කර නැවත උත්සහ කරන්න";
            msgcorname = "පරිශීලක හා Admin දෙදෙනාටම සමාන නම් ඇතුලත් කල නොහැ​ක";
            //btns
            btnhome = "මුල් පිටුව";
            btnitemin = "ඇතුලත් කිරී​ම";
            btncategory = "කාඩ් වර්ග";
            btnuser = "පරිශීලක තොරතුරු";
            btnadd = "ඇතුලත් කරන්න";
            btnupdate = "වෙනස් කරන්න";
            btndelete = "මකන්​න";
            btndeleteall = "සියල්ල මකන්න";
            btnreset = "මුල් තත්වය";
            btnprint = "පිටපත්";
            btnHome.setText(btnhome);
            btnItemIn.setText(btnitemin);
            btnCategory.setText(btncategory);
            btnAdmin.setText(btnuser);
            btnAdd.setText(btnadd);
            btnUpdate.setText(btnupdate);
            btnDelete.setText(btndelete);
            btnDeleteAll.setText(btndeleteall);
            btnPrint.setText(btnprint);

        }

    }

    public void mainAdminTable() {
        String sql2 = "select id '" + id + "',username '" + name + "',password '" + password + "' from main_admin";
        try {
            db.rs = db.st.executeQuery(sql2);

            tblMainAdmin.setModel(DbUtils.resultSetToTableModel(db.rs));

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /*--------------- change default on focus item----------------------*/
    @Override
    public void setVisible(boolean value) {
        super.setVisible(value);
        txtAdminName.requestFocusInWindow();
    }

    public void clear() {
        txtAdminName.setText("");
        txtPassword.setText("");
        formWindowOpened(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMainAdmin = new java.awt.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMainAdmin = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnItemIn = new rojerusan.RSButtonIconD();
        btnHome = new rojerusan.RSButtonIconD();
        btnAdmin = new rojerusan.RSButtonIconD();
        btnCategory = new rojerusan.RSButtonIconD();
        jButton2 = new javax.swing.JButton();
        kButton1 = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtAdminName = new rojerusan.RSMetroTextPlaceHolder();
        txtPassword = new rojerusan.RSMetroTextPlaceHolder();
        btnDeleteAll = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnMainAdmin = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMainAdmin.setBackground(new java.awt.Color(102, 102, 102));
        panelMainAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMainAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMainAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainAdminMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMainAdmin);

        panelMainAdmin.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 36, 1110, 670));

        getContentPane().add(panelMainAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 1180, 740));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnItemIn.setBackground(new java.awt.Color(51, 51, 51));
        btnItemIn.setBorder(null);
        btnItemIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list-items.png"))); // NOI18N
        btnItemIn.setText("Item In");
        btnItemIn.setColorHover(new java.awt.Color(0, 0, 0));
        btnItemIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnItemIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnItemIn.setIconTextGap(10);
        btnItemIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemInActionPerformed(evt);
            }
        });
        btnItemIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnItemInKeyPressed(evt);
            }
        });
        jPanel1.add(btnItemIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 271, 234, 53));

        btnHome.setBackground(new java.awt.Color(51, 51, 51));
        btnHome.setBorder(null);
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3d-house.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setColorHover(new java.awt.Color(0, 0, 0));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setIconTextGap(10);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        btnHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnHomeKeyPressed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 211, 234, 54));

        btnAdmin.setBackground(new java.awt.Color(0, 0, 0));
        btnAdmin.setBorder(null);
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        btnAdmin.setText("Admin");
        btnAdmin.setColorHover(new java.awt.Color(0, 0, 0));
        btnAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdmin.setIconTextGap(10);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        btnAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAdminKeyPressed(evt);
            }
        });
        jPanel1.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 393, 234, 58));

        btnCategory.setBackground(new java.awt.Color(51, 51, 51));
        btnCategory.setBorder(null);
        btnCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tag.png"))); // NOI18N
        btnCategory.setText("Category");
        btnCategory.setColorHover(new java.awt.Color(0, 0, 0));
        btnCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategory.setIconTextGap(10);
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });
        btnCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCategoryKeyPressed(evt);
            }
        });
        jPanel1.add(btnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 234, 57));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jButton2.setText("LogOut");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 796, 110, 44));

        kButton1.setText("x");
        kButton1.setFont(new java.awt.Font("Kohinoor Telugu", 1, 24)); // NOI18N
        kButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 110, 40));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        btnUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnUpdateKeyPressed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 110, 40));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 110, 40));

        txtAdminName.setForeground(new java.awt.Color(0, 0, 0));
        txtAdminName.setBorderColor(new java.awt.Color(102, 102, 102));
        txtAdminName.setBotonColor(new java.awt.Color(0, 0, 0));
        txtAdminName.setFont(new java.awt.Font("Symbol", 0, 12)); // NOI18N
        txtAdminName.setName(""); // NOI18N
        txtAdminName.setPhColor(new java.awt.Color(102, 102, 102));
        txtAdminName.setPlaceholder("Enter User Name");
        txtAdminName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminNameActionPerformed(evt);
            }
        });
        txtAdminName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdminNameKeyPressed(evt);
            }
        });
        jPanel2.add(txtAdminName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorderColor(new java.awt.Color(102, 102, 102));
        txtPassword.setBotonColor(new java.awt.Color(0, 0, 0));
        txtPassword.setCaretColor(new java.awt.Color(0, 0, 0));
        txtPassword.setFont(new java.awt.Font("Symbol", 0, 12)); // NOI18N
        txtPassword.setPhColor(new java.awt.Color(102, 102, 102));
        txtPassword.setPlaceholder("Enter User Password");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btnDeleteAll.setText("Delete All");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 120, 40));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, -1, 20));

        btnMainAdmin.setText("Admin Details");
        btnMainAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btnMainAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 12, 1176, 132));

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin Id", "Admin Name", "Admin Password"
            }
        ));
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        tblAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAdminKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 150, 1176, 738));

        setSize(new java.awt.Dimension(1440, 928));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new Home().main(null);
        setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // BTN Add
        if (!btnMainAdmin.isSelected()) {
            try {
                db.rs = db.st.executeQuery("select * from main_admin where username = '" + txtAdminName.getText() + "'");
                if (db.rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, msgcorname);
                } else {
                    try {
                        db.st.execute("insert into admin(name,pass) values('" + txtAdminName.getText() + "','" + txtPassword.getText() + "')");
                    } catch (Exception ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, msgcorrect);

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, msgcorrect);
            }
        } else {
            try {
                db.rs = db.st.executeQuery("select * from admin where name = '" + txtAdminName.getText() + "'");
                if (db.rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, msgcorname);
                } else {
                    try {
                        db.st.execute("insert into main_admin(username,password) values('" + txtAdminName.getText() + "','" + txtPassword.getText() + "')");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(rootPane, msgcorrect);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }

            mainAdminTable();
        }

        clear();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // BTN Update
        if (!btnMainAdmin.isSelected()) {
            try {
                db.rs = db.st.executeQuery("select * from main_admin where username = '" + txtAdminName.getText() + "'");
                if (db.rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, msgcorname);
                } else {
                    try {
                        db.st.execute("update admin set name='" + txtAdminName.getText() + "',pass='" + txtPassword.getText() + "' where id=" + db.admin_id);
                    } catch (Exception ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, msgcorrect);

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, msgcorrect);
            }
        } else {
            try {
                db.rs = db.st.executeQuery("select * from admin where name = '" + txtAdminName.getText() + "'");
                if (db.rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, msgcorname);
                } else {
                    try {
                        db.st.execute("update main_admin set username='" + txtAdminName.getText() + "',password='" + txtPassword.getText() + "' where id=" + db.admin_id);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(rootPane, msgcorrect);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }

            mainAdminTable();
        }

        clear();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // BTN Delete
        if (!btnMainAdmin.isSelected()) {
            try {
                db.st.execute("delete from admin where id='" + db.admin_id + "'");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        } else {
            try {
                db.st.execute("delete from main_admin where id='" + db.admin_id + "'");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            mainAdminTable();
        }

        clear();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        // TODO add your handling code here:

        db.admin_id = Integer.parseInt(tblAdmin.getValueAt(tblAdmin.getSelectedRow(), 0).toString());
        txtAdminName.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(), 1).toString());
        txtPassword.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(), 2).toString());


    }//GEN-LAST:event_tblAdminMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        String sql = "select id '" + id + "',name '" + name + "',pass '" + password + "' from admin";
        try {
            db.rs = db.st.executeQuery(sql);

            tblAdmin.setModel(DbUtils.resultSetToTableModel(db.rs));

        } catch (Exception e) {
            e.getStackTrace();
        }


    }//GEN-LAST:event_formWindowOpened

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TODO add your handling code here:
        new Category().main(null);
        setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnItemInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemInActionPerformed
        // TODO add your handling code here:
        new ItemIn().main(null);
        setVisible(true);
        dispose();
    }//GEN-LAST:event_btnItemInActionPerformed

    private void txtAdminNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminNameActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtAdminNameActionPerformed

    private void tblAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAdminKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            txtAdminName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            txtPassword.requestFocus();
        }
    }//GEN-LAST:event_tblAdminKeyPressed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            txtPassword.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            btnUpdate.requestFocus();
        }
    }//GEN-LAST:event_btnAddKeyPressed

    private void btnUpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnUpdateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            btnDelete.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            btnAdd.requestFocus();
        }
    }//GEN-LAST:event_btnUpdateKeyPressed

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            txtAdminName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            btnUpdate.requestFocus();
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void txtAdminNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtPassword.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtPassword.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_txtAdminNameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtAdminName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtAdminName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeKeyPressed

    private void btnItemInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnItemInKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnItemInKeyPressed

    private void btnCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCategoryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoryKeyPressed

    private void btnAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdminKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCategory.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnAdmin.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        // TODO add your handling code here:

        int x = JOptionPane.showConfirmDialog(this, msgdel, msgwarning, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            try {
                db.st.execute("truncate admin");
            } catch (SQLException e) {
            }
        }
        if (x == 1) {
        }
        formWindowOpened(null);


    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        String sql = "select id, name, pass from admin";

        try {
            ResultSet resultSet = db.st.executeQuery(sql);

            // Create a Document
            Document document = new Document(PageSize.A2);

            // Create the "reports" folder if it doesn't exist
            File reportsFolder = new File("reports");
            if (!reportsFolder.exists()) {
                reportsFolder.mkdir();
            }

            // Create the "item reports" folder inside the "reports" folder
            File itemReportsFolder = new File("reports/admin reports");
            if (!itemReportsFolder.exists()) {
                itemReportsFolder.mkdir();
            }

            // Specify the base name for the PDF file
            String baseFileName = "admin_report";

            // Specify the path for the PDF file
            String filePath = getUniqueFilePath("reports/admin reports", baseFileName, "pdf");

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Add a table to the document
            PdfPTable pdfTable = new PdfPTable(resultSet.getMetaData().getColumnCount());
            addTableHeader(pdfTable, resultSet);
            addRows(pdfTable, resultSet);

            // Set column widths to fit the page size
            float[] columnWidths = new float[pdfTable.getNumberOfColumns()];
            for (int i = 0; i < columnWidths.length; i++) {
                columnWidths[i] = PageSize.A4.getWidth() / pdfTable.getNumberOfColumns();
            }
            pdfTable.setWidths(columnWidths);

            // Add the table to the document
            document.add(pdfTable);

            // Close the document
            document.close();
            JOptionPane.showMessageDialog(this, "PDF successfully saved at: " + filePath, "Successfully", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PDF didn't saved", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnPrintActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_kButton1ActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnMainAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainAdminActionPerformed
        // TODO add your handling code here:
        if (btnMainAdmin.isSelected()) {
            panelMainAdmin.setVisible(true);
            x = true;

            btnDeleteAll.setVisible(false);
            btnPrint.setVisible(false);
            mainAdminTable();

        } else {
            panelMainAdmin.setVisible(false);
            x = false;
            btnDeleteAll.setVisible(true);
            btnPrint.setVisible(true);
        }
    }//GEN-LAST:event_btnMainAdminActionPerformed

    private void tblMainAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainAdminMouseClicked
        // TODO add your handling code here:
        db.admin_id = Integer.parseInt(tblMainAdmin.getValueAt(tblMainAdmin.getSelectedRow(), 0).toString());
        txtAdminName.setText(tblMainAdmin.getValueAt(tblMainAdmin.getSelectedRow(), 1).toString());
        txtPassword.setText(tblMainAdmin.getValueAt(tblMainAdmin.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblMainAdminMouseClicked

    private static void addTableHeader(PdfPTable table, ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            // Change the display names for specific columns
            String columnName = metaData.getColumnName(column);
            if ("id".equalsIgnoreCase(columnName)) {
                columnName = "ID";
            } else if ("name".equalsIgnoreCase(columnName)) {
                columnName = "Username";
            } else if ("pass".equalsIgnoreCase(columnName)) {
                columnName = "Password";
            }

            PdfPCell cell = new PdfPCell(new Phrase(columnName, font));
            table.addCell(cell);
        }
    }

    private static void addRows(PdfPTable table, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            for (int column = 1; column <= resultSet.getMetaData().getColumnCount(); column++) {
                table.addCell(new Phrase(resultSet.getString(column)));
            }
        }
    }

    private static String getUniqueFilePath(String directory, String baseFileName, String extension) {
        String filePath = directory + "/" + baseFileName + "." + extension;
        File file = new File(filePath);

        // Check for existing files and append a suffix
        int count = 1;
        while (file.exists()) {
            filePath = directory + "/" + baseFileName + "-" + count + "." + extension;
            file = new File(filePath);
            count++;
        }

        return filePath;
    }

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Admin admin = new Admin();

            admin.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private rojerusan.RSButtonIconD btnAdmin;
    private rojerusan.RSButtonIconD btnCategory;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteAll;
    private rojerusan.RSButtonIconD btnHome;
    private rojerusan.RSButtonIconD btnItemIn;
    private javax.swing.JToggleButton btnMainAdmin;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.k33ptoo.components.KButton kButton1;
    private java.awt.Panel panelMainAdmin;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTable tblMainAdmin;
    private rojerusan.RSMetroTextPlaceHolder txtAdminName;
    private rojerusan.RSMetroTextPlaceHolder txtPassword;
    // End of variables declaration//GEN-END:variables
}
