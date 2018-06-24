/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author phone
 */
public class ThreadPoolServer implements Runnable{
    Socket s;

    public ThreadPoolServer(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            long result=0;
            for(int i=1;i<=1000000;i++) result+=(long)Math.log(Math.exp(i));
            writer.println("Hi");
            writer.flush();writer.close();
            s.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(256);
        try {
            ServerSocket server = new ServerSocket(3456);
            while (true) {                
                Socket s = server.accept();
                ThreadPoolServer a = new ThreadPoolServer(s);
                ex.execute(a);
            }
        } catch (Exception e) {
        }
    }
}
