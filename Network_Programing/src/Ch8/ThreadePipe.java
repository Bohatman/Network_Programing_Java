/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8;
import java.io.*;
/**
 *
 * @author phone
 */
public class ThreadePipe implements Runnable{
    PipedOutputStream pout;
    public ThreadePipe(PipedOutputStream pouT){
    this.pout=pouT;
    }
    @Override
    public void run() {
        PrintWriter pw = new PrintWriter(pout);
        pw.println("Hello from thread.");
        pw.println("Do u get my message ?");
        pw.flush();
        pw.close();
    }
    public static void main(String[] args) {
        try {
            PipedOutputStream pout = new PipedOutputStream();
            PipedInputStream pin = new PipedInputStream(pout);
            BufferedReader br = new BufferedReader(new InputStreamReader(pin));
            ThreadePipe tp = new ThreadePipe(pout);
            Thread t1 = new Thread(tp);
            t1.start();
            String smg;
            while ((smg = br.readLine())!=null) {                
                System.out.println(smg);
            }
        } catch (Exception e) {
        }
    }
    
}
