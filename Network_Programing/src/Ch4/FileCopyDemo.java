/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch4;
import java.io.*;
/**
 *
 * @author phone
 */
public class FileCopyDemo {
    public static void main(String[] args) {
    int data;
    try {
        FileInputStream fin = new FileInputStream("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\demo.txt");
        FileOutputStream fout = new FileOutputStream("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\demo_1.txt");
        while((data = fin.read()) !=-1){
            fout.write(data);
        }
        fin.close();
        fout.close();
    }catch(IOException e){
        System.out.println("I/O ERROR: " +e);}
    }
}
