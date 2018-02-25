import java.io.*;
import java.util.*;

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
    Section[] all = Section.read(sc);
    Scanner in = new Scanner(System.in);

    System.out.print("> ");
    String command  = in.next();

    while(!command.equals("quit"))
    {
      if(command.equals("sections"))
      {
        String n = in.next();
        printClass(n, all);
      }

      System.out.print("> ");
      command = in.next();
    }
  }


  public static void printClass(String s, Section[] all)
  {
    for(int i = 0; i < 11; i++)
    {
      all[i].printClassSection(s);
    }
  }
}
