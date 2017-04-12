import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleChatServer{
    private static final int Port=9080;
    private static HashSet<String> users = new HashSet<String>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    public static void main(String args[]) throws IOException{
        ServerSocket listener = new ServerSocket(Port);
        try{
            while(true){
                 new Handler(listener.accept()).start();
            } 
        }catch (IOException exc){
            System.out.println(exc);
        }finally{
             try{ listener.close();} catch(IOException exc){
                System.out.println(exc);
            }
        }

    }
    public static class Handler extends Thread{
        private String uname;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        public Handler(Socket soc){
            this.socket = soc;
        }
        public void run(){
            try{
                in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                while(true){
                   out.println("SUBMITUSERNAME");
                   String name = in.readLine();
                   if(name == null) return; 
                   synchronized (users){
                    if(!users.contains(name)){
                       this.uname = name;
                       users.add(name);
                       break;
                   }else {
                       out.println("USERNAMERESERVED");
                   }
                   }
                }
                 writers.add(out);
                out.println("USERNAMEACCEPTED");
                
                while(true){
                    String message = in.readLine();
                    if(message == null) return;
                    for(PrintWriter writer: writers){
                        writer.println("MESSAGE " + uname + " ->  "+ message);
                    }
                }
            }catch (IOException exc){
            System.out.println(exc);
        }finally{
            try{ socket.close();} catch(IOException exc){
                System.out.println(exc);
            }
           
        }
        }
    }
}