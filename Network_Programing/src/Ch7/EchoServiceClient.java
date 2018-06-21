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
public class EchoServiceClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",7);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("sHello World");
            writer.flush();
            System.out.println("Receive: "+ reader.readLine());
            socket.close();
        } catch (Exception e) {
        }
    }
}
