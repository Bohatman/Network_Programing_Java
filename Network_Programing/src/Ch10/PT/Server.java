/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10.PT;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phone
 */
public class Server implements Runnable{
    Socket s;
    String path="D:\\Server\\";

    public Server(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        File f = new File(path);
        boolean c=false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            String userCommand = reader.readLine();
            if(userCommand.equals("101")){
                writer.println("250");
                writer.flush();
                File[] file = f.listFiles();
                for (File file1 : file) {
                    writer.println(file1.getName()+" : " + file1.length());
                }
                writer.println("DONE");
                writer.flush();
            }
           else if(userCommand.equals("102")){
                if(reader.readLine().equals("list")){
                int len = Integer.parseInt(reader.readLine());
                writer.println("250");
                writer.flush();
                File[] file = f.listFiles();
                for (File file1 : file) {
                 if(file1.length()>=len)
                    writer.println(file1.getName()+" : " + file1.length());
                }
                writer.println("DONE");
                writer.flush();
                }
            }
                writer.close();
                s.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(7);
        try {
            ServerSocket server = new ServerSocket(56789);
            while (true) {                
                Socket s =server.accept();
                Server r = new Server(s);
                es.execute(r);
            }
        } catch (Exception e) {
        }
    }
    
}
