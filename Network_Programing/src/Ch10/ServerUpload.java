/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author phone
 */
public class ServerUpload implements Runnable{
    Socket s;
    String path = "D:\\Server\\ ";

    public ServerUpload(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            PrintWriter writer = new PrintWriter(out);
            String filename = reader.readLine();
            File f = new File(path + filename);
            
            if(f.exists()){writer.println("NOK");writer.close();
                System.out.println("Error");}
            else {
                writer.println("OK");
                writer.flush();
                FileOutputStream fout = new FileOutputStream(f);
                byte[] buffer = new byte[65536];
                int n;
                while ((n = in.read(buffer))>0) {                    
                    fout.write(buffer, 0, n);
                }
                
                fout.close();
                System.out.println("Done");
            }
            s.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5678);
            ExecutorService es = Executors.newFixedThreadPool(256);
            while (true) {                
                Socket s = server.accept();
                ServerUpload r = new ServerUpload(s);
                es.execute(r);
            }
        } catch (Exception e) {
        }
    }
}
