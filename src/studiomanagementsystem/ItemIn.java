package studiomanagementsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Madu
 */
public final class ItemIn extends javax.swing.JFrame {

    Date date = new Date(); // This object contains the current date value

    DBConnect db = new DBConnect();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("y MMM dd  hh:mm:ss a");
    String datetime = formatter.format(date);
    String dfd = df.format(date);

    public static String id;
    public static String date_time;
    public static String category;
    public static String soldout;
    public static String damaged;
    public static String price;
    public static String adduser;
    public static String updateuser;
    public static String msgdel;
    public static String msgwarning;
    public static String msgcorrect;
    public static String name;
    public static String password;
    public static String msgcorname;
    //btn
    public static String btnhome;
    public static String btnitemin;
    public static String btncategory;
    public static String btnuser;
    public static String btnadd;
    public static String btnupdate;
    public static String btndelete;
    public static String btndeleteall;
    public static String btnreset;
    public static String btnprint;

    public ItemIn() {
        initComponents();
        /*--------------- Full Screen Code ----------------------*/
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        lang();
        /*--------------- ------------------------------------ ----------------------*/

 /*--------------- admin and user permission change ----------------------*/
        if (DBConnect.x == false) {
            btnDeleteAll.hide();
            btnAdmin.setVisible(false);
            btnCategory.setVisible(false);
        } else {
            btnDeleteAll.show();
            btnCategory.setVisible(true);
        }

        try {
            String sqli = "select ct_name from category";
            db.rs = db.st.executeQuery(sqli);
            while (db.rs.next()) {
                boxCategory.addItem(db.rs.getString("ct_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        }

    }

    /*--------------- change default on focus item ----------------------*/
    @Override
    public void setVisible(boolean value) {
        super.setVisible(value);
        boxCategory.requestFocus();
    }

    public void clear() {
        formWindowOpened(null);
        txtSoldOut.setText("1");
        txtDamaged.setText("0");

    }

    public int priceCalc() {
        try {
            String x = boxCategory.getSelectedItem().toString();
            int profit = 0;
            int sold;
            int price = 0;
            String sql = "select ct_price from category where ct_name ='" + x + "'";
            db.rs = db.st.executeQuery(sql);
            while (db.rs.next()) {
                price = db.rs.getInt("ct_price");
            }
            sold = Integer.parseInt(txtSoldOut.getText());
            profit = price * sold;
            return profit;
        } catch (SQLException ex) {
            Logger.getLogger(ItemIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kButton1 = new com.k33ptoo.components.KButton();
        jPanel1 = new javax.swing.JPanel();
        btnItemIn = new rojerusan.RSButtonIconD();
        btnHome = new rojerusan.RSButtonIconD();
        btnAdmin = new rojerusan.RSButtonIconD();
        btnCategory = new rojerusan.RSButtonIconD();
        jButton2 = new javax.swing.JButton();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemIn = new rojeru_san.complementos.RSTableMetro();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtDamaged = new rojerusan.RSMetroTextPlaceHolder();
        txtSoldOut = new rojerusan.RSMetroTextPlaceHolder();
        boxCategory = new javax.swing.JComboBox<>();
        btnDeleteAll = new javax.swing.JButton();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();

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

        kButton1.setText("x");
        kButton1.setFont(new java.awt.Font("Kohinoor Telugu", 1, 24)); // NOI18N
        kButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnItemIn.setBackground(new java.awt.Color(0, 0, 0));
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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 790, 110, 44));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblItemIn.setModel(new javax.swing.table.DefaultTableModel(
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
        tblItemIn.setAltoHead(40);
        tblItemIn.setColorBackgoundHead(new java.awt.Color(51, 0, 255));
        tblItemIn.setColorFilasBackgound1(new java.awt.Color(51, 51, 51));
        tblItemIn.setColorFilasBackgound2(new java.awt.Color(0, 0, 0));
        tblItemIn.setColorFilasForeground1(new java.awt.Color(255, 255, 255));
        tblItemIn.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblItemIn.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblItemIn.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblItemIn.setFuenteHead(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblItemIn.setRowHeight(20);
        tblItemIn.setSelectionBackground(new java.awt.Color(0, 51, 204));
        tblItemIn.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblItemIn.setShowGrid(true);
        tblItemIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemInMouseClicked(evt);
            }
        });
        tblItemIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblItemInKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblItemIn);

        kGradientPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1190, 700));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Developed by:- Ishara Madushanka Bandara");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kGradientPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 860, -1, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setText("Add");
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAddKeyReleased(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 110, 40));

        btnUpdate.setText("Update");
        btnUpdate.setFocusable(false);
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
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 110, 40));

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
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 110, 40));

        txtDamaged.setForeground(new java.awt.Color(0, 0, 0));
        txtDamaged.setText("0");
        txtDamaged.setBorderColor(new java.awt.Color(102, 102, 102));
        txtDamaged.setBotonColor(new java.awt.Color(0, 0, 0));
        txtDamaged.setCaretColor(new java.awt.Color(0, 0, 0));
        txtDamaged.setFont(new java.awt.Font("Symbol", 0, 12)); // NOI18N
        txtDamaged.setPhColor(new java.awt.Color(102, 102, 102));
        txtDamaged.setPlaceholder("Enter Damaged Cards");
        txtDamaged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDamagedActionPerformed(evt);
            }
        });
        txtDamaged.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDamagedKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDamagedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDamagedKeyTyped(evt);
            }
        });
        jPanel2.add(txtDamaged, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        txtSoldOut.setForeground(new java.awt.Color(0, 0, 0));
        txtSoldOut.setText("1");
        txtSoldOut.setBorderColor(new java.awt.Color(102, 102, 102));
        txtSoldOut.setBotonColor(new java.awt.Color(0, 0, 0));
        txtSoldOut.setCaretColor(new java.awt.Color(0, 0, 0));
        txtSoldOut.setFont(new java.awt.Font("Symbol", 0, 12)); // NOI18N
        txtSoldOut.setPhColor(new java.awt.Color(102, 102, 102));
        txtSoldOut.setPlaceholder(" Enter Soldout Cards");
        txtSoldOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoldOutKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoldOutKeyTyped(evt);
            }
        });
        jPanel2.add(txtSoldOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        boxCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxCategoryKeyPressed(evt);
            }
        });
        jPanel2.add(boxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 80, 30));

        btnDeleteAll.setText("Delete All");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 120, 40));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 0, 255));
        kGradientPanel2.setkGradientFocus(1500);
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel2.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 140));

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1190, 132));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1210, 900));

        setSize(new java.awt.Dimension(1440, 928));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        try {
            int profit = priceCalc();

            db.st.execute("insert into sale(ct_name,s_date,sold_out,damage,price,date,add_user)"
                    + " values('" + boxCategory.getSelectedItem() + "','" + datetime + "',"
                    + "'" + txtSoldOut.getText() + "','" + txtDamaged.getText() + "','" + profit + "','" + dfd + "','" + DBConnect.addUser + "')");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, msgcorrect);
        }
        clear();

        boxCategory.requestFocus();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int profit = priceCalc();
            db.st.execute("update sale set ct_name='" + boxCategory.getSelectedItem() + "',sold_out='" + txtSoldOut.getText() + "',damage='" + txtDamaged.getText() + "',price='" + profit + "',update_user = '" + DBConnect.addUser + "' where s_id=" + db.s_id);
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, msgcorrect);
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            db.st.execute("delete from sale where s_id='" + db.s_id + "'");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, msgcorrect);
        }
        clear();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
        dispose();

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TODO add your handling code here:
        new Category().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if (DBConnect.x == false) {
            String sql = "select s_id '" + id + "',ct_name '" + category + "',sold_out '" + soldout + "',damage '" + damaged + "',price '" + price + "' from sale order by s_id desc";
            try {
                db.rs = db.st.executeQuery(sql);

                tblItemIn.setModel(DbUtils.resultSetToTableModel(db.rs));

            } catch (Exception e) {
                e.getStackTrace();
            }
        } else {
            String sql = "select s_id '" + id + "',ct_name '" + category + "',sold_out '" + soldout + "',damage '" + damaged + "',price '" + price + "',add_user '" + adduser + "',update_user '" + updateuser + "' from sale order by s_id desc";
            try {
                db.rs = db.st.executeQuery(sql);

                tblItemIn.setModel(DbUtils.resultSetToTableModel(db.rs));

            } catch (Exception e) {
                e.getStackTrace();
            }
        }


    }//GEN-LAST:event_formWindowOpened

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        new Admin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
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
            }
        } else {
        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtSoldOut.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }

    }//GEN-LAST:event_btnAddKeyPressed

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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }

    }//GEN-LAST:event_btnItemInKeyPressed

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
            }
        } else {
        }

    }//GEN-LAST:event_btnHomeKeyPressed

    private void txtDamagedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDamagedKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.requestFocus();
            btnAdd.doClick();

        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            boxCategory.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            txtSoldOut.requestFocus();
            txtSoldOut.setText("");
        }

        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }

    }//GEN-LAST:event_txtDamagedKeyPressed

    private void btnUpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnUpdateKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtSoldOut.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_btnUpdateKeyPressed

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtSoldOut.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void btnCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCategoryKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btnHome.doClick();
        }
    }//GEN-LAST:event_btnCategoryKeyPressed

    private void btnAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdminKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
    }//GEN-LAST:event_btnAdminKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
    }//GEN-LAST:event_formKeyPressed

    private void txtSoldOutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoldOutKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.requestFocus();
            btnAdd.doClick();

        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            txtDamaged.requestFocus();
            txtDamaged.setText("");
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            boxCategory.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }


    }//GEN-LAST:event_txtSoldOutKeyPressed

    private void boxCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxCategoryKeyPressed
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
            }
        } else {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            txtSoldOut.requestFocus();
            txtSoldOut.setText("");
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            txtDamaged.requestFocus();
            txtDamaged.setText("");
        }
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            btnUpdate.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ALT) {
            btnDelete.doClick();
        }// TODO add your handling code here:
    }//GEN-LAST:event_boxCategoryKeyPressed

    private void txtDamagedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDamagedKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDamagedKeyTyped

    private void txtSoldOutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoldOutKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoldOutKeyTyped

    private void txtDamagedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDamagedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDamagedKeyReleased

    private void btnAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyReleased
        // TODO add your handling code here:
        txtSoldOut.setText("1");
        txtDamaged.setText("0");
    }//GEN-LAST:event_btnAddKeyReleased

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        // TODO add your handling code here:

        int x = JOptionPane.showConfirmDialog(this, msgdel, msgwarning, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            try {
                db.st.execute("truncate sale");
            } catch (SQLException e) {
            }
        }
        if (x == 1) {
        }
        formWindowOpened(null);

    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_kButton1ActionPerformed

    private void btnItemInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnItemInActionPerformed

    private void tblItemInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemInMouseClicked
        // TODO add your handling code here:
        db.s_id = Integer.parseInt(tblItemIn.getValueAt(tblItemIn.getSelectedRow(), 0).toString());
        txtSoldOut.setText(tblItemIn.getValueAt(tblItemIn.getSelectedRow(), 2).toString());
        txtDamaged.setText(tblItemIn.getValueAt(tblItemIn.getSelectedRow(), 3).toString());
        boxCategory.setSelectedItem(tblItemIn.getValueAt(tblItemIn.getSelectedRow(), 1).toString());

    }//GEN-LAST:event_tblItemInMouseClicked

    private void tblItemInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblItemInKeyPressed
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
            }
        } else {
        }
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
            txtDamaged.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            txtSoldOut.requestFocus();
        }
    }//GEN-LAST:event_tblItemInKeyPressed

    private void txtDamagedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDamagedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDamagedActionPerformed

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
            java.util.logging.Logger.getLogger(ItemIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemIn().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JButton btnAdd;
    private rojerusan.RSButtonIconD btnAdmin;
    private rojerusan.RSButtonIconD btnCategory;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteAll;
    private rojerusan.RSButtonIconD btnHome;
    private rojerusan.RSButtonIconD btnItemIn;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private rojeru_san.complementos.RSTableMetro tblItemIn;
    private rojerusan.RSMetroTextPlaceHolder txtDamaged;
    private rojerusan.RSMetroTextPlaceHolder txtSoldOut;
    // End of variables declaration//GEN-END:variables
}
