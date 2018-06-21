/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch7.PT;

import java.util.HashMap;
import java.io.*;
import java.net.*;
/**
 *
 * @author phone
 */
public class Server {
    public static void main(String[] args) {
        try {
        ServerSocket server = new ServerSocket(23410);
        HashMap data = new HashMap();
        while (true) {            
            
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String input;
                if((input=reader.readLine()).equals("add")){
                input = reader.readLine();
                System.out.println(input);
                data.put(input.hashCode(), reader.readLine());
                writer.println("OK");
                writer.flush();
                }
                if(input.equals("search")){
                writer.println(data.get(reader.readLine().hashCode()));
                writer.flush();
                }
                else {
                writer.println("Command not found");
                writer.flush();
                }
                socket.close();
            }
        }
        catch (Exception e) {
            }
    }
}
