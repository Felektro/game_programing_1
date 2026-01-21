import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        System.out.println("Server listening on 4999");
        Socket s = ss.accept();
        System.out.println("Connected successfully");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        while (true) {
            String msg = receiveFromClient(bf);  // waits for next message
            //if (msg != null) System.out.println("Received: " + msg);
            System.out.println("Received: " + msg);
        }
    }

    public static void sendToClient(Socket s, String msg){

        try {
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println(msg);
            pr.flush();
        }
        catch (IOException e){
            System.out.println("We got "+e+" exception");
        }

    }

    public static String receiveFromClient(BufferedReader bf){

        try {
            return bf.readLine();
        }
        catch (IOException e){
            System.out.println("We got "+e+" exception");
            return null;
        }
    }
}
