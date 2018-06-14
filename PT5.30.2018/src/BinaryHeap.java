/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phone
 */
public class BinaryHeap implements PriorityQueue{
    private int size=0;
    private Object[] elementData = new Object[1];

    public BinaryHeap() {
    }
    public BinaryHeap(BinaryHeap h,Object v){
        Comparable a = (Comparable)v;
        int size = h.size();
        for(int i =0;i<size;i++){
            if(a.compareTo(h.peek()) < 0){
                enqueue(h.dequeue());
            }
        }
    }
    public BinaryHeap(Object[] arr) {
        elementData =arr;
        size = arr.length;
        heapsort();
    }
    private void heapsort(){
        for(int i = size-1;i>=0;i--){
            fixdown(i);
        }
    }
    
    @Override
    public Object dequeue() {
        if(size==0) return "ไม่มีข้อมูลเหลือแล้ว";
        Object e = peek();
        elementData[0] = elementData[--size];
        if(size>1){fixdown(0);}
        return e;
    }

    @Override
    public Object peek() {
        return elementData[0];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(Object e) {
        // check capacity
        if(size==elementData.length){
            Object[] arr = new Object[Math.max(2*size, 2*elementData.length)];
            System.arraycopy(elementData, 0, arr, 0, elementData.length);
            elementData=arr;
        }
        // end check capacity
        
        elementData[size]=e;
        fixup(size++);
        
    }
    private void fixup(int position){
        Comparable e = (Comparable) elementData[position];
        int parent = ((position)-1)/2;
        if(parent<0)return;
        if(e.compareTo(elementData[parent]) > 0){
            Object temp = elementData[position];
            elementData[position] = elementData[parent];
            elementData[parent] = temp;
            fixup(parent);
        }
    }
    private int olderChild(int c1,int c2){
        Comparable a = (Comparable)elementData[c1];
        if(a.compareTo(elementData[c2])>0) return c1;
        if(a.compareTo(elementData[c2])<=0) return c2;
        throw new NullPointerException();
    }
    public void removeGreaterThan(Object v){
        Comparable a = (Comparable) v;
        Object c = peek();
        if(a.compareTo(c)<0 && size>0){
            dequeue();
            removeGreaterThan(v);
        }
    }
    
    private void fixdown(int position){
        Comparable e = (Comparable) elementData[position];
        int child = (position*2)+1;
        if(child >= size) return;
        if(child+1 < size){
        child = olderChild(child, child+1);
        }
        if(e.compareTo(elementData[child])<0){
            Object temp = elementData[position];
            elementData[position] = elementData[child];
            elementData[child]=temp;
            fixdown(child);
        }
        
    }
    
}
