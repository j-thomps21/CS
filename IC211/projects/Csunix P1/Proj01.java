import java.io.*;
import java.util.*;

/**
*Proj01 class that handles all the interface from all the other classes. this
*is where the actual program does what it is intended to do
*/
public class Proj01
{
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("usage: java Proj01 <sectionsfile>");
      System.exit(0);
    }
    Scanner sc = null;
    try
    {
      sc = new Scanner(new FileReader(args[0]));
    }
    catch(IOException e)
    {
      e.printStackTrace();
      System.exit(1);
    }

    //Creates all the sections based on the input file
    SectNode SectionList = new SectNode();
    SectionList.read(sc);
    SectNode myList = new SectNode();
    Week mySchedule = new Week();

    //Creates new Scanner class for user input
    Scanner in = new Scanner(System.in);
    String command;
    do {
      System.out.print("> ");
      command = in.next();

      if(command.equals("sections"))
      {
        String n = in.next();
        SectionList.printClass(n);
      }
      else if(command.equals("add"))
      {
        String cn, s;
        cn = in.next();
        s  = in.next();
        myList.hasCourseSection(cn, s, SectionList, mySchedule);
      }
      else if(command.equals("show"))
      {
        myList.printEverything();
      }
      else if(command.equals("week"))
      {
        mySchedule.print();
      }
    } while(!command.equals("quit"));
  }
}
