package Ch6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
/**
 *
 * @author phone
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
            byte[] rBuffer = new byte[512];
            DatagramPacket rPacket = new DatagramPacket(rBuffer, rBuffer.length);
            DatagramSocket socket = new DatagramSocket(3000);
            while (true) {                
                socket.receive(rPacket);
                DatagramPacket sPacket = new DatagramPacket(rPacket.getData(), rPacket.getLength(), rPacket.getAddress(), rPacket.getPort());
                socket.send(sPacket);
            }
        } catch (Exception e) {
        }
    }
}
