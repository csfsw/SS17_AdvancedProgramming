import java.net.*;
import java.io.*;
public class Server{
    static ServerSocket listener;
    static Socket soc;
    static PrintWriter out;
    static BufferedReader in;
    public static void main(String args[]){
        try{
                listener = new ServerSocket(9060);
                soc = listener.accept();
                out = new PrintWriter(soc.getOutputStream(),true);
                out.println("This is server khan");
        } catch (IOException ex){
            System.out.println(ex);
        } finally{
             try{
               soc.close();
                } catch (IOException ex){
                        System.out.println(ex);
                        }
                }
        }
    }