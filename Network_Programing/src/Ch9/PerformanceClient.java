/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author phone
 */
public class PerformanceClient extends Thread{
    public void run(){
        try {
            Socket s = new Socket("127.0.0.1",3456);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = br.readLine();
            s.close();
        } catch (Exception e) {
        }
}
    public static void main(String[] args) {
        int n = 2000;
        long start = System.currentTimeMillis();
        PerformanceClient[] c =new PerformanceClient[n];
        for(int i =0;i<n;i++){
            c[i]=new PerformanceClient();
            c[i].start();
        }
        for(int i =0;i<n;i++){
            try {
                c[i].join();
            } catch (Exception e) {
            }
        }
        long timeusage = System.currentTimeMillis()-start;
        System.out.println("Time usage:" + timeusage + " ms");
    }
    
}
