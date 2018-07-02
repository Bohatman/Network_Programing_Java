/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;
import java.io.*;
import java.net.*;
/**
 *
 * @author phone
 */
public class ClientList {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",5678);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String m;
            while ((m=reader.readLine())!=null) {
                System.out.println(m); 
            }
            s.close();
        } catch (Exception e) {
        }
    }
}
