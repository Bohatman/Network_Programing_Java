/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author phone
 */
public class FileDemo1 {
    public static void main(String[] args) {
        try {
            File f = new File(new Scanner(System.in).nextLine());
            if(f.isFile())System.out.println("Size : "+f.length());
            else if(f.isDirectory()){String[] filename = f.list(); for (String string : filename)System.out.println(string);
}else System.out.println("Error - File not found");
            
        } catch (Exception e) {
        }
    }
}
