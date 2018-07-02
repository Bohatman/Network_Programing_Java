/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author phone
 */
public class ClientDownload {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",5678);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String path;
            writer.println((path=new Scanner(System.in).nextLine()));
            String respond = reader.readLine();
            if(respond.equals("OK")){
                File f = new File(path);
                FileOutputStream fout = new FileOutputStream(f);
                byte[] buffer = new byte[65536];
                int n;
                while ((n=in.read(buffer))>0) {                    
                    fout.write(buffer, 0, n);
                }
                fout.close();
            }
            s.close();
        } catch (Exception e) {
        }
        
    }
}
