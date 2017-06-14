/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emprgesystem;

import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JFrame;

/**
 *
 * @author Hilal
 */
public class DAL {

    public Connection con;
    public Statement st;
    public ResultSet rs;

    public void setcenter(JFrame f) {
        int screenw = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenh = Toolkit.getDefaultToolkit().getScreenSize().height;
        int framew = f.getSize().width;
        int frameh = f.getSize().height;
        int left = (screenw - framew) / 2;
        int top = (screenh - frameh) / 2;
        f.setLocation(left, top);
    }

    public String convertPassword(char[] pass) {
        String password = "";
        int len = pass.length;
        for (int i = 0; i < len; i++) {
            password += pass[i];
        }
        return password;
    }

    public void showmsg(String msg) {

        javax.swing.JOptionPane.showMessageDialog(null, msg);
    }

    public void connect() {
        try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/er_db","root","");
    st = con.createStatement();
   rs = st.executeQuery("");
        } catch (Exception e) {
            System.out.println("that Exception is occure : " + e);
        }
    }

    public boolean Login(String username, String password) {
        try {
            rs = st.executeQuery("SELECT * FROM Users WHERE UserName='" + username + "' AND Password='" + password + "'");
            rs.last();
            if (rs.getRow() == 1) {
                return true;
            } else {
                showmsg("Incorect username or password!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("that Exception is occure : " + e);
            return false;
        }
    }

    public void insert(String query) 
    {
        try {
            connect();
            st.execute(query);
        } catch (Exception e) {
            System.out.println("that Exception :    " +e.getMessage());
        }
    }

    public String[][] select(String query) {
        try {
            rs = st.executeQuery(query);
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            int col = rs.getMetaData().getColumnCount();
            String[][] data = new String[row][col];
            int r = 0;
            while (rs.next()) {
                for (int c = 0; c < col; c++) {
                    data[r][c] = rs.getString(c+1);
                    r++;
                }
            }

            return data;
        } catch (Exception e) {
            System.out.println("that Exception :    " +e);
            return null;
        }

    }
}
