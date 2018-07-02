/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;

import java.io.File;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author phone
 */
public class ServerList implements Runnable{
    Socket s;
    String path ="D:\\Programing";
    public ServerList(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        try {
        File f = new File(path);
        File[] file = f.listFiles();
        PrintWriter writer = new PrintWriter(s.getOutputStream());
        for(int i=0;i<file.length;i++)writer.println(file[i].getName() + " : " + file[i].length());
        writer.flush();writer.close();s.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5678);
            ExecutorService es = Executors.newFixedThreadPool(256);
            while (true) {                
                Socket s = server.accept();
                ServerList r = new ServerList(s);
                es.execute(r);
            }
        } catch (Exception e) {
        }
    }
}
