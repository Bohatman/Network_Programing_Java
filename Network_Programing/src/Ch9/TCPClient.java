/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author phone
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            Socket s = new Socket("127.0.0.1",9999);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = reader.readLine();
            long timeusage = System.currentTimeMillis()-start;
            System.out.println("Client: "+msg );
            System.out.println("Client: Timeusage " +timeusage);
        } catch (Exception e) {
        }
    }
}
