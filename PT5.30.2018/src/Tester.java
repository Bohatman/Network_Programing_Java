/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phone
 */
public class Tester {
    public static void main(String[] args) {
        
       /* Object a = 3;
        Comparable ca = (Comparable)a;
        Object b = null;
        Comparable cb = (Comparable)b;
        System.out.println(ca.compareTo(cb));*/
       /*
       Object[] c = {1,2,3,4,5,6,7,8,9,10};
       BinaryHeap b = new BinaryHeap(c);
       /*a.enqueue(10);
       a.enqueue(12);
       a.enqueue(16);
       a.enqueue(13);
       a.enqueue(15);
       */
       /*
       BinaryHeap a = new BinaryHeap(b,3);
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());*/
       BSTree a = new BSTree();
       a.add(1);a.add(2);a.add(3);a.add(4);a.add(5);a.add(6);a.add(7);a.add(8);a.add(9);a.add(10);
        System.out.println(a.select(1));
        
        
    }
}
