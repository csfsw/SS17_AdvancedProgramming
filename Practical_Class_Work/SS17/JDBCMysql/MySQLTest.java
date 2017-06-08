import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MySQLTest{
    public static void main(String args[]){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/banking","root", "admin");
            PreparedStatement newCustomer = con.prepareStatement("INSERT INTO customer (Name, Address, Email) VALUES (?,?,?)");
            PreparedStatement selectCustomers = con.prepareStatement("SELECT * FROM customer");
            int choice = 1;
            Scanner scan = new Scanner(System.in);
            while(choice == 1){
                System.out.println("Enter 2 for adding new customer, 3 for viewing all customers, 0 for exit");
                choice = scan.nextInt();
                switch(choice){
                    case 2:
                        System.out.print("Enter customer name : ");
                        newCustomer.setString(1, scan.nextLine());
                         System.out.print(" address : ");
                        newCustomer.setString(2, scan.nextLine());
                        System.out.print(" email : ");
                        newCustomer.setString(3, scan.nextLine());
                       int recordefected = newCustomer.executeUpdate();
                       if(recordefected > 0){
                           System.out.print("Enter customer email : ");
                       }
                    break;
                    case 3:
                      ResultSet rSet = selectCustomers.executeQuery();
                      while(rSet.next()){
                          System.out.println("Customer Id: "+ rSet.getInt("Id") + "\t Name : "+ rSet.getString("Name"));
                      }
                    break;
                    case 0:
                    System.exit(1);
                    break;
                }
            }

        }catch (SQLException exc){
            System.out.println(exc.toString());
        } catch (Exception exc){
            System.out.println(exc.toString());
        }
    }
} 