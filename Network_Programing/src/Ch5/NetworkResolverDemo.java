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
public class NetworkResolverDemo {
    public static void main(String[] args) {
        String Resolving="google.com";
        System.out.println("Resolving :" + Resolving);
        
        try {
            InetAddress addr = InetAddress.getByName(Resolving);
            System.out.println("IP ADDRESS : " + addr.getHostAddress());
            System.out.println("HOST NAME :" + addr.getHostName());
        } catch (UnknownHostException ex) {
            Logger.getLogger(NetworkResolverDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
