 
/*
 * โครงสร้างข้อมูล : ฉบับวาจาวา
 * http://www.cp.eng.chula.ac.th/~somchai/books


/**
 * คลาสที่สร้างที่เก็บข้อมูลในต้นไม้ค้นหาแบบทวิภาค
 * @author สมชาย ประสิทธิ์จูตระกูล
 */
public class BSTree extends BinaryTree {
  int size;

  public BSTree() {}
  public int size() { return size; }
  public boolean isEmpty() { return size == 0; }

  int compare(Object a, Object b) {
    return ((Comparable)a).compareTo(b);
  }
  public Object get(Object e) {
    Node node = getNode(root, e);
    return node == null ? null : node.element;
  }
  Node getNode(Node r, Object e) {
    while (r != null) {
      int cmp = compare(e, r.element);
      if (cmp == 0) return r;
      if (cmp < 0)
        r = r.left;
      else
        r = r.right;
    }
    return null;
  }
  public Object getMin() {
    Node r = root;
    if (r == null) return null;
    while (r.left != null) {
      r = r.left;
    }
    return r.element;
  }
  public Object getMax() {
    Node r = root;
    if (r == null) return null;
    while (r.right != null) {
      r = r.right;
    }
    return r.element;
  }
  public void add(Object e) {
    root = add(root, e);
  }
  Node add(Node r, Object e) {
    if (r == null) {
      r = new Node(e, null, null);
      ++size;
    } else {
      int cmp = compare(e, r.element);
      if (cmp < 0)
        r.left = add(r.left, e);
      else if (cmp > 0)
        r.right = add(r.right, e);
    }
    return r;
  }
  public void remove(Object e) {
    root = remove(root, e);
  }
  Node remove(Node r, Object e) {
    if (r == null) return r;
    int cmp = compare(e, r.element);
    if (cmp < 0) {
      r.left = remove(r.left, e);
    } else if (cmp > 0) {
      r.right = remove(r.right, e);
    } else {
      if (r.left == null || r.right == null) {
        r = (r.left == null ? r.right : r.left);
        --size;
      } else {
        Node m = r.right;
        while (m.left != null) m = m.left;
        r.element = m.element;
        r.right = remove(r.right, m.element);
      }
    }
    return r;
  }
  //-------------------------------------------------
  Node rotateLeftChild(Node r) {
    Node newRoot = r.left;
    r.left = newRoot.right;
    newRoot.right = r;
    return newRoot;
  }
  Node rotateRightChild(Node r) {
    Node newRoot = r.right;
    r.right = newRoot.left;
    newRoot.left = r;
    return newRoot;
  }     
  Object select(int k){
      Object[] a = new Object[size];
      for(int i=0;i<k;i++){
          Object temp = getMin();
          a[i] =  temp;
          remove(temp);
      }
      return a[k-1];
  }
  //-------------------------------------------------
  public static void treeSort(final Object[] data) { 
    BSTree t = new BSTree();
    for (int i=0; i<data.length; i++) {
      t.add(data[i]);
    }
    t.inOrder(new Visitor() {
                int k = 0;
                public void visit(Object e) {
                  data[k++] = e;
                } } );
  }
}    

  