/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch5.PT;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.net.*;

/**
 *
 * @author phone
 */
public class JavaIP {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new FileReader("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch5\\PT\\demo.txt"));
            InetAddress Address;
            while (input.hasNext()) {                
                 Address = InetAddress.getByName(input.next());
                 System.out.println("IP Address : " +Address.getHostAddress());
                 System.out.println("Host name :" +Address.getHostName());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error - nedd an argument");
        } catch (UnknownHostException ex) {
            System.out.println("Error: unknown host or IP address");
        }
    }
}
