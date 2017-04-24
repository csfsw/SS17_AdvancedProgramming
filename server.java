// Simple Server:

import java.net.*;

public class server{

public static void main(String arg[]){
try{
ServerSocket ser=new ServerSocket(8090);
Socket s=ser.accept();


System.out.println("I'm Sever!");
}
catch(Exception ex){}



}

}
