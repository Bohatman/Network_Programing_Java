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
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        try {
            OutputStream output = System.out;
            OutputStreamWriter writer = new OutputStreamWriter(output);
            writer.write("Hi");
            writer.flush();writer.close();
        } catch (Exception e) {
        }
    }
}
