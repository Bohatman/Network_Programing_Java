/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8;

import Ch8.SummationThread;

/**
 *
 * @author phone
 */
public class cSummationThread implements Runnable{
    int from;
    int to;
    long result;
    public cSummationThread(int from,int to){
        this.from = from;
        this.to = to;
        this.result=0;
    }
    public long getResult(){
        return result;
    }
    @Override
    public void run() {
        for(int i=from;i<=to;i++)result+=i; //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        cSummationThread r1 = new cSummationThread(1, 250000);
        cSummationThread r2 = new cSummationThread(250001, 500000);
        cSummationThread r3 = new cSummationThread(500001, 750000);
        SummationThread r4 = new  SummationThread(750001, 1000000);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t1.start();t2.start(); t4.start(); t3.start();
        try {
            t1.join();t2.join();t3.join();t4.join();
        } catch (Exception e) {
        }
        long total = r1.getResult()+r2.getResult()+r3.getResult()+r4.getResult();
        System.out.println("Result : " + total);
        
    }
}
