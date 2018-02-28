/*
Lab07c class that is for part 2 of the lab. Implements the ting and Green dot types
*/
public class Lab07c
{
  /*
  Main method where everything happens
  */
  public static void main(String[] args)
  {
    //if the user doesn't input a desired number, then every 200 rounds
    // a new dot will be created
    int n = 200;
    if(args.length != 0)
      n = Integer.parseInt(args[0]);

    //counter for how many rounds have passed
    int rounds = 0;

    // creates a new Queue of MovingDots
    MovingDotQueue MoDo = new MovingDotQueue();

    while(true)
    {
      if(rounds % n == 0)
      {
        //only thing new here is that every 200 rounds I create the same
        //red and blue dots, but also create the Ting and Green dots.
        //OOP makes it very easy to Implement these dot types
        MoDo.enqueue(new Red(45, 50));
        MoDo.enqueue(new Blue(55, 50));
        MoDo.enqueue(new Ting(50, 50));
        MoDo.enqueue(new Green(50, 50));
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
