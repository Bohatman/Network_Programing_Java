/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10.PT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author phone
 */
public class GetWeb {
    public static void main(String[] args) {
        try {
            String msg;
            String Web=new Scanner(System.in).nextLine();
            Socket s = new Socket(Web,80);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            writer.println("GET /index.html HTTP/1.1");writer.flush();
            writer.println("HOST: "+Web);writer.flush();
            writer.println("Connection: close");writer.flush();
            writer.println("");writer.flush();
            writer.flush();
            while ((msg=reader.readLine())!=null) {
            
                System.out.println(msg);
            }
            writer.close();
            s.close();
        } catch (Exception e) {
        }
    }
}
