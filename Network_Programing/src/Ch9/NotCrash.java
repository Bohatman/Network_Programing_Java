/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;
import java.util.Scanner;
import java.util.concurrent.*;
/**
 *
 * @author phone
 */
public class NotCrash implements Runnable{
    int id;

    public NotCrash(int id) {
    this.id=id;
    }
    
    @Override
    public void run() {
        int buffer[] = new int[50000000];
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        System.out.println(id+" : Done");
    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        int n = new Scanner(System.in).nextInt();
        for(int i=0;i<n;i++){
        NotCrash c = new NotCrash(i);
        es.execute(c);
        }
        es.shutdown();
        try {
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }
    
}
