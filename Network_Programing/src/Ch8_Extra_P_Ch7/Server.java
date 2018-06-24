/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8_Extra_P_Ch7;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
/**
 *
 * @author phone
 */
public class Server extends Thread{
    Socket c;

    public Server(Socket c) {
        this.c = c;
    }
    @Override
    public void run(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            while (true) {
                System.out.println("Client said: "+ reader.readLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5555);
            Socket c = server.accept();
            Server reader = new Server(c);
            reader.start();
            PrintWriter writer = new PrintWriter(c.getOutputStream());
            while (true) {                
                System.out.print("Server: ");
                writer.println(new Scanner(System.in).nextLine());
                writer.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
