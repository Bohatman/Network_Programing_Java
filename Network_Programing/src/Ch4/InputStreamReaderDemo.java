/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch4;
import java.io.*;
/**
 *
 * @author phone
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        try {
            System.err.println("Please enter your name : ");
            InputStream input = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            System.out.println("Nice to meet you "+ bufReader.readLine());
            
            
        } catch (IOException e) {
            System.out.println("Error  IOEXCEPTION " + e);
        }
    }
}
