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
public class CouterwithSyn1 implements Runnable{
    int counter =0;
    Object control = new Object();
    public int getCounter(){return counter;}

    @Override
    public void run() {
        synchronized(control){
       for(int i=0;i<100000;i++)counter++;}
    }
    public static void main(String[] args) {
        CouterwithSyn1 c = new CouterwithSyn1();

        
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        Thread t4 = new Thread(c);
                t1.start();t2.start(); t4.start(); t3.start();
        try {
            t1.join();t2.join();t3.join();t4.join();
        } catch (Exception e) {
        }
        System.out.println("Counter = " + c.getCounter());
    }
    
}
