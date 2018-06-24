/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9.PT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phone
 */
public class FileThreadPool implements Runnable{
    int data;

    public FileThreadPool(int data) {
        this.data = data;
    }
    @Override
    public void run() {
        System.out.println(data+" -> " + Math.pow(data, 2));
    }
    public static void main(String[] args) {
        File input = new File(new Scanner(System.in).nextLine());
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String word;
            while ((word = reader.readLine())!=null) {                
                FileThreadPool r = new FileThreadPool(Integer.parseInt(word));
                es.execute(r);
            }
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileThreadPool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileThreadPool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(FileThreadPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
