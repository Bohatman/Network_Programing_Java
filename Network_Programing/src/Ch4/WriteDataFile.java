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
public class WriteDataFile {
    public static void main(String[] args) {
        int intData = 10;
        double doubleData = 10.5;
        boolean boolData = true;
        try{
        FileOutputStream fout = new FileOutputStream("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\demo.txt");
        DataOutputStream dout = new DataOutputStream(fout);
        dout.writeInt(intData);
        dout.writeDouble(doubleData);
        dout.writeBoolean(boolData);
        dout.close();
        fout.close();
        
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}
