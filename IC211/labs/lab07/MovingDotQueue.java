/*
class that creates a queue of MovingDots
*/
public class MovingDotQueue
{
  /*
  Data fields head and tail that are pointers to the head and tail nodes of the linke list
  */
  private Node head, tail;

  /*
  nested class node
  */
  private class Node
  {
    /*
    Data fields for node are a node and a MovingDot
    */
    public MovingDot data;
    public Node next;

    /*
    Constructor for the Node
    */
    public Node(MovingDot d, Node n)
    {
      data = d;
      next = n;
    }
  }

  /*
  enqueues a MovingDot into the list
  */
  public void enqueue(MovingDot d)
  {
    if(head == null)
    {
      head = tail = new Node(d, null);
    }
    else
    {
      tail.next = new Node(d, null);
      tail = tail.next;
    }
  }

  /*
  Method that creates an iterator that points to the front of the list
  */
  public Iter iterator()
  {
    return new Iter(head);
  }


  /*
  nested class iterator
  */
  protected class Iter
  {
    /*
    Data field is a node
    */
    private Node curr;

    /*
    Constructor for the iterator
    */
    public Iter(Node start)
    {
      curr = start;
    }

    /*
    Method that determines if there is a next node in the list
    */
    public boolean hasNext()
    {
      return curr != null;
    }

    /*
    Method next that returns a MovingDot and moves down the list
    */
    public MovingDot next()
    {
      MovingDot d = curr.data;
      curr = curr.next;
      return d;
    }
  }


}
