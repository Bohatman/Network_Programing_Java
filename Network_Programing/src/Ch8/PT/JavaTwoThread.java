/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8.PT;

/**
 *
 * @author phone
 */
public class JavaTwoThread implements Runnable{
    int result,start,end;
    long cooldown;
    public JavaTwoThread(int start,int end,long cooldown) {
    this.start=start;
    this.end = end;
    this.cooldown = cooldown;
    result=0;
    
    }
    public int getResult(){
        return result;
    }
    
    @Override
    public void run() {
        for(int i = start;i<=end;i++)result+=i;
        try {
            Thread.sleep(cooldown);
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        JavaTwoThread r1 = new JavaTwoThread(1, 5000, 5000);
        JavaTwoThread r2 = new JavaTwoThread(5001, 10000, 10000);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();t2.start();
        try {
            t1.join();t2.join();
        } catch (Exception e) {
        }
        int result = r1.getResult()+r2.getResult();
        System.out.println("Result is " +result);
    }
    
}
