/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8;

import java.util.Scanner;

/**
 *
 * @author phone
 */
public class MultiThread implements Runnable{
    int from,to;
    long result;
    public MultiThread(int from , int to){
        this.from=from;
        this.to = to;
        this.result=0;
    }
    public long getResult(){
    return result;
    }
    @Override
    public void run() {
        for(int i = from;i<=to;i++)result+=(long)Math.log(Math.exp(i)); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int numThread=new Scanner(System.in).nextInt();
        long result=0;
        int avglLoad = 100000000 / numThread;
        int firstThreadLoad = avglLoad+(100000000%numThread);
        MultiThread[] c = new MultiThread[numThread];
        Thread[] t = new Thread[numThread];
        t[0]=new Thread(c[0] = new MultiThread(1, firstThreadLoad));
        t[0].start();
        for(int i = firstThreadLoad,j=1;i<100000000;i+=avglLoad,j++){
            t[j] = new Thread(c[j]=new MultiThread(i+1, i+avglLoad));
            t[j].start();
        }
        for(int i=0;i<=numThread;i++){
            try {
                t[i].join();
                result+=c[i].getResult();
            } catch (Exception e) {
            }
        }
        long timeusage = System.currentTimeMillis()-start;
        System.out.println("Result = " +result);
        System.out.println("Time Usage = " +timeusage + " ms");
    }
}
