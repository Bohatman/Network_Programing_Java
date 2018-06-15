/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch6_Extra;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phone
 */
public class ChatServer {
    public static void main(String[] args) {
        int user = 0;
        int maxUser=2;
        int[] portuser = new int[maxUser];
        InetAddress[] userAdd = new InetAddress[maxUser];
        try {
            DatagramSocket socket = new DatagramSocket(5555);
            DatagramPacket packets = new DatagramPacket(new byte[256], 256);
       
        while (user!= maxUser) {  
        System.out.println("Waiting " + user);
         socket.receive(packets);
         portuser[user] = packets.getPort();
         userAdd[user] = packets.getAddress();
         System.out.println("PORT : "+portuser[user++]+" Connected");
         if(user==2){
             byte[] word = "Hi".getBytes();
             socket.send(new DatagramPacket(word, word.length, userAdd[0], portuser[0]));
         }
        }
        DatagramPacket tempPacket = new DatagramPacket(new byte[1024], 1024);
        while (true) {                
                
        }
        } catch (SocketException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}
