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
public class PacketSendDemo1 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Bound to local port " + socket.getLocalPort());
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintWriter out = new PrintWriter(bout);
            out.print("Hello World!");out.flush();
            byte[] barray = bout.toByteArray();
            DatagramPacket packet =new DatagramPacket(barray, barray.length);
            InetAddress remoteAddr = InetAddress.getByName("127.0.0.1");
            packet.setAddress(remoteAddr);
            packet.setPort(2000);
            socket.send(packet);
        } catch (Exception e) {
        }
    }
}
