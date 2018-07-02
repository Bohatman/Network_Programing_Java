/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10.PT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phone
 */
public class Client {
    public static void sent(String[] com){
        try {
            Socket s = connect();
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            writer.println("102");
            writer.println(com[0]);
            writer.println(com[1]);
            writer.flush();
            if(reader.readLine().equals("250"))read(reader);
            else System.out.println("Error 550(Error fromserver)");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public static void sent(String com){
        try {
            Socket s = connect();
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            writer.println("101");
            writer.println(com);
            writer.flush();
            if(reader.readLine().equals("250"))read(reader);
            else System.out.println("Error 550(Error fromserver)");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void read(BufferedReader reader) throws IOException{
        String data;
        while (!((data=reader.readLine()).equals("DONE"))) {            
            System.out.println(data);
        }
    }
    public static Socket connect() throws IOException{
    return  new Socket("127.0.0.1",56789);
    }
    public static void main(String[] args) {
        try {
            String command = new Scanner(System.in).nextLine();
            if(command.contains(" ")&&command.contains("list")){
                char[] arr = command.toCharArray();
                String[] com = {"",""};
                int c=0;
                for(int i=0;i<arr.length;i++){
                    if((arr[i]+"").equals(" ")){
                        c++;
                    }
                    else{
                        com[c]+=arr[i];
                    }
                }
                sent(com);
        }
            else if(command.equals("list")){
                    sent(command);
                
            }

        } catch (Exception e) {
        }
    }
}
