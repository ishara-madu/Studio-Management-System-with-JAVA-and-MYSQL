package studiomanagementsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author Madu
 */
public class Category extends javax.swing.JFrame {

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

    public Category() {
        initComponents();
        /*--------------- Full Screen Code ----------------------*/
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        /*--------------- ------------------------------------ ----------------------*/

        lang();
        /*--------------- ------------------------------------ ----------------------*/
 /*--------------- admin and user permission change ----------------------*/
        if (DBConnect.x == false) {
            btnDeleteAll.hide();
            btnAdmin.setVisible(false);
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

    /*--------------- change default on focus item ----------------------*/
    public void setVisible(boolean val) {
        super.setVisible(val);
        txtName.requestFocus();
    }

    public void clear() {
        txtName.setText("");
        txtPrice.setText("");
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

        jPanel1 = new javax.swing.JPanel();
        btnItemIn = new rojerusan.RSButtonIconD();
        btnHome = new rojerusan.RSButtonIconD();
        btnAdmin = new rojerusan.RSButtonIconD();
        btnCategory = new rojerusan.RSButtonIconD();
        jButton2 = new javax.swing.JButton();
        kButton1 = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtName = new rojerusan.RSMetroTextPlaceHolder();
        txtPrice = new rojerusan.RSMetroTextPlaceHolder();
        btnDeleteAll = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

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

        btnAdmin.setBackground(new java.awt.Color(51, 51, 51));
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

        btnCategory.setBackground(new java.awt.Color(0, 0, 0));
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

        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Id", "Category Name", "Price"
            }
        ));
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        tblCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCategoryKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 150, 1175, 738));

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

        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setBorderColor(new java.awt.Color(102, 102, 102));
        txtName.setBotonColor(new java.awt.Color(0, 0, 0));
        txtName.setFont(new java.awt.Font("Symbol", 0, 12)); // NOI18N
        txtName.setPhColor(new java.awt.Color(102, 102, 102));
        txtName.setPlaceholder("Enter Name Of Category");
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtPrice.setForeground(new java.awt.Color(0, 0, 0));
        txtPrice.setBorderColor(new java.awt.Color(102, 102, 102));
        txtPrice.setBotonColor(new java.awt.Color(0, 0, 0));
        txtPrice.setCaretColor(new java.awt.Color(0, 0, 0));
        txtPrice.setFont(new java.awt.Font("Symbol", 0, 12)); // NOI18N
        txtPrice.setPhColor(new java.awt.Color(102, 102, 102));
        txtPrice.setPlaceholder("Enter Price Of Category");
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPriceKeyPressed(evt);
            }
        });
        jPanel2.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btnDeleteAll.setText("Delete All");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(859, 44, 120, 40));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 12, 1175, 132));

        setSize(new java.awt.Dimension(1440, 928));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        String sql = "select ct_id '" + id + "',ct_name '" + category + "',ct_price '" + price + "' from category";
        try {
            db.rs = db.st.executeQuery(sql);

            tblCategory.setModel(DbUtils.resultSetToTableModel(db.rs));

        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            db.st.execute("delete from category where ct_id=" + db.ct_id);
            clear();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:

            db.st.execute("update category set ct_name='" + txtName.getText() + "',ct_price='" + txtPrice.getText() + "' where ct_id=" + db.ct_id);
            clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, msgcorrect);
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
        // TODO add your handling code here:
        db.ct_id = Integer.parseInt(tblCategory.getValueAt(tblCategory.getSelectedRow(), 0).toString());
        txtName.setText(tblCategory.getValueAt(tblCategory.getSelectedRow(), 1).toString());
        txtPrice.setText(tblCategory.getValueAt(tblCategory.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // TODO add your handling code here:
            db.st.execute("insert into category(ct_name,ct_price) values('" + txtName.getText() + "','" + txtPrice.getText() + "')");
            clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, msgcorrect);
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        if (DBConnect.x == true) {
            new Admin().setVisible(true);
            this.dispose();
        } else {

        }

    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnItemInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemInActionPerformed
        // TODO add your handling code here:
        new ItemIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnItemInActionPerformed

    private void tblCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCategoryKeyPressed
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
            txtName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            txtPrice.requestFocus();
        }
    }//GEN-LAST:event_tblCategoryKeyPressed

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
            txtName.requestFocus();
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
            txtName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            btnUpdate.requestFocus();
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
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
            txtPrice.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtPrice.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtPrice.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
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
            txtName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_txtPriceKeyPressed

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

        int x = JOptionPane.showConfirmDialog(rootPane, msgdel, msgwarning, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            try {
                db.st.execute("truncate category");
            } catch (SQLException e) {
            }
        }
        if (x == 1) {
        }
        formWindowOpened(null);

    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        String sql = "select ct_id, ct_name, ct_price from category";

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
            File itemReportsFolder = new File("reports/category reports");
            if (!itemReportsFolder.exists()) {
                itemReportsFolder.mkdir();
            }

            // Specify the base name for the PDF file
            String baseFileName = "category_report";

            // Specify the path for the PDF file
            String filePath = getUniqueFilePath("reports/category reports", baseFileName, "pdf");

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

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_kButton1ActionPerformed

    private static void addTableHeader(PdfPTable table, ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            // Change the display names for specific columns
            String columnName = metaData.getColumnName(column);
            if ("ct_id".equalsIgnoreCase(columnName)) {
                columnName = "ID";
            } else if ("ct_name".equalsIgnoreCase(columnName)) {
                columnName = "Category Price";
            } else if ("ct_price".equalsIgnoreCase(columnName)) {
                columnName = "Category Price";
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
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
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
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KButton kButton1;
    private javax.swing.JTable tblCategory;
    private rojerusan.RSMetroTextPlaceHolder txtName;
    private rojerusan.RSMetroTextPlaceHolder txtPrice;
    // End of variables declaration//GEN-END:variables
}
