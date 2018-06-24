/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;
import java.net.*;
import java.io.*;
/**
 *
 * @author phone
 */
public class ThreadServer extends Thread{
    Socket s;

    public ThreadServer(Socket s) {
        this.s = s;
    }
    public void run(){
        try {
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            long result=0;
            for(int i=1;i<=1000000;i++)result+=(long)Math.log(Math.exp(i));
            writer.println("Hello from server");
            writer.flush();
            writer.close();
            s.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3456);
            while (true) {                
                Socket s = server.accept();
                ThreadServer t = new ThreadServer(s);
                t.start();
            }
        } catch (Exception e) {
        }
    }
}
