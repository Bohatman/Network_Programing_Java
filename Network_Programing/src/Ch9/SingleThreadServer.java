/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;
import java.io.*;
import java.net.*;
/**
 *
 * @author phone
 */
public class SingleThreadServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3456);
            while (true) {                
                System.out.println("Server: waiting for client.");
                Socket s = server.accept();
                System.out.println("Server : client connected");
                PrintWriter writer = new PrintWriter(s.getOutputStream());
                Thread.sleep(10000);
                writer.println("Hello from Server");
                writer.close();
                s.close();
                System.out.println("Server: Work complete");
            }
        } catch (Exception e) {
        }
    }
}
