import java.io.*;
import java.util.*;

public class Queue
{
  private class Node
  {
    public String data;
    public Node next;
    public Node(String d, Node n)
    {
      data = d;
      next = n;
    }
  }

  private Node head, tail, n;
  private boolean first;

  /**
  *Constructor
  */
  public Queue()
  {
    head = new Node(null,null);
    tail = head;
    n    = new Node(null,null);
    first = true;
  }

  /**
  *Adds s to the back of the queue
  */
  public void enqueue(String s)
  {
    if(first == true)
    {
      head.data = s;
      head.next = new Node(null, null);
      tail = head.next;
      first = false;
    }
    else
    {
      tail.data = s;
      tail.next = new Node(null, null);
      tail = tail.next;
    }
  }

  /**
  *removes and returns string from the front of the queue
  */
  public String dequeue()
  {
    String s = head.data;
    head = head.next;
    return s;
  }

  /**
  *returns true of the queue is empty
  */
  public boolean empty()
  {
    boolean check;
    if(head.data == null && tail.data == null)
      check = true;
    else
      check = false;
    return check;
  }

}
