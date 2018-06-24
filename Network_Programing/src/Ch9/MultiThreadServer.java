/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author phone
 */
public class MultiThreadServer extends Thread{
        Socket s;

    public MultiThreadServer(Socket s) {
        this.s = s;
    }
        @Override
    public void run(){
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            ////////////////////////////////////////
            Thread.sleep(10000);
            PrintWriter writer = new PrintWriter(out);
            writer.println("Hello from Server");
            writer.close();
            ///////////////////////////////////////
            s.close();
            System.out.println("Server : Work complete");
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        int port=9999;
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {                
                System.out.println("Server: waiting for client.");
                Socket s = server.accept();
                System.out.println("Server: client connected.");
                MultiThreadServer t = new MultiThreadServer(s);
                t.start();
            }
        } catch (Exception e) {
        }
    }
}
