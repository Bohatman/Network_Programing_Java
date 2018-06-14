 
/*
 * โครงสร้างข้อมูล : ฉบับวาจาวา
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

/**
 * อินเตอร์เฟสที่บรรยายบริการของแถวคอย
 * @author สมชาย ประสิทธิ์จูตระกูล
 */
public interface Queue {
  public boolean isEmpty();
  public int size();
  public void enqueue(Object e);
  public Object peek();
  public Object dequeue();
}

