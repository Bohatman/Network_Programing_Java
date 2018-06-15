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
public class PacketReceiveDemo1 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(2000);
            DatagramPacket packet = new DatagramPacket(new byte[256], 256);
            socket.receive(packet);
            System.out.println("Packet received!");
            InetAddress remoteAddr = packet.getAddress();
            System.out.println("Sent by : " + remoteAddr.getHostAddress());
            System.out.println("Sent from : " + packet.getPort());
            ByteArrayInputStream in = new ByteArrayInputStream(packet.getData());
            int data;
            for(int i=0;i<packet.getLength();i++){
                if((data=in.read())==-1)break;
                else System.out.print((char) data);
                socket.close();
        }
        } catch (Exception e) {
        }
    }
}
