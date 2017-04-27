import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="SimpleEventHandledApplet" width=300 height=500></applet>
 */
public class SimpleEventHandledApplet extends Applet implements ActionListener, ItemListener{
    Label lblFName;
    Label lblLName;
    Label lblGender;
    TextField txtFName;
    TextField txtLName;
    Choice ddlGender;
    Button btnSave;
    public void init(){
        lblFName = new Label("First Name : ");
        lblLName = new Label("Last Name : ");
        lblGender = new Label("Gender : ");
        txtFName = new TextField(20);
        txtLName = new TextField(20);
        ddlGender = new Choice();
        ddlGender.add("Male");
        ddlGender.add("Female");
        btnSave = new Button("Save");
        add(lblFName);
        add(txtFName);
        add(lblLName);
        add(txtLName);
        add(lblGender);
        add(ddlGender);
        add(btnSave);
        btnSave.addActionListener(this);
        ddlGender.addItemListener(this);
    }
    public void actionPerformed(ActionEvent aeObj){
        repaint();
    }
    public void itemStateChanged(ItemEvent ieObje){

    }
    public void paint(Graphics g){
        g.drawString("Entered Data",20,300);
        g.drawString("Name : "+txtFName.getText()+" "+txtLName.getText(), 30,320);
        g.drawString("Gender : "+ddlGender.getSelectedItem(),30, 340);
    }
}