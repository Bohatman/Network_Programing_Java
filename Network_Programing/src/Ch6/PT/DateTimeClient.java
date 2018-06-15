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
public class DateTimeClient {
    public static void main(String[] args) {
        try {
            DatagramPacket sPacekt = new DatagramPacket(new byte[1], 1,InetAddress.getByName("127.0.0.1"), 9876);
            DatagramSocket socket = new DatagramSocket();
            socket.send(sPacekt);
            DatagramPacket rPacket = new DatagramPacket(new byte[512], 512);
            socket.receive(rPacket);
           System.out.println(new String(rPacket.getData(), 0, rPacket.getLength()));
           socket.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(DateTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(DateTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DateTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
