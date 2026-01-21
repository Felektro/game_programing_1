import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 4999);

        sendToServer(s, "Is it still working");

        System.out.println("Server: "+ receiveFromServer(s));
    }

    public static void sendToServer(Socket s, String msg){

        try {

            System.out.println("Trying to send: "+msg);
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println(msg);
            pr.flush();
        }
        catch (IOException e){
            System.out.println("We got "+e+" exception");
        }

    }

    public static String receiveFromServer(Socket s){

        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            return bf.readLine();
        }
        catch (IOException e){
            System.out.println("We got "+e+" exception");
            return null;
        }

    }
}
