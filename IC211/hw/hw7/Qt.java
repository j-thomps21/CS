public class Queue
{
  private static Node list;
  /**
  *Private class Node used to create linked lists
  */
  private class Node
  {
    public String data;
    public Node next;

    public Node(String d, Node n)
    {
      data = d;
      next = n;
    }

    /**
    *Adds a node to the back of the linked list
    */
    public void addToBack(String s)
    {
      if(empty())
      {
        Node temp = new Node(s, list);
        list = temp;
      }
      else
      {
        Node l = list;
        while(l.next != null)
          l = l.next;
        l.insertAfter(s);
      }
    }

    /**
    *Inserts a node after the given one
    */
    public void insertAfter(String s)
    {
      Node temp = new Node(s, list.next);
      list.next = temp;
    }
  }

  /**
  *adds s to the back of the queue
  */
  public void enqueue(String s)
  {
    list.addToBack(s);
  }

  /**
  *removes and returns string from the front of the queue
  */
  public String dequeue()
  {
    String s = list.data;
    list = list.next;
    return s;
  }


  /**
  *returns true if the queue is empty
  */
  public boolean empty()
  {
    boolean check;
    if(list.next == null)
      check = true;
    else
      check = false;
    return check;
  }


}
