/**
Class Queue that holds a Queue of strings.
@author Thompson, Joshua - 206360
*/
public class Queue
{
  /**
  enqueue method that adds a string to the end of the queue
  @param s String that you want to add to the queue
  */
  public void enqueue(String s)
  {
    if (head == null) {
      head = tail = new Node(s, null);
    } else {
      tail.next = new Node(s, null);
      tail      = tail.next;
    }
  }

  /**
  dequeue method that removes a string from the end of the queue and returns that string
  @return String that you dequeue
  */
  public String dequeue() throws Throwable
  {
    Node t = head;
    if(head == null)
      throw new QueueException("dequeue empty queue");

    head = head.next;

    if (head == null) {
      tail = null;
    }

        return t.data;
  }

  /**
  method that returns a boolean telling if the queue is empty or not
  @return boolean true or false
  */
  public boolean empty()
  {
    return head == null;
  }

  /**
  method that creates a new iterator
  @return new iterator object
  */
  public Iter iterator() throws Throwable
  {
    return new Iter(head);
  }

  /**
  Nested iterator class to help with various methods in the Queue class
  */
  protected class Iter
  {
    /**
    Data field is a node that points to nodes in the queue
    */
    private Node curr;

    /**
    Constructor for Iter
    */
    public Iter(Node start) {
      curr = start;
    }

    /**
    hasNext method to determine if there is a next node in the queue
    @return true if there is more in queue, false if there is nothing left
    */
    public boolean hasNext()
    {
      return curr != null;
    }

    /**
    next method that returns the string to the current node and moves to the next node
    @return String of the current node
    */
    public String next() throws Throwable
    {
      if(curr == null)
        throw new QueueException("iterator past end of queue");

      String s = curr.data;

      curr = curr.next;
      return s;
    }
  }

  /**
  Nested class node that is the foundation of queue. Allows for linked list
  */
  private class Node
  {
    /**
    Node contains field String for data and another node that it points to
    */
    public String data;
    public Node   next;

    /**
    Constructor for the Node class
    */
    public Node(String d,
                Node   n) {
      data = d;
      next = n;
    }
  }

  /**
  Datafield for Queue class is head node and tail node
  */
  private Node head = null, tail = null;
}
