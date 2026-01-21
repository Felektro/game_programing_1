import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.net.*;
import java.io.*;

/**
 * Write a description of class NetworkClientActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NetworkClientActor extends Actor 
{
    Socket s;
    
        NetworkClientActor(){
        //make invisible
        GreenfootImage img = new GreenfootImage(1, 1);
        img.setTransparency(0);
        setImage(img);
        
        try {
            s = new Socket("localhost", 4999);
            System.out.println("Greenfoot connection successful");
        }
        catch (IOException e){
            System.out.println("Greenfoot could not connect");
            System.out.println(e);
            s = null;
        }

    }
    
    public void act()
    {   
        if(Greenfoot.isKeyDown("space")){
            System.out.println("we just pressed space on the client");
            
            sendToServer(s, "WE JUST PRESSED SPACE");
        }
        
        /*
        if(receiveFromServer(s) != null){
            System.out.println("Server: "+ receiveFromServer(s));    
        }
        */
    }

    public static void sendToServer(Socket s, String msg){

        try {
            System.out.println("Trying to send: "+ msg);

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
    
    public void reconnectToServer(Socket s){
        try {
            s = new Socket("localhost", 4999);
            System.out.println("Greenfoot connection successful");
        }
        catch (IOException e){
            System.out.println("Greenfoot could not connect");
            System.out.println(e);
            s = null;
        }
    }
}
