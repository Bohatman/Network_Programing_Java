/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch4.PT;
import java.io.*;
/**
 *
 * @author phone
 */
public class JavaBinaryCopy {
    public static void main(String[] args) {
        try {
        FileInputStream fin = new FileInputStream("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\PT\\demo.txt");
        FileOutputStream fout = new FileOutputStream("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\PT\\demo_1.txt");
        int data;    
        while ((data = fin.read())!= -1) {                
                fout.write(data);
            }
        fin.close();
        fout.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }
}
