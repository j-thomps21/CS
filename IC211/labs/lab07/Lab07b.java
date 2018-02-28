/*
Class Lab07b which uses the interface from the Dot classes and puts them to work
*/
public class Lab07b
{
  /*
  main method where everything happens
  */
  public static void main(String[] args)
  {
    //if the user doesn't input a desired number, then every 200 rounds,
    // a new dot will be created
    int n = 200;
    if(args.length != 0)
      n = Integer.parseInt(args[0]);

    //counter for how many rounds have passed
    int rounds = 0;

    //creates a new Queue of Moving Dots
    MovingDotQueue MoDo = new MovingDotQueue();

    while(true)
    {
      if(rounds % n == 0)
      {
        //every 200 rounds enqueue two new dots
        MoDo.enqueue(new Red(45, 50));
        MoDo.enqueue(new Blue(55, 50));
      }

      //Iterates through the list and steps the dots and prints them out
      MovingDotQueue.Iter iter = MoDo.iterator();
      while(iter.hasNext())
      {
        MovingDot temp = iter.next();
        System.out.println(temp.toString());
        temp.round(rounds);
      }
      //add to the rounds
      rounds++;
      System.out.println("done");
      System.out.flush();
    }
  }
}
