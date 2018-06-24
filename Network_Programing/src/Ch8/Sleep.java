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
public class Sleep {
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Thread interupted");
        }
        System.out.println("Bye Bye");
    }
}
