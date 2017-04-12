import java.net.*;
import java.io.*;
public class Client{
    static Socket soc;
    static BufferedReader in;
    public static void main(String args[]){
        try{
                soc = new Socket(args[0],9060);
                in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                System.out.println("Message from server " + in.readLine());
                }catch(IOException ex){
                        System.out.println(ex);
                }finally{
                        try{
                                soc.close();
                                }catch(IOException ex){
                                        System.out.println(ex);
                                }
                        }
                }
        }