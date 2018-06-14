/*
 * โครงสร้างข้อมูล : ฉบับวาจาวา
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

/**
 * อินเตอร์เฟสที่บรรยายบริการของแถวคอยเชิงบุริมภาพ
 * @author สมชาย ประสิทธิ์จูตระกูล
 */
public interface PriorityQueue extends Queue{
  public Object dequeue();  // ลบข้อมูลตัวสำคัญที่สุด
  public Object peek();     // ขอดูข้อมูลตัวสำคัญที่สุด
}