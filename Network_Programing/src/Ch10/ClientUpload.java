/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch10;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author phone
 */
public class ClientUpload {
    public static void main(String[] args) {
        File f = new File(new Scanner(System.in).nextLine());
        if(!f.exists()){System.out.println("Error1");System.exit(1);}
        if(!f.isFile()){System.out.println("Error2");System.exit(1);}
        try {
            Socket s = new Socket("127.0.0.1",5678);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            writer.println(f.getName());
            writer.flush();
            String respond  = reader.readLine();
            if(respond.equals("OK")){
            FileInputStream fin = new FileInputStream(f);
            byte[] buffer = new byte[65536];
            int n;
                while ((n=fin.read(buffer))>0) {                    
                    out.write(buffer, 0, n);
                }
                fin.close();
            }
            out.close();
            s.close();
        } catch (Exception e) {
        }
    }
}
