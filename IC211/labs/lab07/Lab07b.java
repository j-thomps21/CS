public class Lab07b
{
  int n = 200;

  if(args.length != 0)
  {
    n = Integer.parseInt(args[0]);
  }

  DotQueue D = new DotQueue();
  int round = 0;

  while(true)
  {
    if(round % 200 == 0)
    {
      D.enqueue(Dot.newR());
      D.enqueue(Dot.newB());
    }
    D.Iter point = D.iterator();
    while(point.hasNext())
    {

    }
    
    round++;
    System.out.println("done");
  }
}
