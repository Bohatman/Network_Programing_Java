/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch9.PT;
import Ch7.PT.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author phone
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 23410);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            Scanner input = new Scanner(System.in);
            String Command = input.nextLine();
            char[] arr = Command.toCharArray();
            String[] word=new String[3];
            int j=0;
            word[j]="";
            for(int i=0;i<arr.length;i++){
                if((arr[i]+"").equals(" "))word[++j]="";
                else word[j] += arr[i];
            }
            writer.println(word[0]); writer.println(word[1]); writer.println(word[2]);
            writer.flush();
            System.out.println(reader.readLine());
        } catch (Exception e) {
        }
    }
}
