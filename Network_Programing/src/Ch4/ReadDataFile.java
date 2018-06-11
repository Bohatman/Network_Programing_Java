/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch4;
import  java.io.*;
/**
 *
 * @author phone
 */
public class ReadDataFile {
    public static void main(String[] args) {
        int intdData;
        double doubleData;
        boolean boolData;
        
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\demo.txt");
            DataInputStream din = new DataInputStream(fin);
            intdData = din.readInt();
            doubleData = din.readDouble();
            boolData = din.readBoolean();
            System.out.println("intData = " + intdData);
            System.out.println("doubleData = " +doubleData);
            System.out.println("boolData = " + boolData);
            din.close();
            fin.close();
        } catch (IOException e) {
           System.out.println("Error");
        }
    }
}
