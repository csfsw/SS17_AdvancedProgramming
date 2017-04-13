import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient{
    private String chatServerAdd;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scan;
    private int Port = 9080;
    private Socket socket;
    public SimpleChatClient(String add){
        this.chatServerAdd = add;
    }
    public void run(){
        try{
            socket = new Socket(chatServerAdd, Port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            scan = new Scanner(System.in);
            new ServerReader(in);
            while(true){
                synchronized(in){
                    String line = in.readLine();
                    if(line == null) return;
                    if(line.startsWith("SUBMITUSERNAME")){
                        System.out.print("Enter a user name : ");
                        String userName = scan.nextLine();
                        System.out.println("");
                        out.println(userName);
                    }
                    if(line.startsWith("USERNAMERESERVED")){
                        System.out.print("Username reserved enter other name  : ");
                        String userName = scan.nextLine();
                        System.out.println("");
                        out.println(userName);
                    }
                    if(line.startsWith("USERNAMEACCEPTED")){
                        System.out.println("User Name accepted");
                        break;
                    }
                }
                    
            }
            while(true){
                String message = scan.nextLine();
                out.println(message);
            }
        }catch(IOException ex){
            System.out.println(ex);
        }finally{
            try{ socket.close();} catch(IOException exc){
                System.out.println(exc);
            }
        }
    }
    public static void main(String args[]){

        SimpleChatClient client = new SimpleChatClient(args[0]);
        client.run();
    }
    private class ServerReader extends Thread{
        private BufferedReader in;
        public ServerReader(BufferedReader in){
            this.in = in;
            start();
        }
        public void run(){
             try{
                  System.out.println("Client Server Message thread started");
                while(true){
                   
                    synchronized (in){
                        String message = in.readLine();
                        if(message ==null) return;
                        if(message.startsWith("MESSAGE")){
                            System.out.println(message.substring(8));
                            }
                    }
                    
                }
            }catch (IOException ex){
                            System.out.println(ex);
            }
        }
    }
}