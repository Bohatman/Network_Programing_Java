/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9.PT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phone
 */
public class Server implements Runnable{
    Socket s;
    static HashMap<Integer, String> Student = new HashMap<>();

    public Server(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            String word = reader.readLine();
            if(word.equals("add")) addStudent(writer,reader);
            if(word.equals("search")) searchStudent(writer, reader);
            else {writer.println("Command not found.");writer.flush();writer.close();}
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void addStudent(PrintWriter writer,BufferedReader reader){
        try {
            Integer key = reader.readLine().hashCode();
            String name = reader.readLine();
            System.out.println("Key is " + key + " Name is " + name);
            Student.put(key, name);
            writer.println("OK");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void searchStudent(PrintWriter writer,BufferedReader reader){
        try {
            Integer key=reader.readLine().hashCode();
            System.out.println("Key is " + key );
            if(Student.containsKey(key))writer.println(Student.get(key));
            else{writer.println("N/A");writer.println(Student.get(key));}
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        try {
            ServerSocket server = new ServerSocket(23410);
            while (true) {
                Socket s = server.accept();
                Server r = new Server(s);
                es.execute(r);
            }
        } catch (Exception e) {
        }
    }
    
}
