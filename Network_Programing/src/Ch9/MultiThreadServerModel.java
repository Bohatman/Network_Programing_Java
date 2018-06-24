/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;
import java.io.*;
import java.net.*;
/**
 *
 * @author phone
 */
public class MultiThreadServerModel extends Thread{
    Socket s;

    public MultiThreadServerModel(Socket s) {
        this.s = s;
    }
    public void run(){
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            ////////////////////////////////////////
            
            ///////////////////////////////////////
            s.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        int port=9999;
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {                
                Socket s = server.accept();
                MultiThreadServerModel t = new MultiThreadServerModel(s);
                t.start();
            }
        } catch (Exception e) {
        }
    }
}
