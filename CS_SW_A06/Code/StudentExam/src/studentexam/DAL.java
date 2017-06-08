/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentexam;

import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import javax.swing.JFrame;


/**
 *
 * @author M Ahmad Tanha
 */
public class DAL {
        private Connection con;
        public  ResultSet rs;
        private Statement st;
        private boolean flag;
    
    DAL(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/studentexam","root","");
            st=con.createStatement();
            flag= true;
            }catch(Exception e){
                flag=false;
            }
    }
    public boolean login(String pass,String user){
       try{
        rs=st.executeQuery("select * from users where userName='"+user+"' AND password='"+pass+"'");
            rs.last();
            if(rs.getRow()==1){
                return true;  
            }
            else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    public boolean dbcon(){
        return flag;
    }
    public void show(String msg){
        JOptionPane.showMessageDialog(new StudentExam(), msg);
    }
    public ResultSet result(String query){
        try{
            rs=st.executeQuery(query);
        }catch(Exception e){
        
        }
        return rs;
    }
    public boolean myQuery(String query){
        try{
            if(!st.execute(query)){
                return true;
            }else{
                return false;
            }
        
        }catch(Exception e){
            show("Query did not executed");
            return false;  
        }
    }
    public String currentDate(){
           
           return LocalDateTime.now().toString().substring(0, 10);
            
        }    
    public String[][] table(String sql){
        String[][] data = null;
        try {
            rs=result(sql);
            rs.last();
            int row=rs.getRow();
            int column=rs.getMetaData().getColumnCount();
            data = new String[row][column];
        
            rs.beforeFirst();
            int r = 0;
            while (rs.next()) {
                for (int i = 0; i < column; i++) {
                    data[r][i] = rs.getString(i + 1);
                }
                r++;
            }
            return data;
        }catch (Exception e) {

        }
        return data; 
    }
    public void view(){
       StudentExam.scoreMenu.setEnabled(true);
       StudentExam.studentMenu.setEnabled(true);
       StudentExam.teacherMenu.setEnabled(true);
       StudentExam.resultMenu.setEnabled(true);
       StudentExam.logOut.setEnabled(true);
       StudentExam.changePassword.setEnabled(true);
       
    }
    public void hide(){
        StudentExam.scoreMenu.setEnabled(false);
       StudentExam.studentMenu.setEnabled(false);
       StudentExam.teacherMenu.setEnabled(false);
       StudentExam.resultMenu.setEnabled(false);
       StudentExam.logOut.setEnabled(false);
       StudentExam.changePassword.setEnabled(false);
    }
    public void setCenter(JFrame f){
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int framew=f.getSize().width;
        int frameh=f.getSize().height;
        
        int left=(screenWidth-framew)/2;
        int top=(screenHeight-frameh)/2;
        
        f.setLocation(left,top);
    }
}

    