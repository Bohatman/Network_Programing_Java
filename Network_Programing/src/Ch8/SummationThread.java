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
public class SummationThread implements Runnable{
    int from;
    int to;
    long result;
    public SummationThread(int from,int to){
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
        SummationThread r1 = new SummationThread(1, 250000);
        SummationThread r2 = new SummationThread(250001, 500000);
        SummationThread r3 = new SummationThread(500001, 750000);
        SummationThread r4 = new SummationThread(750001, 1000000);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t1.start();t2.start(); t4.start(); t3.start();
        long total = r1.getResult()+r2.getResult()+r3.getResult()+r4.getResult();
        System.out.println("Result : " + total);
        
    }
}
