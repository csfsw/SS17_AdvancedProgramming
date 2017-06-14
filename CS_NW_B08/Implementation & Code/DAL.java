/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMIS;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.*;

/**
 *
 * @author Tamim
 */
public class DAL {
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String CONN_STRING="jdbc:mysql://localhost/cms";
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    public String convertPassword(char[] pass){
        String password="";
        int len=pass.length;
        for(int i=0;i<len;i++){
        password+=pass[i];
        }
        return password;
    }
        public void showMsg(String msg){
        javax.swing.JOptionPane.showMessageDialog(null, msg);
        }
    
    public void Connect(){
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con=DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
         st=con.createStatement();
        }catch(Exception e){
        
        }
    }
    public boolean Login(String userName,String password){
        try{
   rs=st.executeQuery("select * from manager where userName='"+userName+"'and password ='"+password+"'");
   rs.last();
   if(rs.getRow()==1){
    showMsg("Login successfull");
       return true;
    
    }else{
   showMsg("incorrect username or password");
   return false;
   }
    
        }catch(Exception e){
            return false;
        }
    
    }
    public void setCentr(Frame f){
   int screenWidth= Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    
    int frameWeight=f.getSize().width;
    int frameHeight=f.getSize().height;
    
    int left=(screenWidth-frameWeight)/2;
    int top=(screenHeight-frameHeight)/2;
    
    f.setLocation(left, top);
    
    
    
    }
    public boolean Insert(String query){
    try{
    st.execute(query);
    return true;
    }catch(Exception e){
    return false;
    }
    }
    public String[][] select(String query){
    
    
    try{
       rs=st.executeQuery(query);
       rs.last();
       int row=rs.getRow();
       rs.beforeFirst();
       int col=rs.getMetaData().getColumnCount();
       String[][] data=new String [row][col];
       int r=0;
       while(rs.next()){
       for(int c=0;c<col;c++){
       data[r][c]=rs.getString(c+1);
       
       }
       r++;
       }
       return data;
       
       
    }catch(Exception e){
    return null;
    }
    }
    public boolean Delete(String query){
    try{
    st.execute(query);
    return true;
    }
    catch(Exception e){
    return false;
    }
    }
    public void update(String query){
    try{
        st.execute(query);
                }catch(Exception e){
                
                }
                }
    public void setDisable(){
  
    //Home.LoginMenu.setEnabled(false);
    Home.studentMenu.setEnabled(false);
    Home.teacherMenu.setEnabled(false);
    Home.timeTableMenu.setEnabled(false);
    Home.aboutMenu.setEnabled(false);
    Home.logoutMenu.setEnabled(false);
    Home.pwdMenu.setEnabled(false);
    
    
    }
    public void setEnable(){
       
    Home.LoginMenu.setEnabled(true);
    Home.studentMenu.setEnabled(true);
    Home.teacherMenu.setEnabled(true);
    Home.timeTableMenu.setEnabled(true);
    Home.aboutMenu.setEnabled(true);
    Home.logoutMenu.setEnabled(true);
    Home.pwdMenu.setEnabled(true);
    
    
    }
}
