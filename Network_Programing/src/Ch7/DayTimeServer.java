/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch7;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author phone
 */
public class DayTimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(13);
            System.out.println("Daytime service Started");
            while (true) {                
                Socket socket = server.accept();
                System.out.println("Received request from "+ socket.getInetAddress() +" : " + socket.getPort());
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(new Date().toString());
                writer.flush();
                socket.close();
            }
        } catch (Exception e) {
        }
    }
}
