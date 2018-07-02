/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10.PT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phone
 */
public class JavaMailBomb implements Runnable{
    Socket s;

    public JavaMailBomb(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            String msg = reader.readLine();System.out.println(msg);
            
            writer.println("HELO google.com");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("MAIL FROM:<admin@kmutnb.ac.th>");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("RCPT TO:<choopan@noname.com>");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("DATA");writer.flush(); msg = reader.readLine();System.out.println(msg);
            
            writer.println("Subject: Dear user,");writer.flush(); 
            writer.println("Nice to meet you. :)");writer.flush(); 
            writer.println(".");writer.flush(); 
            
        } catch (IOException ex) {
            Logger.getLogger(JavaMailBomb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        try {
            int num = new Scanner(System.in).nextInt();
            ExecutorService es = Executors.newFixedThreadPool(3);
            while (num>=0) {                
                Socket s = new Socket("127.0.0.1", 8000);
                JavaMailBomb r = new JavaMailBomb(s);
                es.execute(r);
                num--;
            }
        } catch (Exception e) {
        }
    }
    
}
