/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientproject;

/**
 *
 * @author Esmatullahmohabat
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Patientproject {

    private static Object conn;

    /**
     * @param args the command line arguments
     */
    Scanner in1 = new Scanner(System.in);

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, " welcome come to patient Registration");
        String name = JOptionPane.showInputDialog(null, "enter the user name");
        String password = JOptionPane.showInputDialog(null, "enter the password");
        String url = "jdbc:mysql://localhost:3306/Patientproject";
        Scanner in = new Scanner(System.in);
        Scanner set = new Scanner(System.in);
        Patientproject obj = new Patientproject();
        int pid;
        int did;
        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            System.out.println("connection is established");
            PreparedStatement insp = connection.prepareStatement("insert into patient (pid,pname,gender,age,address,sickness,nid,did) values(?,?,?,?,?,?,?,?)");
            PreparedStatement insd = connection.prepareStatement("insert into doctor (did,dname,contact) values(?,?,?)");
            PreparedStatement insn = connection.prepareStatement("insert into nurse (nid,nname)values(?,?)");
            PreparedStatement selp = connection.prepareStatement("select * from patient");
            PreparedStatement selp1 = connection.prepareStatement("select * from patient where pid=");
            PreparedStatement del = connection.prepareStatement("truncate patient");
            PreparedStatement seld = connection.prepareStatement("select * from doctor");
            PreparedStatement seln = connection.prepareStatement("select * from nurse");
            PreparedStatement deld = connection.prepareStatement("truncate doctor");
            PreparedStatement deln = connection.prepareStatement("truncate nurse");
            //PreparedStatement upd=connection.prepareStatement("update doctor set dname=''where did=''");
            Statement upd = connection.createStatement();
            Statement upd1 = connection.createStatement();
            Statement cselection = connection.createStatement();
            Statement updn = connection.createStatement();
            Statement deletion = connection.createStatement();

            while (true) {
                System.out.println("for insertion press 1 for selection press 2 for updation press 3 for deletion press 4 and for exit press 5 for insertion in doctor press 6 and for nurse press 7");
                int choice;
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("enetr the id of patient");
                        insp.setInt(1, in.nextInt());
                        System.out.println("enter the name of patient");
                        insp.setString(2, set.nextLine());

                        System.out.println("enter the gender of patient");
                        insp.setString(3, set.nextLine());
                        System.out.println("enter the age of patient");
                        insp.setInt(4, in.nextInt());
                        System.out.println("enter the address of patient");
                        insp.setString(5, set.nextLine());
                        System.out.println("enter the sickness of patient");
                        insp.setString(6, set.nextLine());
                        System.out.println("enter the id of doctor");
                        insp.setInt(7, in.nextInt());
                        System.out.println("enter the id of nurse");
                        insp.setInt(8, in.nextInt());
                        insp.executeUpdate();

                        break;
                    case 2:
                        int selection;
                        System.out.println("for selection of patients press 1 for doctor press 2 for nurse press 3");
                        selection = in.nextInt();
                        if (selection == 1) {
                            System.out.println("for all documents press 1 and for specific press 2");
                            int c;
                            c = in.nextInt();
                            if (c == 1) {

                                ResultSet result = selp.executeQuery();
                                while (result.next()) {
                                    System.out.print(result.getInt("pid") + "\t" + result.getString("pname") + "\t" + result.getString("gender") + "\t" + result.getInt("age") + "\t" + result.getString("address") + "\t" + result.getString("sickness") + "\t" + result.getInt("nid") + "\t" + result.getInt("did"));
                                    System.out.println("");
                                }

                            } else if (c == 2) {
                                System.out.println("enter the id");
                                int p_id = in.nextInt();
                                PreparedStatement connectionp = connection.prepareStatement("SELECT *FROM patient WHERE pid = '" + p_id + "'");
                                ResultSet Set = connectionp.executeQuery();
                                while (Set.next()) {
                                    System.out.print(Set.getInt("pid") + "\t" + Set.getString("pname") + "\t" + Set.getString("gender") + "\t" + Set.getInt("age") + "\t" + Set.getString("address") + "\t" + Set.getString("sickness") + "\t" + Set.getInt("nid") + "\t" + Set.getInt("did"));
                                    System.out.println("");
                                }
                            }
                        } else if (selection == 2) {
                            ResultSet result2 = seld.executeQuery();
                            while (result2.next()) {
                                System.out.println(result2.getInt("did") + "\t" + result2.getString("dname") + "\t" + result2.getString("contact"));
                                System.out.println("");
                            }
                        } else if (selection == 3) {
                            ResultSet sel_nurse = seln.executeQuery();
                            while (sel_nurse.next()) {
                                System.out.println(sel_nurse.getInt("nid") + "\t" + sel_nurse.getString("nname"));
                            }
                        }

                        break;
                    case 3:
                        int update;
                        System.out.println("for updation of patient press 1 ,for doctor press 2,for nurse press 3");
                        update = in.nextInt();
                        if (update == 1) {
                            System.out.println("enter the id of patient which you want to  update");
                            int p_id = in.nextInt();
                            System.out.println("enter the new address of patient");
                            String p_address = set.nextLine();
                            upd1.executeUpdate("UPDATE patient set address = '" + p_address + "' where pid = '" + p_id + "'");
                        } else if (update == 2) {
                            System.out.println("enter the id of doctor which you want to  update");
                            int do_id = in.nextInt();
                            System.out.println("Enter New Name for Doctor:");
                            String Doc_Name = set.nextLine();

                            upd.executeUpdate("UPDATE doctor set dName = '" + Doc_Name + "' where did = '" + do_id + "'");

                        } else if (update == 3) {
                            System.out.println("enter the id of nurse which you want to  update");
                            int n_id = in.nextInt();
                            System.out.println("Enter New Name for nurse:");
                            String n_name = set.nextLine();

                            updn.executeUpdate("UPDATE nurse set nname = '" + n_name + "' where nid = '" + n_id + "'");

                        }
                        break;
                    case 4:
                        System.out.println("for trancation press 1 and for deletion press 2");
                        int n = in.nextInt();
                        if (n == 1) {
                            int c;
                            System.out.println("for truncating patient press 1,for doctor press 2 for nurse press 3");
                            c = in.nextInt();
                            if (c == 1) {
                                del.executeUpdate();
                            } else if (c == 2) {
                                deld.executeUpdate();
                            } else if (c == 3) {
                                deln.executeUpdate();
                            }
                        } else if (n == 2) {
                            System.out.println("enter the patient id which u want to delete");
                            int d_id = in.nextInt();
                            deletion.executeUpdate("delete table patient where pid='" + d_id + "'");
                        }
                        break;
                    case 5:
                        System.exit(choice);
                        break;
                    case 6:
                        // int update;
                        //  System.out.println("for adding new doctor press 1 and for updating old doctor press 2");
                        //update = in.nextInt();
                        //if (update == 1) {
                        System.out.println("enter the id of doctor");
                        insd.setInt(1, in.nextInt());
                        System.out.println("enter the name of doctor");
                        insd.setString(2, set.nextLine());
                        System.out.println("enter the contact number of patient");
                        insd.setInt(3, in.nextInt());
                        insd.executeUpdate();

                        //} else if (update == 2) {
                        // }
                        break;
                    case 7:
                        System.out.println("enter the id for nurse");
                        insn.setInt(1, in.nextInt());
                        System.out.println("enter the name of nurse");
                        insn.setString(2, set.nextLine());
                        insn.executeUpdate();
                        break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private static class where {

        public where() {
        }
    }
}
