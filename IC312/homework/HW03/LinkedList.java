public class LinkedList<T extends Comparable<T>> implements List<T>
{
  private Node head;
  private int size;

  public LinkedList()
  {
    head = null;
    size = 0;
  }

  private void setHead(Node n) {
    head = n;
  }

////////////////////////////////////////////////////////////////////////////////

  public T get(int index) throws IndexOutOfBoundsException
  {
    if(index > size - 1 || index < 0 || size == 0) throw new IndexOutOfBoundsException();
    Node n = head;
    return get(n, index);
  }
  private T get(Node n, int index) throws IndexOutOfBoundsException
  {
    if(index == 0)
      return n.getData();
    return get(n.getNext(), --index);
  }

////////////////////////////////////////////////////////////////////////////////

  public T set(int index, T element) throws IndexOutOfBoundsException
  {
    if(index > size - 1 || index < 0 || size == 0) throw new IndexOutOfBoundsException();
    Node n = head;
    return set(n, index, element);
  }
  private T set(Node n, int index, T element)
  {
    if(index == 0)
    {
      T temp = n.getData();
      n.setData(element);
      return temp;
    }
    return set(n.getNext(), --index, element);
  }

////////////////////////////////////////////////////////////////////////////////

  public void add(int index, T element) throws IndexOutOfBoundsException
  {
    Node n = head;
    if(size == 0 && index == 0)
    {
      Node t = new Node();
      t.setData(element);
      this.setHead(t);
      size++;
    }
    else if(index > size || index < 0) throw new IndexOutOfBoundsException();
    else
    {
      setHead(add(n, index, element));
      size++;
    }
  }
  private Node add(Node n, int index, T element)
  {
    if(index == 0)
    {
      Node t = new Node();
      t.setData(element);
      t.setNext(n);
      return t;
    }
    n.setNext(add(n.getNext(), --index, element));
    return n;
  }

////////////////////////////////////////////////////////////////////////////////

  public T remove(int index) throws IndexOutOfBoundsException
  {
    if(index > size - 1 || index < 0 || size == 0) throw new IndexOutOfBoundsException();
    size--;
    return remove(head, null, index);
  }
  private T remove(Node n, Node prev, int index)
  {
    if(index == 0)
    {
      T temp = n.getData();
      if(prev == null)
        head = head.getNext();
      else
        prev.setNext(n.getNext());
      return temp;
    }
    return remove(n.getNext(), n, --index);
  }

////////////////////////////////////////////////////////////////////////////////

  public int size()
  {
    return size;
  }

////////////////////////////////////////////////////////////////////////////////

  public void removeElement(T element) throws IllegalStateException
  {
    if(size == 0) throw new IllegalStateException();
    Node n = head;
    removeElement(n, null, element);
  }
  private void removeElement(Node n, Node prev, T element)
  {
    if(n == null)
      return;
    if(element.compareTo(n.getData()) == 0)
    {
      if(prev == null)
        head = head.getNext();
      else
        prev.setNext(n.getNext());
      size--;
    }
    removeElement(n.getNext(), n, element);
  }

////////////////////////////////////////////////////////////////////////////////

  public T max() throws IllegalStateException
  {
    if(size == 0) throw new IllegalStateException();
    Node n = head;
    return max(n, n.getData());
  }
  private T max(Node n, T e)
  {
    if(n == null)
      return e;
    if(n.getData().compareTo(e) == 1)
      e = n.getData();
    return max(n.getNext(), e);
  }

////////////////////////////////////////////////////////////////////////////////

  public String toStringReverse()
  {
    String retStr = "[";
    return retStr + toStringReverse(head) + " ]";
  }
  private String toStringReverse(Node n)
  {
    if(n == null)
      return "";
    return toStringReverse(n.getNext()) + " " + n.getData().toString();
  }

////////////////////////////////////////////////////////////////////////////////

  public String toString()
  {
    String retStr = "[ ";
    return retStr + toString(head) + "]";
  }

  private String toString(Node n)
  {
    if (n == null)
      return "";
    return n.getData().toString()+" "+toString(n.getNext());
  }

////////////////////////////////////////////////////////////////////////////////

  private class Node
  {
    private T data;
    private Node next;
    public Node(){
      data = null;
      next = null;
    }
    public T getData() {
      return data;
    }
    public Node getNext() {
      return next;
    }
    public void setNext(Node n) {
      next = n;
    }
    public void setData(T e) {
      data = e;
    }
  }
}
