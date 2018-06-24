/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch8;

/**
 *
 * @author phone
 */
public class BankAccout implements Runnable{
    int balance=0;
    public void deposit(int money){
       for(int i=1;i<=money;i++) balance++;
    }
    public void withdraw(int money){
        for(int i=1;i<=money;i++)balance--;
    }
    public int getBalance(){
        return balance;
    }
    @Override
    public void run() {
        deposit(10000);
        withdraw(10000);
    }
    public static void main(String[] args) {
        BankAccout b = new BankAccout();
        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);
        t1.start();t2.start();
        try {
            t1.join();t2.join();
        } catch (Exception e) {
        }
        System.out.println("Balance = "+b.getBalance());
        
    }
    
}
