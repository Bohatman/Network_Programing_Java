/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch6;
import java.io.*;
import java.net.*;
/**
 *
 * @author phone
 */
public class EchoClient {
    public static void main(String[] args) {
        try {
            byte[] sBuffer;
            byte[] rBuffer = new byte[256];
            sBuffer = "Hi bitch".getBytes();
            InetAddress serverAdr = InetAddress.getByName("127.0.0.1");
            DatagramPacket sPacket = new DatagramPacket(sBuffer, sBuffer.length, serverAdr, 3000);
            DatagramSocket socket = new DatagramSocket();
            socket.send(sPacket);
            DatagramPacket rPacket = new DatagramPacket(rBuffer, rBuffer.length);
            socket.receive(rPacket);
            String msg = new String(rPacket.getData(),0,rPacket.getLength());
            System.out.println("Echo message : "+ msg);
            socket.close();
        } catch (Exception e) {
        }
    }
}
