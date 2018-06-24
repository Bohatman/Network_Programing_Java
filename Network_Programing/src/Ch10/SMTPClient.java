/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author phone
 */
public class SMTPClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",2500);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            String msg = reader.readLine();System.out.println(msg);
            
            writer.println("HELO google.com");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("MAIL FROM:<mark@ghh.com>");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("RCPT TO:<mark2@ghh.com>");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("DATA");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("Subject: Hello");writer.flush(); 
            writer.println("Hello");writer.flush(); 
            writer.println(".");writer.flush(); 
            msg = reader.readLine();System.out.println(msg);

            writer.println("QUIT");writer.flush(); 
            msg = reader.readLine();System.out.println(msg);
            
            writer.close();
            s.close();
        } catch (Exception e) {
        }
    }
}
