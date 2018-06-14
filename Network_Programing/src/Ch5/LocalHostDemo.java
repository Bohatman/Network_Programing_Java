/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch5;

/**
 *
 * @author phone
 */
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LocalHostDemo {
    public static void main(String[] args) {
        System.out.println("Looking up local host");
        
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("IP ADDRESS: " + localAddress.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(LocalHostDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
