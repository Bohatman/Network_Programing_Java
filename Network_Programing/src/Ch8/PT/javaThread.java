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
public class javaThread extends Thread{
    int threadNumber;
    public javaThread(int num){
        this.threadNumber = num;
    }
    @Override
    public void run(){
        System.out.println(threadNumber+" - HelloWorld");
    }
    public static void main(String[] args) {
        javaThread[] thread = new javaThread[Integer.parseInt(args[0])];
        for(int i =0;i<Integer.parseInt(args[0]);i++){
            thread[i] = new javaThread(i);
            thread[i].start();}
    }
}
