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
            while(true){
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
                        System.out.print("Enter a message : ");
                        String message = scan.nextLine();
                        System.out.println("");
                        out.println(message);
                    }
                    if(line.startsWith("MESSAGE")){
                        System.out.print(line);
                        String message = scan.nextLine();
                        System.out.println("");
                        out.println(message);
                    }
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
}