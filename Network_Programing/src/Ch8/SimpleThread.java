/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8;
import java.lang.Thread;
/**
 *
 * @author phone
 */
public class SimpleThread extends Thread {
    int threadNumber;
    public  SimpleThread(int num){
        threadNumber = num;
    }
    @Override
    public void run(){
        System.out.println("Thread number: "+threadNumber);
    }
    public static void main(String[] args) {
        Thread t1 = new SimpleThread(1);
        Thread t2 = new SimpleThread(2);
        Thread t3 = new SimpleThread(3);
        Thread t4 = new SimpleThread(4);
        Thread t5 = new SimpleThread(5);
        Thread t6 = new SimpleThread(6);
        t1.start();t2.start();t3.start();
        t4.start();t5.start();t6.start();
       
        
    }
}
