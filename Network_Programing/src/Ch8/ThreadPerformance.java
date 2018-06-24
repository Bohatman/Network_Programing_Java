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
public class ThreadPerformance extends Thread{
    public void run(){
    long start = System.currentTimeMillis();
    long result = 0;
    for(int i =1;i<=1000000;i++) result+=(long)Math.log(Math.exp(i));
    long timeusage = System.currentTimeMillis()-start;
        System.out.println("Thread priority = " + this.getPriority() + " Time usage : "+timeusage);
    }
    public static void main(String[] args) {
        ThreadPerformance a = new ThreadPerformance();
        a.setPriority(MAX_PRIORITY);
        a.start();
        ThreadPerformance b = new ThreadPerformance();
        b.setPriority(5);
        b.start();
        ThreadPerformance c = new ThreadPerformance();
        c.setPriority(MIN_PRIORITY);
        c.start();
    }
}
