/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch5.PT;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;

/**
 *
 * @author phone
 */
public class JavaIP2 {
    public static void main(String[] args) {
        String input = "facebook.com";
        try {
            FileWriter fout = new FileWriter(new File("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch5\\PT\\demo2.txt"),true);
            BufferedWriter output = new BufferedWriter(fout);
            InetAddress Address = InetAddress.getByName(input);
            output.append("IP Address :" + Address.getHostAddress()+"\n");
            output.append("Host name :" + Address.getHostName()+"\n");
            output.flush();
            fout.close();
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(JavaIP2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
