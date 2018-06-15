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
public class HelloServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8756);
            DatagramPacket packet = new DatagramPacket(new byte[512], 512);
            while (true) {                
            socket.receive(packet);
            String word = new String(packet.getData(),0,packet.getLength());
            packet.setData(("Hello -"+word).getBytes());
            socket.send(packet);
                        }
        } catch (Exception ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
