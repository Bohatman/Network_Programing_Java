/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch4;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author phone
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        //String pathString = a.nextLine();
        int data;
        //if(pathString.length() <= 0){
          //  System.out.println("Usage: FileInputStreamDemo File");
          //  System.exit(1);
        //}
        
            try (FileInputStream fin = new FileInputStream("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\demo.txt")) {
                while ((data = fin.read())!= -1) {
                    System.out.write(data);
                }
                fin.close();
            }
        catch(IOException e){
            System.out.println("I/O error: "+e);
        }
    }
}
