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
public class SleepyThread implements Runnable{
    public static void main(String[] args) {
        SleepyThread a = new SleepyThread();
        Thread n = new Thread(a);
        n.start();
        try{
        Thread.sleep(3000);
        }catch(InterruptedException e){}
        n.interrupt();
    }
    @Override
    public void run() {
        try{
        Thread.sleep(36000);
            System.out.println("I slept well.");
        }
        catch(Exception e){
            System.out.println("Why did u do that ?");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
}
