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
/**
 *
 * @author phone
 */
public class Client extends Thread{
    BufferedReader reader;

    public Client(BufferedReader reader) {
        this.reader = reader;
    }
    @Override
    public void run(){
        while (true) {            
            try {
                System.out.println(reader.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        try {
            Socket a = new Socket("127.0.0.1", 5555);
            Client r0 = new Client(new BufferedReader(new InputStreamReader(a.getInputStream())));
            r0.start();
            PrintWriter writer = new PrintWriter(a.getOutputStream());
            while (true) {     
                System.out.print("Me: ");
                writer.println(new Scanner(System.in).nextLine());
                writer.flush();
            }
            } 
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
