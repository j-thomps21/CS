public class MovingDotQueue
{
  private Node head, tail;

  private class Node
  {
    public MovingDot data;
    public Node next;
    public Node(MovingDot d, Node n)
    {
      data = d;
      next = n;
    }
  }

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

  public Iter iterator()
  {
    return new Iter(head);
  }


  protected class Iter
  {
    private Node curr;
    public Iter(Node start)
    {
      curr = start;
    }

    public boolean hasNext()
    {
      return curr != null;
    }

    public MovingDot next()
    {
      MovingDot d = curr.data;
      curr = curr.next;
      return d;
    }
  }


}
