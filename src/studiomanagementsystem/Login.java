package studiomanagementsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Madu
 */
public class Login extends javax.swing.JFrame {

    DBConnect db = new DBConnect();

    /**
     * Creates new form login1
     */
    public String msgwarning;
    public String msgError;
    public String msgcorrect;
    public String msgcordatabase;
    
    public Login() {
        initComponents();
        
        if (DBConnect.lang == true) {
            msgwarning = "⚠️Warning..!";
            msgError = "❌Error..!";
            msgcorrect = "Username or Password wrong...!​";
            msgcordatabase = "Error while connecting to the database";
            
        } else {
            msgwarning = "⚠️අවවාදයයි..!";
            msgError = "❌වැරදියි..!";
            msgcorrect = "නම හෝ මුරපදය වැරදියි...!";
            msgcordatabase = "Database එක සම්බන්ද කර ගැනීමේ ගැටලුව​ක්";
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new com.k33ptoo.components.KButton();
        txtUsername = new app.bolivia.swing.JCTextField();
        txtPassword = new rojerusan.RSPasswordTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shield.png"))); // NOI18N
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 260, 360));

        btnLogin.setText("Login");
        btnLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 120, 40));

        txtUsername.setPlaceholder("Enter Username");
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });
        kGradientPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        txtPassword.setPhColor(new java.awt.Color(0, 0, 0));
        txtPassword.setPlaceholder("Enter Password");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        kGradientPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(595, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String user = txtUsername.getText();
        String pass = new String(txtPassword.getPassword());
        String sql = "select * from admin where (name = '" + user + "' or id ='" + user + "') and pass = '" + pass + "'";
        String sql1 = "select * from main_admin where (username = '" + user + "' or id ='" + user + "') and password = '" + pass + "'";

        try {
            db.rs = db.st.executeQuery(sql);
            if (db.rs.next()) {
                Home.main(null);
                dispose();
                DBConnect.addUser = txtUsername.getText();
                DBConnect.x = false;
            } else {
                db.rs = db.st.executeQuery(sql1);
                if (db.rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, "Admin Login Success", "Admin", JOptionPane.INFORMATION_MESSAGE);
                    Home.main(null);
                    setVisible(true);
                    dispose();
                    DBConnect.addUser = txtUsername.getText();
                    DBConnect.x = true;
                } else {
                    JOptionPane.showMessageDialog(this, msgcorrect, msgwarning, JOptionPane.QUESTION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, msgcordatabase, msgError, JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtPassword.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtPassword.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtUsername.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtUsername.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private rojerusan.RSPasswordTextPlaceHolder txtPassword;
    private app.bolivia.swing.JCTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
