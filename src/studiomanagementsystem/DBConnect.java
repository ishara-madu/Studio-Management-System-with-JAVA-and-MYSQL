package studiomanagementsystem;

import java.sql.*;   // for sql connection
import java.util.prefs.Preferences;

public class DBConnect {

    public Connection con;  // for sql connection
    public ResultSet rs;    // for sql connection
    public Statement st;    // for sql connection

    // public ResultSet res;   
    public int ct_id;
    public int admin_id;
    public int s_id;
    static boolean x = true;  //this is using for identyfy the user and admin
    static boolean lang = false;
    Preferences preferences; //this is using for save the language boolean to hard disk
    static public String addUser;


    /* ---------------- Connection ----------------- */
    public DBConnect() {

        preferences = Preferences.userNodeForPackage(DBConnect.class);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/studio", "root", "mysql");
            st = con.createStatement();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
    /* ---------------- ~ ~ ~ ----------------- */


    public void setValue() {
        preferences.putBoolean("lastSavedBoolean", lang);
    }
    public void getValue() {
        boolean savedlang = preferences.getBoolean("lastSavedBoolean", false);
        lang =savedlang;
    }

}
