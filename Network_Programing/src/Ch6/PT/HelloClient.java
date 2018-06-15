/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch6.PT;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phone
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = "HELLO".getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length,InetAddress.getByName("127.0.0.1"),8756);
            System.out.println(new String(packet.getData(),0, packet.getLength()));
            socket.send(packet);
            DatagramPacket rpacket = new DatagramPacket(new byte[512], 512);
            socket.receive(rpacket);
            System.out.println(new String(rpacket.getData(),0, rpacket.getLength()));
            socket.close();
        } catch (Exception ex) {
            Logger.getLogger(HelloClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
