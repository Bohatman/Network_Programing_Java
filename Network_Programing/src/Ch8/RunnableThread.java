/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8;

/**
 *
 * @author phone
 */
public class RunnableThread implements Runnable {
    int threadNumber;
    public RunnableThread(int num){
    threadNumber = num;
    }
    @Override
    public void run() {
        System.out.println("Thread number: "+threadNumber);
    }
    public static void main(String[] args) {
        RunnableThread r1 = new RunnableThread(1);
        RunnableThread r2 = new RunnableThread(2);
        RunnableThread r3 = new RunnableThread(3);
        RunnableThread r4 = new RunnableThread(4);
        RunnableThread r5 = new RunnableThread(5);
        RunnableThread r6 = new RunnableThread(6);
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);
        Thread t6 = new Thread(r6);
                t1.start();t2.start();t3.start();
        t4.start();t5.start();t6.start();
    }
    
}
