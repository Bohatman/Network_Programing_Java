/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch6.PT;
import java.io.*;
import java.net.*;
import java.util.Date;
/**
 *
 * @author phone
 */
public class DateTimeServer {
    public static void main(String[] args) {
        Date time = new Date();
        try {
            DatagramPacket rPacket = new DatagramPacket(new byte[256], 256);
            DatagramSocket socket = new DatagramSocket(9876);
            socket.receive(rPacket);
            System.out.println("Received");
            rPacket.setData(time.toString().getBytes());
            socket.send(rPacket);
        } catch (Exception e) {
        }
    }
}
