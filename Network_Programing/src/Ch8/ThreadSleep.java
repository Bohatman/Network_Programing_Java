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
public class ThreadSleep implements Runnable{
    int number;
    long sleepTime;
    public static void main(String[] args) {
        ThreadSleep t1 = new ThreadSleep(1, 3000);
        ThreadSleep t2 = new ThreadSleep(2, 5000);
        Thread n1 = new Thread(t1);
        Thread n2 = new Thread(t2);
        n1.start();
        n2.start();
        System.out.println("Thread Number : Main done");
        }
    public ThreadSleep(int num,long sleep){
        number=num;
        sleepTime=sleep;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(sleepTime);
        }catch(Exception e){}
        System.out.println("Thread Number : "+number+" done");//To change body of generated methods, choose Tools | Templates.
    }
}

