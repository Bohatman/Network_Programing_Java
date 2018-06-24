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
public class Waiter extends Thread{
    public void run(){
        synchronized(this){
            try{
                System.out.println("Waiter : waiting");
                this.wait();
            }catch(Exception e){}
            System.out.println("Waiter : yes sir.");
        }
    }
    public static void main(String[] args) {
        Waiter w = new Waiter();
        w.start();
        try {
            Thread.sleep(2000);
            
        } catch (Exception e) {
        }
        System.out.println("Main : Can i order, Please.");
        synchronized(w){
            w.notify();
        }
    }
}
