/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phone
 */
public class GroupDemo implements Runnable{

    @Override
    public void run() {
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GroupDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        ThreadGroup parent = new ThreadGroup("parent");
        ThreadGroup subgroup = new ThreadGroup(parent, "subgroup");
        Thread t1 = new Thread(parent, new GroupDemo());
        t1.start();
        Thread t2 = new Thread(parent, new GroupDemo());
        t2.start();
        Thread t3 = new Thread(subgroup,new GroupDemo());
        t3.start();
        parent.list();
        System.out.println("");
        subgroup.list();
                
    }
    
}
