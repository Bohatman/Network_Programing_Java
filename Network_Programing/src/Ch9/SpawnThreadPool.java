/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;

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
public class SpawnThreadPool implements  Runnable{

    @Override
    public void run() {
        //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        int n= new Scanner(System.in).nextInt();
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newSingleThreadExecutor();
        for(int i=0;i<n;i++){
            SpawnThreadPool c = new SpawnThreadPool();
            es.execute(c);
        }
        es.shutdown();
        try {
            es.awaitTermination(60, TimeUnit.SECONDS);
            long timeusage = System.currentTimeMillis()-start;
            System.out.println("Time usage : "+timeusage);
        } catch (InterruptedException ex) {
            Logger.getLogger(SpawnThreadPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
