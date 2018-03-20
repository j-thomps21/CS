public abstract class Commands
{
  public static void cmd(String s, ModQueue Q)
  {
    if(s.equals("quit"))
      break;

    else if(s.equals("clearto"))
      Q.dequeue(sc.next());

    else if(s.equals("add"))
      Q.enqueue(sc.next());

    else if(s.equals("dump")
      System.out.println(Q.dump());
  }

  public static void verbose(String s, ModQueue Q)
  {
    try {
      cmd(s, Q);
    } catch () {

    }
  }

  public static void notVerbose(String s, ModQueue Q)
  {
    try {
      cmd(s, Q);
    } catch() {

    }
  }
}
