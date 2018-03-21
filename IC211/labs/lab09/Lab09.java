import java.util.*;
import java.io.*;

public class Lab09a {
  public static void main(String[] args) {
    String fname = null;
    boolean verbose = false, file = false;
    if(args.length == 2)
    {
      verbose = true;
      fname = args[1];
      file = true;
    }
    else if(args.length == 1)
    {
      if(args[0].equals("-v"))
        verbose = true;
      else
      {
        fname = args[0];
        file = true;
      }
    }

    Scanner sc = null;
    if(file == false)
    {
      sc = new Scanner(System.in);
    }
    else
    {
      try{
        sc = new Scanner(new FileReader(fname));
      } catch(IOException e) {
        System.out.println("File '" + fname + "' could not be opened; switching input to standard in.");
        sc = new Scanner(System.in);
        file =false;
      }
    }
    ModQueue Q  = new ModQueue();


    do {
      if(!file)
        System.out.print("> ");
      String s = null;
      try{
        s = sc.next();
      } catch (NoSuchElementException e){
        break;
      }

      if (s.equals("quit"))
      {
        break;
      }
      else if (s.equals("clearto"))
      {
        String c = null;
        try {
          c = sc.next();
        } catch(NoSuchElementException e) {
          if(verbose)
            System.out.println("Unexpected end of input.");
          System.exit(1);
        }

        try {
          Q.dequeue(c);
        } catch (QueueException e) {
          if(verbose)
            System.out.println("String '" + c + "' not found!");
        }
      }
      else if (s.equals("add"))
      {
        String c = null;
        try {
          c = sc.next();
        } catch(NoSuchElementException e) {
          if(verbose)
            System.out.println("Unexpected end of input.");
          System.exit(1);
        }
        Q.enqueue(c);
      }
      else if (s.equals("dump"))
      {
        try {
          System.out.println(Q.dump());
        } catch (QueueException e) {
        }
      }
      else
      {
        if(verbose)
        System.out.println("Unknown command '" + s + "'.");
      }
    } while (true);
  }
}
