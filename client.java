// Simple Client


import java.net.*;

public class client{

public static void main(String arg[]){
try{
Socket ser=new Socket("127.0.0.1",8090);



System.out.println("I'm Client!");
}
catch(Exception ex){}



}

}
