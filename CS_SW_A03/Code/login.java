package SaleMangement;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.awt.WindowClosingListener;

public class login extends JFrame  {
    // SaleManagement c = new SaleManagement();
    // SaleManagement c = new SaleManagement();
    DAL d = new DAL();
    JLabel membername = new JLabel("Membername:");
    JLabel password = new JLabel("Password:");
  public static JTextField uname = new JTextField();
   JPasswordField upass = new JPasswordField();
    String u = "jan";
    char p[] = new char[30];

    login() {
        SaleManagement.flag = 2;
        addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowOpened(WindowEvent e) {
        addwindowEvents();
    }
        } );
       // d.center(this);
        //this.addWindowListener(new windowEvent());
        // c.setVisible(false);
        setSize(400, 250);
        setVisible(true);
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        GroupLayout l = new GroupLayout(getContentPane());
        setLayout(l);

        membername.setBounds(10, 20, 95, 20);
        uname.setBounds(100, 20, 150, 20);
        password.setBounds(10, 60, 80, 20);
        upass.setBounds(100, 60, 150, 20);
        getContentPane().add(membername);
        getContentPane().add(uname);
        getContentPane().add(password);
        getContentPane().add(upass);

        //JButton ok = new JButton("Ok");
        JButton.class.cast(ok);
        
        JButton cancel = new JButton("Cancel");
        JButton.class.cast(cancel);
        ok.setBounds(105, 100, 60, 20);
        cancel.setBounds(174, 100, 75, 20);
        getContentPane().add(ok);
        getContentPane().add(cancel);
        //username.setFont(new java.awt.Font("tahoma",15,15));
        //action a = new action();
        ok.addActionListener(new action());
       // ok.addMouseListener(new mouse());
        cancel.addActionListener(new action());
       // cancel.addMouseListener(new mouse());
        upass.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed (java.awt.event.KeyEvent ev){
        keyPress(ev);
        }
        });
    }
    public void action(ActionEvent e) {
        
        String user = uname.getText();
    }
  public class action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           // d.showMessage(e.getActionCommand());
           if(e.getActionCommand().equals("Ok")){
           String username = uname.getText();
               char[] userpassword = upass.getPassword();
               String p = d.changePassword(userpassword);
               //if(ok.c){
               if (d.login(username, p)) {
                   //d.showMessage("hello");
                   d.showMessage("welcome to our page ");
                   d.setEnable();
                   setVisible(false);
               } 
               else {
                   d.showMessage("Incorrect member name or Password!");
               }
            }
           else if(e.getActionCommand().equals("Cancel")){
               setVisible(false);
               //d.showMessage("cancel button");
           }
            action(e);
        }
    }


    //Decleration of contents:
    JButton ok = new JButton("Ok");
   
   public void addwindowEvents(){
       d.center(this);
   int userRow = d.userSelect("select * from members");
   if(userRow<1){
       setVisible(false);
  int answer = d.confirm("There is no any member do you want to add new member ?");
  if(answer ==0){
      
      d.showMessage("After Login add new member from Admain menu / New member !");
  admainLogin ad = new admainLogin();
  ad.setVisible(true);
  }   
   }
   
   }
   public void keyPress(java.awt.event.KeyEvent ev){
   int code = ev.getKeyCode();
        //d.showMessage("key pressed!!");
        if(code == 10){
        String username = uname.getText();
        Username = uname.getText();
        //d.showMessage(Username);
               char[] userpassword = upass.getPassword();
               String p = d.changePassword(userpassword);
               //if(ok.c){
               if (d.login(username, p)) {
                   d.showMessage("welcome to our page");
                   d.setEnable();
                   setVisible(false);
               } 
               else {
                   d.showMessage("Incorrect Membernamename or Password!");
               }
        }
   }
   public static String Username;
  
}
