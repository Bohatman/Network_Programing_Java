/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10.PT;
// เงื่อนไขยังไม่ครบ
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phone
 */
public class FileServer implements Runnable{
    Socket s;
    String path="D:\\Server\\";
    BufferedReader reader;
    PrintWriter writer;
    File f;
    

    public FileServer(Socket s) {
        this.s = s;
        try {
            this.reader=new BufferedReader(new InputStreamReader(s.getInputStream()));
            this.writer = new PrintWriter(s.getOutputStream());
            this.f =new File(path);
        } catch (IOException ex) {
            Logger.getLogger(FileServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try {
            writer.println("220");
            writer.flush();
            String command = reader.readLine();
            switch(command){
                case "upload": upload();break;
                case "download": download();break;
                case "list": list();break;
                default: pencii("command not found");closeAll();break;
            }
        } catch (IOException ex) {
            Logger.getLogger(FileServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void closeAll() throws IOException{
        pencii("221");reader.close();writer.close();s.close();
    }
    public void pencii(String word){
        writer.println(word);writer.flush();
    }
    public void upload() throws IOException{
        pencii("250");
        File file = new File(path+reader.readLine());
        if(file.exists()){pencii("ERROR");closeAll();}
        else{
            FileOutputStream out = new FileOutputStream(file);
            
            byte[] buff = new byte[65535];
            int data;
            while ((data = s.getInputStream().read(buff))!=1) {                
                out.write(buff, 0, data);
            }
            out.close();
        }
    }
    public void download() throws IOException{
        pencii("250");
        File file = new File(path+reader.readLine());
        if(!file.exists()){
            pencii("ERROR");
            closeAll();
        }else{
        OutputStream out = s.getOutputStream();
        FileInputStream in = new FileInputStream(file);
        int data;    
        byte[] buffer = new byte[65535];
        while ((data = in.read(buffer))!=-1) {                
                out.write(buffer, 0, data);
            }
        out.close();
            
        }
        
    }
    public void list(){
        pencii("250");
        String[] flist = f.list();
        for (String string : flist) {
            pencii(string);
        }
        pencii("DONE");
    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        try {
            ServerSocket server = new ServerSocket(6789);
            while (true) {                
                Socket s = server.accept();
                FileServer r = new FileServer(s);
                es.execute(r);
            }
        } catch (Exception e) {
        }
    }
    
}
