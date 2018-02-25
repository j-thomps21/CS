public class DotQueue
{
  private Node head, tail;


  private class Node
  {
    public Dot data;
    public Node next;
    public Node(Dot d, Node n)
    {
      data = d;
      next = n;
    }
  }

  public enqueue(Dot d)
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


  private class Iter
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

    public Dot next()
    {
      Dot d = curr.data;
      curr = curr.next();
      return d;
    }
  }


}
