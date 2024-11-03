/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studiomanagementsystem;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import net.proteanit.sql.DbUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Madu
 */
public class Home extends javax.swing.JFrame {

    Date date = new Date(); // This object contains the current date value
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd  hh:mm:ss a");
    String datetime = formatter.format(date);

    static String sold = "";
    static String damage = "";
    static String used = "";
    static String profit = "";
    static String customer = "";
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
    public String msgreset;

    public String txtfrom;
    public String txtto;
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
    public String btnfilter;
    public String btnopenfinder;
    public String btnsrh;
    public String idvar;
    public String date_timevar;
    public String categoryvar;
    public String soldoutvar;
    public String damagedvar;
    public String pricevar;
    public String adduservar;
    public String updateuservar;

    public String allcustomers;
    public String allsoldout;
    public String alldamaged;
    public String allused;
    public String allprofit;

    DBConnect db = new DBConnect();

    public Home() {

        initComponents();

        /*--------------- Full Screen Code ----------------------*/
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        /*--------------- ------------------------------------ ----------------------*/
        if (DBConnect.x == false) {
            btnResetAll.hide();
            btnAdmin.setVisible(false);
            btnPrint.setVisible(false);
            btnCategory.setVisible(false);
            btnExel.setVisible(false);
            btnOpen.setVisible(false);
            btnDelete.setVisible(false);
        } else {
            btnResetAll.show();
            btnAdmin.setVisible(true);
            btnPrint.setVisible(true);
            btnCategory.setVisible(true);
            btnExel.setVisible(true);
            btnOpen.setVisible(true);
            btnDelete.setVisible(true);
        }


        /*---------------------Auto Date update------------------------*/
        fromDate.setDate(date);
        toDate.setDate(date);
        
        /*--------------------- Filter ------------------------*/

        lang();
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);


        /*---------------------------------------------*/
    }

    public void cmd() {
        if (checkID.isSelected()) {
            idvar = "or s_id like '%" + txtSRH.getText() + "%'";
        } else {
            idvar = " ";
        }
        if (checkDate.isSelected()) {
            date_timevar = "or s_date like '%" + txtSRH.getText() + "%'";
        } else {
            date_timevar = " ";
        }
        if (checkCategory.isSelected()) {
            categoryvar = "or ct_name like '%" + txtSRH.getText() + "%'";
        } else {
            categoryvar = " ";
        }
        if (checkSoldOut.isSelected()) {
            soldoutvar = "or sold_out like '%" + txtSRH.getText() + "%'";
        } else {
            soldoutvar = " ";
        }
        if (checkDamage.isSelected()) {
            damagedvar = "or damage like '%" + txtSRH.getText() + "%'";
        } else {
            damagedvar = " ";
        }
        if (checkPrice.isSelected()) {
            pricevar = "or price like '%" + txtSRH.getText() + "%'";
        } else {
            pricevar = " ";
        }
        if (checkAdded.isSelected()) {
            adduservar = "or add_user like '%" + txtSRH.getText() + "%'";
        } else {
            adduservar = " ";
        }
        if (checkUpdated.isSelected()) {
            updateuservar = "or update_user like '%" + txtSRH.getText() + "%'";
        } else {
            updateuservar = " ";
        }

    }

    public void lang() {

        if (DBConnect.lang == true) {
            comboLang.setSelectedIndex(0);
            id = "ID";
            name = "Name";
            password = "Password";
            category = "Category";
            date_time = "Date and Time";
            soldout = "Sold Out";
            damaged = "Damaged";
            price = "Price";
            adduser = "Added by";
            updateuser = "Updated by";

            allcustomers = "All Customers";
            allsoldout = "All Sold Out Cards";
            alldamaged = "All Damaged Cards";
            allused = "All Damaged Cards";
            allprofit = "Total Profit/Loss";

            txtfrom = "From";
            txtto = "To";

            msgdel = "Delete All Data in This Page";
            msgwarning = "Warning..!";
            msgcorrect = "Retry with Correct Data";
            msgcorname = "Can't add same Name to User and Admin";
            msgreset = "Format Entire System.(Your all of data can be lost)";
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
            btnopenfinder = "Open Finder";
            btnsrh = "Search";
            btnfilter = "Filter";

            btnHome.setText(btnhome);
            btnItemIn.setText(btnitemin);
            btnCategory.setText(btncategory);
            btnAdmin.setText(btnuser);
            btnDelete.setText(btndeleteall);
            btnResetAll.setText(btnreset);
            btnOpen.setText(btnopenfinder);
            //        btnSRH.setText(btnsrh);
          //  btnFilter.setText(btnfilter);

            labelAllCustomers.setText(allcustomers);
            labelAllSoldOut.setText(allsoldout);
            labelAllDamaged.setText(alldamaged);
            labelAllUsed.setText(allused);
            labelAllProfit.setText(allprofit);

            labelfromdate.setText(txtfrom);
            labeltodate.setText(txtto);

            checkID.setText(id);
            checkDate.setText(date_time);
            checkCategory.setText(category);
            checkSoldOut.setText(soldout);
            checkDamage.setText(damaged);
            checkPrice.setText(price);
            checkAdded.setText(adduser);
            checkUpdated.setText(updateuser);

        } else {
            comboLang.setSelectedIndex(1);
            id = "අංක​ය";
            name = "නම";
            password = "මුරපදය";
            category = "කාඩ් වර්ග";
            date_time = "දිනය සහ වෙලාව";
            soldout = "විකිණුනු කාඩ්";
            damaged = "පලුදු වූ කා​ඩ්";
            price = "මිල";
            adduser = "ඇතුලත් කලේ";
            updateuser = "වෙනස් ක​ලේ";

            allcustomers = "සියලුම පාරිභෝගිකයන්";
            allsoldout = "සියලුම විකිණුනු කාඩ්ප​ත්";
            alldamaged = "සියලුම පලුදු වූ කාඩ්පත් ";
            allused = "සියලුම භාවිත කල කාඩ්පත්";
            allprofit = "මුළු ලාභ/පාඩු";

            txtfrom = "සිට";
            txtto = "දක්වා";

            msgdel = "මෙම පිටුවෙහි ඇති සියලුම දත්ත මකන්න.";
            msgwarning = "අවවාදයයි..!";
            msgcorrect = "කරුණාකර නිවැරදි දත්ත ඇතුලත් කර නැවත උත්සහ කරන්න";
            msgcorname = "පරිශීලක හා Admin දෙදෙනාටම සමාන නම් ඇතුලත් කල නොහැ​ක";
            msgreset = "මුළු පද්දතියේ සියලුම දත්ත මකන්​න.(ඔබේ සියලුම දත්ත නැති වී යා හැක)";
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
            btnopenfinder = "Finder විවෘත කරන්න";
            btnsrh = "සොයන්න";
            btnfilter = "පෙරීම්";
            btnHome.setText(btnhome);
            btnItemIn.setText(btnitemin);
            btnCategory.setText(btncategory);
            btnAdmin.setText(btnuser);
            btnDelete.setText(btndeleteall);
            btnResetAll.setText(btnreset);
            btnOpen.setText(btnopenfinder);
            //     btnSRH.setText(btnsrh);
         //   btnFilter.setText(btnfilter);

            labelAllCustomers.setText(allcustomers);
            labelAllSoldOut.setText(allsoldout);
            labelAllDamaged.setText(alldamaged);
            labelAllUsed.setText(allused);
            labelAllProfit.setText(allprofit);

            labelfromdate.setText(txtfrom);
            labeltodate.setText(txtto);

            checkID.setText(id);
            checkDate.setText(date_time);
            checkCategory.setText(category);
            checkSoldOut.setText(soldout);
            checkDamage.setText(damaged);
            checkPrice.setText(price);
            checkAdded.setText(adduser);
            checkUpdated.setText(updateuser);
        }
        formWindowOpened(null);
    }

    @Override
    public void setVisible(boolean value) {
        super.setVisible(value);
        btnSRH.requestFocus();

    }

    public void calcDetails() {
        String fromdate = sdf.format(fromDate.getDate());
        String todate = sdf.format(toDate.getDate());

        cmd();
        try {
            String sql1 = null;
            String sql2 = null;
            String sql3 = null;
            String sql4 = null;
            String sql5 = null;

            if (DBConnect.x == false) {
                sql1 = "select SUM(sold_out) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + "  )";
                sql2 = "select SUM(damage) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + "  )";
                sql3 = "select SUM(sold_out+damage) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + "  )";
                sql4 = "select SUM(price) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + "  )";
                sql5 = "select count(s_id) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + "  )";
            } else {
                sql1 = "select SUM(sold_out) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) ";
                sql2 = "select SUM(damage) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) ";
                sql3 = "select SUM(sold_out+damage) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) ";
                sql4 = "select SUM(price) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) ";
                sql5 = "select count(s_id) from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) ";
            }

            db.rs = db.st.executeQuery(sql1);
            while (db.rs.next()) {
                sold = db.rs.getString("SUM(sold_out)");
            }
            db.rs = db.st.executeQuery(sql2);
            while (db.rs.next()) {
                damage = db.rs.getString("SUM(damage)");
            }
            db.rs = db.st.executeQuery(sql3);
            while (db.rs.next()) {
                used = db.rs.getString("SUM(sold_out+damage)");
            }
            db.rs = db.st.executeQuery(sql4);
            while (db.rs.next()) {
                profit = db.rs.getString("SUM(price)");
            }
            db.rs = db.st.executeQuery(sql5);
            while (db.rs.next()) {
                customer = db.rs.getString("count(s_id)");
            }
            txtSold.setText(sold);
            txtDamaged.setText(damage);
            txtUsed.setText(used);
            txtProfit.setText(profit);
            txtCustomer.setText(customer);

        } catch (SQLException ex) {
            Logger.getLogger(ItemIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        panelFilter = new java.awt.Panel();
        fromDate = new com.toedter.calendar.JDateChooser();
        labelfromdate = new javax.swing.JLabel();
        labeltodate = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();
        checkID = new javax.swing.JCheckBox();
        checkCategory = new javax.swing.JCheckBox();
        checkDamage = new javax.swing.JCheckBox();
        checkAdded = new javax.swing.JCheckBox();
        checkUpdated = new javax.swing.JCheckBox();
        checkPrice = new javax.swing.JCheckBox();
        checkSoldOut = new javax.swing.JCheckBox();
        checkDate = new javax.swing.JCheckBox();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        btnExel = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnResetAll = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        labelAllCustomers = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JLabel();
        labelAllSoldOut = new javax.swing.JLabel();
        txtSold = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelAllDamaged = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDamaged = new javax.swing.JLabel();
        labelAllUsed = new javax.swing.JLabel();
        txtUsed = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelAllProfit = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dd = new javax.swing.JLabel();
        txtProfit = new javax.swing.JLabel();
        btnSRH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboLang = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtSRH = new app.bolivia.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetails = new rojeru_san.complementos.RSTableMetro();
        btnFilter = new javax.swing.JToggleButton();
        jCTextField1 = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
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

        btnHome.setBackground(new java.awt.Color(0, 0, 0));
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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 796, 110, 44));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, -1, 920));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1436, 862, -1, -1));

        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseClicked(evt);
            }
        });
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFilter.setBackground(new java.awt.Color(51, 51, 51));
        panelFilter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fromDate.setInheritsPopupMenu(true);
        fromDate.setOpaque(false);
        fromDate.setRequestFocusEnabled(false);
        fromDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromDateMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fromDateMouseExited(evt);
            }
        });
        fromDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fromDateKeyPressed(evt);
            }
        });
        panelFilter.add(fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 170, 30));

        labelfromdate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelfromdate.setForeground(new java.awt.Color(255, 255, 255));
        labelfromdate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelfromdate.setText("From");
        panelFilter.add(labelfromdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 40, -1));

        labeltodate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labeltodate.setForeground(new java.awt.Color(255, 255, 255));
        labeltodate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labeltodate.setText("To");
        panelFilter.add(labeltodate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 30, -1));

        toDate.setFocusable(false);
        toDate.setInheritsPopupMenu(true);
        toDate.setOpaque(false);
        toDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                toDateKeyPressed(evt);
            }
        });
        panelFilter.add(toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 170, 30));

        checkID.setForeground(new java.awt.Color(255, 255, 255));
        checkID.setSelected(true);
        checkID.setText("ID");
        panelFilter.add(checkID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        checkCategory.setForeground(new java.awt.Color(255, 255, 255));
        checkCategory.setSelected(true);
        checkCategory.setText("Category");
        panelFilter.add(checkCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        checkDamage.setForeground(new java.awt.Color(255, 255, 255));
        checkDamage.setSelected(true);
        checkDamage.setText("Damage");
        panelFilter.add(checkDamage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        checkAdded.setForeground(new java.awt.Color(255, 255, 255));
        checkAdded.setSelected(true);
        checkAdded.setText("Added by");
        panelFilter.add(checkAdded, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        checkUpdated.setForeground(new java.awt.Color(255, 255, 255));
        checkUpdated.setSelected(true);
        checkUpdated.setText("Updated by");
        panelFilter.add(checkUpdated, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        checkPrice.setForeground(new java.awt.Color(255, 255, 255));
        checkPrice.setSelected(true);
        checkPrice.setText("Price");
        panelFilter.add(checkPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        checkSoldOut.setForeground(new java.awt.Color(255, 255, 255));
        checkSoldOut.setSelected(true);
        checkSoldOut.setText("Sold Out");
        panelFilter.add(checkSoldOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        checkDate.setForeground(new java.awt.Color(255, 255, 255));
        checkDate.setSelected(true);
        checkDate.setText("Date and Time");
        panelFilter.add(checkDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        kGradientPanel3.setkEndColor(new java.awt.Color(102, 0, 102));
        kGradientPanel3.setkStartColor(new java.awt.Color(51, 0, 204));
        panelFilter.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 290));

        kGradientPanel1.add(panelFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, -1));

        btnExel.setText("Exel");
        btnExel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExelActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnExel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 104, 60, 30));

        btnOpen.setText("Open");
        btnOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 150, 130, 30));

        btnPrint.setText("PDF");
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 104, -1, 30));

        btnResetAll.setText("Reset");
        btnResetAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetAllMouseClicked(evt);
            }
        });
        btnResetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAllActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnResetAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 150, 140, 30));

        btnDelete.setText("Delete Records");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
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
        kGradientPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 110, 140, 30));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 0, 255));
        kGradientPanel2.setkGradientFocus(1500);
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAllCustomers.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelAllCustomers.setForeground(new java.awt.Color(255, 255, 255));
        labelAllCustomers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAllCustomers.setText("Customers");
        kGradientPanel2.add(labelAllCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 170, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":-");
        kGradientPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        txtCustomer.setFont(new java.awt.Font("Geneva", 0, 12)); // NOI18N
        txtCustomer.setForeground(new java.awt.Color(255, 255, 255));
        txtCustomer.setText("0000000000000");
        kGradientPanel2.add(txtCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, 20));

        labelAllSoldOut.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelAllSoldOut.setForeground(new java.awt.Color(255, 255, 255));
        labelAllSoldOut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAllSoldOut.setText("Sold Out Cards");
        kGradientPanel2.add(labelAllSoldOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 160, -1));

        txtSold.setFont(new java.awt.Font("Geneva", 0, 12)); // NOI18N
        txtSold.setForeground(new java.awt.Color(255, 255, 255));
        txtSold.setText("0000000000000");
        kGradientPanel2.add(txtSold, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, 20));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(":-");
        kGradientPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        labelAllDamaged.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelAllDamaged.setForeground(new java.awt.Color(255, 255, 255));
        labelAllDamaged.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAllDamaged.setText("Damaged Cards");
        kGradientPanel2.add(labelAllDamaged, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 90, 160, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":-");
        kGradientPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        txtDamaged.setFont(new java.awt.Font("Geneva", 0, 12)); // NOI18N
        txtDamaged.setForeground(new java.awt.Color(255, 255, 255));
        txtDamaged.setText("0000000000000");
        kGradientPanel2.add(txtDamaged, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, 20));

        labelAllUsed.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelAllUsed.setForeground(new java.awt.Color(255, 255, 255));
        labelAllUsed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAllUsed.setText("Used Cards");
        kGradientPanel2.add(labelAllUsed, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 30, 170, -1));

        txtUsed.setFont(new java.awt.Font("Geneva", 0, 12)); // NOI18N
        txtUsed.setForeground(new java.awt.Color(255, 255, 255));
        txtUsed.setText("0000000000000");
        kGradientPanel2.add(txtUsed, new org.netbeans.lib.awtextra.AbsoluteConstraints(918, 30, -1, 20));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":-");
        kGradientPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, -1));

        labelAllProfit.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelAllProfit.setForeground(new java.awt.Color(255, 255, 255));
        labelAllProfit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAllProfit.setText("Total Profit/Loss");
        kGradientPanel2.add(labelAllProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 180, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(":-");
        kGradientPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, -1, -1));

        dd.setFont(new java.awt.Font("Geneva", 1, 12)); // NOI18N
        dd.setForeground(new java.awt.Color(255, 255, 255));
        dd.setText("R.s.");
        kGradientPanel2.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(918, 90, -1, -1));

        txtProfit.setFont(new java.awt.Font("Geneva", 0, 12)); // NOI18N
        txtProfit.setForeground(new java.awt.Color(255, 255, 255));
        txtProfit.setText("0000000000000");
        kGradientPanel2.add(txtProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 90, -1, -1));

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 1190, 130));

        btnSRH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSRH.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSRH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSRH.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search (1).png"))); // NOI18N
        btnSRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRHActionPerformed(evt);
            }
        });
        btnSRH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSRHKeyPressed(evt);
            }
        });
        kGradientPanel1.add(btnSRH, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 50, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("Studio Management System");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, 60));

        comboLang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "සිංහල" }));
        comboLang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboLang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboLangMouseClicked(evt);
            }
        });
        comboLang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLangActionPerformed(evt);
            }
        });
        kGradientPanel1.add(comboLang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 17, 80, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Developed by:- Ishara Madushanka Bandara");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kGradientPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 860, -1, 40));

        txtSRH.setPlaceholder("Search Text Here");
        txtSRH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSRHMouseClicked(evt);
            }
        });
        txtSRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSRHActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txtSRH, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 390, 40));

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetails.setAltoHead(40);
        tblDetails.setColorBackgoundHead(new java.awt.Color(51, 0, 255));
        tblDetails.setColorFilasBackgound1(new java.awt.Color(51, 51, 51));
        tblDetails.setColorFilasBackgound2(new java.awt.Color(0, 0, 0));
        tblDetails.setColorFilasForeground1(new java.awt.Color(255, 255, 255));
        tblDetails.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblDetails.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDetails.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblDetails.setRowHeight(20);
        tblDetails.setSelectionBackground(new java.awt.Color(0, 51, 204));
        tblDetails.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblDetails.setShowGrid(true);
        tblDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetailsMouseClicked(evt);
            }
        });
        tblDetails.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDetailsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetails);

        kGradientPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 1190, 520));

        btnFilter.setBackground(new java.awt.Color(0, 0, 0));
        btnFilter.setForeground(new java.awt.Color(0, 0, 0));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter.png"))); // NOI18N
        btnFilter.setBorderPainted(false);
        btnFilter.setContentAreaFilled(false);
        btnFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilter.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter (1).png"))); // NOI18N
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 40, 40));
        kGradientPanel1.add(jCTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 60, 40));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 900));

        setSize(new java.awt.Dimension(1440, 928));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TODO add your handling code here:
        new Category().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        new Admin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnItemInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemInActionPerformed
        // TODO add your handling code here:
        new ItemIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnItemInActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        /*--------------- admin and user permission change ----------------------*/
        if (DBConnect.x == false) {
            btnResetAll.hide();
            btnAdmin.setVisible(false);
            btnPrint.setVisible(false);
            btnCategory.setVisible(false);
            btnExel.setVisible(false);
            btnOpen.setVisible(false);
            btnDelete.setVisible(false);
        } else {
            btnResetAll.show();
            btnAdmin.setVisible(true);
            btnPrint.setVisible(true);
            btnCategory.setVisible(true);
            btnExel.setVisible(true);
            btnOpen.setVisible(true);
            btnDelete.setVisible(true);
        }

        String fromdate = sdf.format(fromDate.getDate());
        String todate = sdf.format(toDate.getDate());

        cmd();

        if (DBConnect.x == false) {
            checkAdded.setVisible(false);
            checkUpdated.setVisible(false);
            String sql = "select s_id '" + id + "',ct_name '" + category + "',s_date '" + date_time + "',sold_out '" + soldout + "',damage '" + damaged + "',price '" + price + "' from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + "  ) order by s_id desc";
            try {
                db.rs = db.st.executeQuery(sql);

                tblDetails.setModel(DbUtils.resultSetToTableModel(db.rs));

            } catch (Exception e) {
                e.getStackTrace();
            }
        } else {
            String sql = "select s_id '" + id + "',ct_name '" + category + "',s_date '" + date_time + "',sold_out '" + soldout + "',damage '" + damaged + "',price '" + price + "',add_user '" + adduser + "',update_user '" + updateuser + "' from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) order by s_id desc";
            try {
                db.rs = db.st.executeQuery(sql);

                tblDetails.setModel(DbUtils.resultSetToTableModel(db.rs));

            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        ///////////////////////////////////////////////////////////////////////
        calcDetails();
    }//GEN-LAST:event_formWindowOpened

    private void fromDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromDateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (DBConnect.x == true) {
            if (evt.getKeyCode() == KeyEvent.VK_F3) {
                btnCategory.doClick();
            }
            if (evt.getKeyCode() == KeyEvent.VK_F4) {
                btnAdmin.doClick();
            } else {
            }
        }        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSRH.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_fromDateKeyPressed

    private void toDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toDateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (DBConnect.x == true) {
            if (evt.getKeyCode() == KeyEvent.VK_F3) {
                btnCategory.doClick();
            }
            if (evt.getKeyCode() == KeyEvent.VK_F4) {
                btnAdmin.doClick();
            } else {
            }
        }        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSRH.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_toDateKeyPressed

    private void btnSRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRHActionPerformed

        formWindowOpened(null);
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);


    }//GEN-LAST:event_btnSRHActionPerformed

    private void btnSRHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSRHKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (DBConnect.x == true) {
            if (evt.getKeyCode() == KeyEvent.VK_F3) {
                btnCategory.doClick();
            }
            if (evt.getKeyCode() == KeyEvent.VK_F4) {
                btnAdmin.doClick();
            } else {
            }
        }        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSRH.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_btnSRHKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);

        String fromdate = sdf.format(fromDate.getDate());
        String todate = sdf.format(toDate.getDate());

        String[] options = {"Yes", "No"};

        JFrame frame = new JFrame();

        int dialog = JOptionPane.showOptionDialog(frame, msgdel, msgwarning,
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("/Users/Madu/Documents/Project/IMPORTENT JAVA/StudioManagementSystem/src/images/report.png"), options, options[0]);

        if (dialog == 0) {
            try {
                db.st.execute("delete from sale where date >= '" + fromdate + "' and date <= '" + todate + "'");
            } catch (Exception e) {
            }
        }
        if (dialog == 1) {
        }

        formWindowOpened(null);
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (DBConnect.x == true) {
            if (evt.getKeyCode() == KeyEvent.VK_F3) {
                btnCategory.doClick();
            }
            if (evt.getKeyCode() == KeyEvent.VK_F4) {
                btnAdmin.doClick();
            } else {
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void btnHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (DBConnect.x == true) {
            if (evt.getKeyCode() == KeyEvent.VK_F3) {
                btnCategory.doClick();
            }
            if (evt.getKeyCode() == KeyEvent.VK_F4) {
                btnAdmin.doClick();
            } else {
            }
        }
    }//GEN-LAST:event_btnHomeKeyPressed

    private void btnItemInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnItemInKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (DBConnect.x == true) {
            if (evt.getKeyCode() == KeyEvent.VK_F3) {
                btnCategory.doClick();
            }
            if (evt.getKeyCode() == KeyEvent.VK_F4) {
                btnAdmin.doClick();
            } else {
            }
        }
    }//GEN-LAST:event_btnItemInKeyPressed

    private void btnCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCategoryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnItemIn.doClick();
        }
        if (DBConnect.x == true) {
            if (evt.getKeyCode() == KeyEvent.VK_F3) {
                btnCategory.doClick();
            }
            if (evt.getKeyCode() == KeyEvent.VK_F4) {
                btnAdmin.doClick();
            } else {
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoryKeyPressed

    private void btnResetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAllActionPerformed
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);

        int x = JOptionPane.showConfirmDialog(this, msgreset, msgwarning, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            try {
                db.st.execute("truncate admin");
                db.st.execute("truncate category");
                db.st.execute("truncate sale");

            } catch (SQLException e) {
            }
        }
        if (x == 1) {
        }
        formWindowOpened(null);

    }//GEN-LAST:event_btnResetAllActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
        String fromdate = sdf.format(fromDate.getDate());
        String todate = sdf.format(toDate.getDate());

        String sql = "select s_id,s_date,ct_name,sold_out,damage,price from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) order by s_id desc";

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
            File itemReportsFolder = new File("reports/item reports pdf");
            if (!itemReportsFolder.exists()) {
                itemReportsFolder.mkdir();
            }

            // Specify the base name for the PDF file
            String baseFileName = "item_report";

            // Specify the path for the PDF file
            String filePath = getUniqueFilePath("reports/item reports pdf", baseFileName, "pdf");

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

//             Add a table to the document
            PdfPTable pdfTable2 = new PdfPTable(5);
            addTableHeader2(pdfTable2);
            addRows2(pdfTable2);
            emptyRows(pdfTable2);

            // Set column widths to fit the page size
            float[] columnWidths2 = new float[pdfTable2.getNumberOfColumns()];
            for (int i = 0; i < columnWidths2.length; i++) {
                columnWidths2[i] = PageSize.A4.getWidth() / pdfTable2.getNumberOfColumns();
            }
            pdfTable2.setWidths(columnWidths2);

            //             Add a table to the document
            PdfPTable pdfTable3 = new PdfPTable(1);
            addTableHeader3(pdfTable3);

            // Set column widths to fit the page size
            float[] columnWidths3 = new float[pdfTable3.getNumberOfColumns()];
            for (int i = 0; i < columnWidths3.length; i++) {
                columnWidths3[i] = PageSize.A4.getWidth() / pdfTable3.getNumberOfColumns();
            }
            pdfTable3.setWidths(columnWidths3);

            // Add the table to the document
            document.add(pdfTable3);
            document.add(pdfTable2);
            document.add(pdfTable);

            // Close the document
            document.close();
            JOptionPane.showMessageDialog(this, "PDF successfully saved at: " + filePath, "Successfully", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "PDF didn't saved", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnPrintActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fromDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromDateMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_fromDateMouseClicked

    private void fromDateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromDateMouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_fromDateMouseExited

    private void btnExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExelActionPerformed
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
        String fromdate = sdf.format(fromDate.getDate());
        String todate = sdf.format(toDate.getDate());

        String sql = "select s_id,s_date,ct_name,sold_out,damage,price from sale where (date >= '" + fromdate + "' and date <= '" + todate + "') and (nothing = 'b' " + idvar + " " + date_timevar + " " + categoryvar + " " + soldoutvar + " " + damagedvar + " " + pricevar + " " + adduservar + " " + updateuservar + "  ) order by s_id desc";

        try {
            ResultSet resultSet = db.st.executeQuery(sql);

            // Create a Workbook
            Workbook workbook = new XSSFWorkbook();

            // Create a Sheet
            Sheet sheet = workbook.createSheet("Item Report");

            /// Add the first table header and rows to the sheet
            addExcelTableHeader(sheet, resultSet);
            addExcelRows(sheet, resultSet);

            // Add empty rows between the two tables
            // Add the second table header and rows to the sheet
            addExcelDate(sheet);
            addExcelTableHeader2(sheet);
            addExcelRows2(sheet);
            addEmptyRows(sheet);

            // Create the "reports" folder if it doesn't exist
            File reportsFolder = new File("reports");
            if (!reportsFolder.exists()) {
                reportsFolder.mkdir();
            }

            // Create the "item reports" folder inside the "reports" folder
            File itemReportsFolder = new File("reports/item reports xlsx");
            if (!itemReportsFolder.exists()) {
                itemReportsFolder.mkdir();
            }

            // Specify the base name for the Excel file
            String baseFileName = "item_report";

            // Specify the path for the Excel file
            String filePath = getUniqueFilePath("reports/item reports xlsx", baseFileName, "xlsx");

            // Write the workbook to the file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            JOptionPane.showMessageDialog(this, "Excel file successfully saved at: " + filePath, "Successfully",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Excel file didn't save", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExelActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed

        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().open(new File("/Users/Madu/Documents/Project/IMPORTENT JAVA/StudioManagementSystem/reports"));
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnOpenActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_kButton1ActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        if (btnFilter.isSelected()) {
            panelFilter.setVisible(true);
            btnFilter.setForeground(java.awt.Color.GRAY);
        } else {
            panelFilter.setVisible(false);
            btnFilter.setSelected(false);
            btnFilter.setForeground(java.awt.Color.BLACK);
        }


    }//GEN-LAST:event_btnFilterActionPerformed

    private void comboLangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLangActionPerformed
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
        if (comboLang.getSelectedIndex() == 0) {
            DBConnect.lang = true;
            lang();
        } else {
            DBConnect.lang = false;
            lang();
        }
    }//GEN-LAST:event_comboLangActionPerformed

    private void kGradientPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseClicked
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
    }//GEN-LAST:event_kGradientPanel1MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked

        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void comboLangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboLangMouseClicked
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
    }//GEN-LAST:event_comboLangMouseClicked

    private void btnResetAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetAllMouseClicked
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetAllMouseClicked

    private void tblDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailsMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblDetailsMouseClicked

    private void tblDetailsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetailsKeyPressed

        // TODO add your handling code here:

    }//GEN-LAST:event_tblDetailsKeyPressed

    private void txtSRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSRHActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtSRHActionPerformed

    private void txtSRHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSRHMouseClicked
        // TODO add your handling code here:
        panelFilter.setVisible(false);
        btnFilter.setSelected(false);
    }//GEN-LAST:event_txtSRHMouseClicked

    /*===================================--------------------1111111111--------------------------------=====================================*/
    private static void addTableHeader(PdfPTable table, ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
        var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);

        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            String columnName = metaData.getColumnName(column);
            if ("s_id".equalsIgnoreCase(columnName)) {
                columnName = "ID";
            } else if ("s_date".equalsIgnoreCase(columnName)) {
                columnName = "Date & Time";
            } else if ("ct_name".equalsIgnoreCase(columnName)) {
                columnName = "Category";
            } else if ("sold_out".equalsIgnoreCase(columnName)) {
                columnName = "Sold Out Cards";
            } else if ("damage".equalsIgnoreCase(columnName)) {
                columnName = "Damaged Cards";
            } else if ("price".equalsIgnoreCase(columnName)) {
                columnName = "Profit/Loss";
            }

            PdfPCell cell = new PdfPCell(new Phrase(columnName, font));
            cell.setBackgroundColor(BaseColor.BLACK);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
        }
    }

    private static void addRows(PdfPTable table, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            for (int column = 1; column <= resultSet.getMetaData().getColumnCount(); column++) {
                PdfPCell cell = new PdfPCell(new Phrase(resultSet.getString(column)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }
        }
    }

    private static void addTableHeader2(PdfPTable table) throws SQLException {
        var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        PdfPCell cell;

        String[] headers = {"Total Customers", "Total Sold Out Cards", "Total Damaged Cards", "Total Used Cards", "Total Profit/Loss"};

        for (String header : headers) {
            cell = new PdfPCell(new Phrase(header, font));
            cell.setBackgroundColor(BaseColor.BLACK);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
        }
    }

    private static void addRows2(PdfPTable table) {
        PdfPCell cell;

        cell = new PdfPCell(new Phrase(customer));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(sold));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(damage));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(used));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Rs. " + profit));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
    }

    private static void emptyRows(PdfPTable table) {
        for (int column = 1; column <= 5; column++) {
            PdfPCell cell = new PdfPCell(new Phrase(" "));
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            PdfPCell cell2 = new PdfPCell(new Phrase(" "));
            cell2.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell2);
        }
    }

    private static String getUniqueFilePath(String directory, String baseFileName, String extension) {
        String filePath = directory + "/" + baseFileName + "." + extension;
        File file = new File(filePath);

        int count = 1;
        while (file.exists()) {
            filePath = directory + "/" + baseFileName + "-" + count + "." + extension;
            file = new File(filePath);
            count++;
        }

        return filePath;
    }


    /*===================================2222222222=====================================*/
    private static void addExcelTableHeader(Sheet sheet, ResultSet resultSet) throws SQLException {
        var font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(font);

        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
        Row headerRow = sheet.createRow(9);

        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            // Change the display names for specific columns
            String columnName = metaData.getColumnName(column);
            if ("s_id".equalsIgnoreCase(columnName)) {
                columnName = "ID";
            } else if ("s_date".equalsIgnoreCase(columnName)) {
                columnName = "Date & Time";
            } else if ("ct_name".equalsIgnoreCase(columnName)) {
                columnName = "Category";
            } else if ("sold_out".equalsIgnoreCase(columnName)) {
                columnName = "Sold Out Cards";
            } else if ("damage".equalsIgnoreCase(columnName)) {
                columnName = "Damaged Cards";
            } else if ("price".equalsIgnoreCase(columnName)) {
                columnName = "Profit/Loss";
            }

            Cell cell = headerRow.createCell(column - 1);
            cell.setCellValue(columnName);
            cell.setCellStyle(style);

        }
    }

    private static void addExcelRows(Sheet sheet, ResultSet resultSet) throws SQLException {
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        int rowNumber = 10;

        while (resultSet.next()) {
            Row row = sheet.createRow(rowNumber++);
            for (int column = 1; column <= resultSet.getMetaData().getColumnCount(); column++) {
                Cell cell = row.createCell(column - 1);
                cell.setCellValue(resultSet.getString(column));
                cell.setCellStyle(style);
                sheet.autoSizeColumn(column);

            }
        }
    }

    private static void addExcelTableHeader2(Sheet sheet) {
        var font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(font);

        Row headerRow = sheet.createRow(5);

        String[] columnNames = {"Total Customers", "Total Sold Out", "Total Damaged", "Total Used",
            "Total Profit/Loss"};

        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = headerRow.createCell(i + 0); // Start from the 7th column
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);

        }
    }

    private static void addExcelRows2(Sheet sheet) {
        Row row = sheet.createRow(6);

        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        for (int i = 0; i < 5; i++) {
            Cell cell = row.createCell(i + 0); // Start from the 7th column
            cell.setCellValue(getCellValue(i)); // Replace with your actual data
            cell.setCellStyle(style);
        }
    }

    private static void addEmptyRows(Sheet sheet) {
        for (int rowIndex = 7; rowIndex < 9; rowIndex++) {
            Row row = sheet.createRow(rowIndex);
            for (int i = 0; i < 11; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(" ");
            }
        }
    }

    // Replace this method with your actual data
    private static String getCellValue(int index) {
        // Replace with your logic to get data for the second table
        String x[] = {customer, sold, damage, used, "Rs. " + profit};
        return x[index];
    }

    /*===================================3333333333333=====================================*/
    private void addTableHeader3(PdfPTable table) throws SQLException {
        var font = FontFactory.getFont(FontFactory.COURIER_OBLIQUE);

        for (int column = 1; column <= 1; column++) {
            // Change the display names for specific columns
            PdfPCell cell2 = new PdfPCell(new Phrase("Printed Date:- " + datetime, font));
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.setPaddingBottom(40);
            cell2.setHorizontalAlignment(20);
            table.addCell(cell2);

        }
    }

    private void addExcelDate(Sheet sheet) {
        Row row = sheet.createRow(1);

        CellStyle style = sheet.getWorkbook().createCellStyle();
        var font = sheet.getWorkbook().createFont();
        font.setFontName("COURIER_OBLIQUE");
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);

        for (int i = 0; i < 2; i++) {
            Cell cell = row.createCell(i + 0); // Start from the 7th column
            cell.setCellValue(datePass(i));
            cell.setCellStyle(style);
        }
    }

    private String datePass(int index) {
        String[] x = {"Create Date:-", datetime};
        return x[index];
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconD btnAdmin;
    private rojerusan.RSButtonIconD btnCategory;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExel;
    private javax.swing.JToggleButton btnFilter;
    private rojerusan.RSButtonIconD btnHome;
    private rojerusan.RSButtonIconD btnItemIn;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnResetAll;
    private javax.swing.JButton btnSRH;
    private javax.swing.JCheckBox checkAdded;
    private javax.swing.JCheckBox checkCategory;
    private javax.swing.JCheckBox checkDamage;
    private javax.swing.JCheckBox checkDate;
    private javax.swing.JCheckBox checkID;
    private javax.swing.JCheckBox checkPrice;
    private javax.swing.JCheckBox checkSoldOut;
    private javax.swing.JCheckBox checkUpdated;
    private javax.swing.JComboBox<String> comboLang;
    private javax.swing.JLabel dd;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JButton jButton2;
    private app.bolivia.swing.JCTextField jCTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel labelAllCustomers;
    private javax.swing.JLabel labelAllDamaged;
    private javax.swing.JLabel labelAllProfit;
    private javax.swing.JLabel labelAllSoldOut;
    private javax.swing.JLabel labelAllUsed;
    private javax.swing.JLabel labelfromdate;
    private javax.swing.JLabel labeltodate;
    private java.awt.Panel panelFilter;
    private rojeru_san.complementos.RSTableMetro tblDetails;
    private com.toedter.calendar.JDateChooser toDate;
    private javax.swing.JLabel txtCustomer;
    private javax.swing.JLabel txtDamaged;
    private javax.swing.JLabel txtProfit;
    private app.bolivia.swing.JCTextField txtSRH;
    private javax.swing.JLabel txtSold;
    private javax.swing.JLabel txtUsed;
    // End of variables declaration//GEN-END:variables
}
