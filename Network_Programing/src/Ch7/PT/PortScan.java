/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch7.PT;
import java.io.*;
import java.net.*;
/**
 *
 * @author phone
 */
public class PortScan {
    public static void main(String[] args) {
         Socket socket;
        int port =1;
        while (port<=100) {            
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", port), 1);
            socket.setSoTimeout(1);
            System.out.println("PORT "+port+" open");
            port++;
            socket.close();
        } catch (IOException e) {
            System.out.println("PORT "+port+" close");
            port++;
        }
                }
    }
}
