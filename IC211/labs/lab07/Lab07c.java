public class Lab07c
{
  public static void main(String[] args)
  {
    int n = 200;
    if(args.length != 0)
      n = Integer.parseInt(args[0]);
    int rounds = 0;

    MovingDotQueue MoDo = new MovingDotQueue();

    while(true)
    {
      if(rounds % n == 0)
      {
        MoDo.enqueue(new Red(45, 50));
        MoDo.enqueue(new Blue(55, 50));
        MoDo.enqueue(new Ting(50, 50));
        MoDo.enqueue(new Green(50, 50));
      }

      MovingDotQueue.Iter iter = MoDo.iterator();
      while(iter.hasNext())
      {
        MovingDot temp = iter.next();
        System.out.println(temp.toString());
        temp.round(rounds);
      }
      rounds++;
      System.out.println("done");
      System.out.flush();
    }
  }
}
