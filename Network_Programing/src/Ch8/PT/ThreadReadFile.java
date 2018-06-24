/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8.PT;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phone
 */
public class ThreadReadFile implements Runnable{
    BufferedReader reader;
    int threadNum;
    public ThreadReadFile(File d,int num) {
        this.threadNum=num;
        try {
            reader = new BufferedReader(new FileReader(d));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
    
    @Override
    public void run() {
        try {
            String word;
            while ((word = reader.readLine())!=null) {
                System.out.println("Thread " + threadNum +" : "+word);
            }
            reader.close();
            //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
           
        }
    }
    public static void main(String[] args) {
        if(args.length!=2) System.out.println("Error Args");
        ThreadReadFile r1 = new ThreadReadFile(new File(args[0]), 1);
        ThreadReadFile r2 = new ThreadReadFile(new File(args[1]), 2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();t2.start();
        
    }
    
}
