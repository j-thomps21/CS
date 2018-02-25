public class Queue {
  public void enqueue(String s) {
    if (all[head] == null) {
      head = tail = 0;
      all[head] = s;
    } else {
      tail++;
      all[tail] = s;
    }
  }

  public String dequeue() {
    String s = all[head];
    if (all[head] == null) {
      tail = head;
    }
    all[head] = null;
    head++;
    return s;
  }

  public boolean empty() {
    return  all[head] == null;
  }

  public Iter iterator() {
    return new Iter(head);
  }

  protected class Iter {
    private int curr;
    public Iter(int start) {
      curr = start;
    }

    public boolean hasNext() {
      return all[curr] != null;
    }

    public String next() {
      String s = all[curr];

      curr++;
      return s;
    }
  }

  private String[] all = new String[1024];
  private int head, tail;
}
