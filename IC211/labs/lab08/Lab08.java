import java.util.*;
import java.io.*;
import java.lang.*;

/**
Lab08 class where the main is held. Here we print out a sort of list of events that happen
when they are scheduled to happen
@author Thompson, Joshua - 206360
@author Wiltshire, Jared - 206948
*/
public class Lab08
{
  /**
  the main method
  */
  public static void main(String[] args)
  {
    if(args.length < 2)
    {
      System.out.println("usage: java Lab08 <infilename> <numDays>");
      System.exit(1);
    }

    Random rand;
    if(args.length == 3)
      rand = new Random (Long.parseLong(args[2]));
    else
      rand = new Random(System.currentTimeMillis());

    Scanner sc = null;
    try {
      sc = new Scanner(new FileReader(args[0]));
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    ArrayList<Event> all = new ArrayList<Event>();
    ParseFile.FileIO(sc, all, rand);

    MyDate currDay = MyDate.makeDate(2017,1,1);
    int simDays = Integer.parseInt(args[1]);

    for(int i = 0; i < simDays; i++)
    {
      boolean check = false, prev = false;
      for(int j = 0; j < all.size(); j++)
      {
        if(check == false && all.get(j).ifEventHappen(currDay))
        {
          check = true;
          System.out.print(currDay.toString() + ":");
        }
        if(check == true)
        {
          if(all.get(j).ifEventHappen(currDay))
          {
            if(prev)
            {
              System.out.print(", ");
              all.get(j).doEvent();
            }
            else
            {
              System.out.print(" ");
              all.get(j).doEvent();
            }
            prev = true;
          }
        }
      }
      if(check == true)
        System.out.println();
      currDay.incDay(1);
    }
  }
}
