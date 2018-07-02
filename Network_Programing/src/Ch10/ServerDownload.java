/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *
 * @author phone
 */
public class ServerDownload implements Runnable{
    Socket s;
    String path="D:\\Server\\";

    public ServerDownload(Socket s) {
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
            File f = new File(path+filename);
            if(!f.exists()){writer.println("NOK");writer.flush();}
            else{ writer.println("OK");writer.flush();
            FileInputStream fin = new FileInputStream(f);
            byte[] buffer = new byte[65536];
            int n;
            while ((n = fin.read(buffer))>0) {                
                out.write(buffer, 0, n);
            }
            fin.close();
          }s.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(256);
        try {
            ServerSocket server = new ServerSocket(2678);
            while (true) {                
                Socket s = server.accept();
                ServerDownload t = new ServerDownload(s);
                es.execute(t);
            }
        } catch (Exception e) {
        }
    }
    
}
