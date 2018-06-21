/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch7;
import java.io.*;
import java.net.*;
/**
 *
 * @author phone
 */
public class EcoServiceServer {
    public static void main(String[] args) {
        try {
                              
            ServerSocket server = new ServerSocket(7);
            while (true) { 
            Socket socket = server.accept();
                System.out.println("Connected");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            String word = reader.readLine();
                System.out.println(word);
                writer.println(word);
            
            writer.flush();
            socket.close();
                        }
        } catch (Exception e) {
        }
    }
}
