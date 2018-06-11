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
public class JavaTextCopy {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\PT\\demo.txt"));
            PrintWriter writer = new PrintWriter(new File("C:\\Users\\phone\\OneDrive\\Documents\\NetBeansProjects\\JAVA_WORK\\Network_Programing\\src\\Ch4\\PT\\demo_1.txt"));
            String word;
            while ((word =reader.readLine())!=null) {       
                System.out.println(word);
                writer.println(word);
            }
            writer.flush();writer.close();reader.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
