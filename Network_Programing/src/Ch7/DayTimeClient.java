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
public class DayTimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",13);
            System.out.println("Connection established");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String daytime = reader.readLine();
            System.out.println("Results : " + daytime);
            socket.close();
        } catch (Exception e) {
        }
    }
}
