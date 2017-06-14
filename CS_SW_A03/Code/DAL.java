package SaleMangement;
import java.awt.Toolkit;
import java.sql.*;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class DAL extends JFrame{
    //jdbc decleration:
     static int nr = 0;
     static int admainId=0;
    static Connection con;
    Statement st;
    ResultSet rs;
    
    public void showMessage(String message){
    javax.swing.JOptionPane.showMessageDialog(null, message);
    }
    
   public String  changePassword( char pass[]){
       String password = "";
       for (int i = 0; i < pass.length; i++) {
           password += pass[i];
       }
    return password;
    }
    public void  setEnable(){
        SaleManagement.loginItem.setEnabled(false);
        SaleManagement.insertData.setEnabled(true);
         SaleManagement.read.setEnabled(true);
        SaleManagement.delete.setEnabled(true);
        SaleManagement.changePassword.setEnabled(true);
         SaleManagement.logoutItem.setEnabled(true);
         
         SaleManagement.newMember.setEnabled(false);
        SaleManagement.changeAdmain.setEnabled(false);
         SaleManagement.adLogin.setEnabled(true);
         SaleManagement.viewMembers.setEnabled(false);
         SaleManagement.menageData.setEnabled(false);
         
}
    public void admainRols(){
    SaleManagement.loginItem.setEnabled(false);
        SaleManagement.insertData.setEnabled(true);
         SaleManagement.read.setEnabled(true);
        SaleManagement.delete.setEnabled(true);
        SaleManagement.changePassword.setEnabled(true);
         SaleManagement.logoutItem.setEnabled(true);
          SaleManagement.newMember.setEnabled(true);
        SaleManagement.changeAdmain.setEnabled(true);
        SaleManagement.adLogin.setEnabled(false);
        SaleManagement.viewMembers.setEnabled(true);
        SaleManagement.menageData.setEnabled(true);
       
    }
    public void setDisable(){
        
        SaleManagement.loginItem.setEnabled(true);
        SaleManagement.insertData.setEnabled(false);
        SaleManagement.delete.setEnabled(false);
        SaleManagement.changePassword.setEnabled(false);
        SaleManagement.logoutItem.setEnabled(false);
        SaleManagement.read.setEnabled(false);
        SaleManagement.newMember.setEnabled(false);
        SaleManagement.changeAdmain.setEnabled(false);
        SaleManagement.viewMembers.setEnabled(false);
        SaleManagement.menageData.setEnabled(false);
        SaleManagement.adLogin.setEnabled(true);
        //Counter..setEnabled(false);
    }
    public int confirm(String alert){
    int res = JOptionPane.showConfirmDialog(null, alert);
    return res;
    }
    public void center(JFrame j){
    int screenw = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenh = Toolkit.getDefaultToolkit().getScreenSize().height;
    int framew = j.getSize().width;
    int frameh = j.getSize().height;
    int left = (screenw - framew)/2;
    int top = (screenh - frameh)/2;
   // showMessage("screen"+ screenw + screenh+ framew +frameh);
    j.setLocation(left, top);
    }
    public boolean admainLogin(String uname,String pass){
    connection();
    try{
        //st.execute("use counter");
    //rs = st.executeQuery("SELECT *from admain where username ='"+uname+"' and password = '"+pass+"'");
        rs = st.executeQuery("select * from admain where name = '"+uname+"' and password = '"+pass+"'");
    rs.last();
    if(rs.getRow()==1){
    return true;
    }
    else {
    return false;
    }
    }catch(Exception e){
    // showMessage(e.getMessage()+"    Admain login catch block.");
     return false;
     }
    }
    
    
    public boolean login(String membername,String password){
        connection();
       try{
       st.execute("use spend");
       rs = st.executeQuery("select * from members where username = '"+membername+"' and password = '"+password+"'");
        rs.last();
        int r = rs.getRow();
        rs.beforeFirst();
        //showMessage("login");
        if(r==1){
        return true;
        }
        else{
        return false;
        }
        //return true;
        }catch(Exception e){
        return false;
        }
    }
    public void logout(){
    int answer = confirm("Are you sure for leaving this page ?");
    if(answer == 0){
        showMessage("you logout sucessfull!");
        SaleManagement.loginItem.setEnabled(true);
        setDisable();
    }
    }
    public void listOfTables(){
    connection();
    try{
        DatabaseMetaData metaData = con.getMetaData();
        String table[] = {"TABLE"};
        rs = metaData.getTables(null, "%", "%", table);
        while(rs.next()){
        System.out.println(rs.getString("TABLE_NAME"));
        }
        System.out.println("hello");
    }catch(Exception e){}
    }
    public boolean insert(String query){
    connection();
    try{
        //st.execute("use spend");
        if(st.execute(query)){
        return true;
        }
        else{
        return false;
        }
    }catch(Exception e){
        //showMessage(e.getMessage());
        return false;
       
              
    }
    }
   public String [][] select(String query){
      
   connection();
       try{
           //st.execute("use spend");
   rs = st.executeQuery(query);
   rs.last();
   int row = rs.getRow();
   rs.beforeFirst();
   int col = rs.getMetaData().getColumnCount();
   String data[][] = new String[row][col];
   int r = 0;
   while(rs.next()){
       for (int i = 0; i <col; i++) {
           data[r][i] = rs.getString(i+1);
           
           
       }
       //showMessage(rs.getString("username"));
       r++;
       nr++;
   }
           return data;    
   }catch(Exception e){
  //showMessage(e.getMessage());
   return null; 
   }  
   }
   public int totalSelect(String query){
   //String total[][] = select(query);
       connection();
   int row = 0;   
   int sum = 0;
   try{
       //st.execute("use spend");
       rs = st.executeQuery(query);
      while(rs.next()){
          row++;
          //nr++;
      sum+=rs.getInt("price");
       }
      
       //showMessage(sum+"");
   //sum = rs.getInt("price");
   return sum;
      //return row;
   }catch(Exception e){
    //   showMessage(e.getMessage());
   return 0;
   }
   }
//   public int numberOfRow(int{
//   
//   }
   public int admainSelect(String query){
       connection();
       try{
       //st.execute("use spend");
       rs = st.executeQuery(query);
       rs.last();
       int row = rs.getRow();
       rs.beforeFirst();
       
       while(rs.next()){
       admainId = rs.getInt("admainId");
      
       }
       return row;
       }catch(Exception e){
       //showMessage(e.getMessage());
       return -1;
       }
   }
   
   public int userSelect(String query){
          connection();
       try{
      // st.execute("use spend");
       rs = st.executeQuery(query);
       rs.last();
       int userRow = rs.getRow();
       rs.beforeFirst();
       
//       while(rs.next()){
//       admainId = rs.getInt("admainId");
//      
//       }
       return userRow;
       }catch(Exception e){
       //showMessage(e.getMessage());
       return -1;
       }
   }
           
   public int delete(String query){
   connection();
   try{
       //st.execute("use spend");
   if(st.execute(query)){
       read r = new read();
       r.setVisible(false);
      javax.swing.JOptionPane.showMessageDialog(null, "Deleted!");
       showMessage("selected row deleted!");
   return 1;
   }
   else {
   return 0;
   }
   }catch(Exception e){
       showMessage("Error try again !");
    return 0;
   }
  }
   public boolean update(String query){
   connection();
   try{
       //st.execute("use spend");
   if(st.execute(query)){
   return true;
   }
   else {
   return false;
   }
   }catch(Exception e){
   return false;
   }
   }
    
    //Database connection
  void connection(){
     try{
         Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Expenditure","root","");
        //showMessage("connection  ok");
        st =  con.createStatement();
        //st.execute("use spend");
      }catch(Exception e){
      }
  } 
  
}
  

