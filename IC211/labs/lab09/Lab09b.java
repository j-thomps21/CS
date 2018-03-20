import java.util.*;
import java.io.*;

public class Lab09b
{
  public static void main(String[] args)
  {
    Scanner sc = null;
    boolean verbose = false, hasFile = false;

    for(int i = 0; i < args.length; i++)
    {
      if(args[i].equals("-v") && i == 0)
        verbose = true;
      else if(!args[i].equals(null))
      {
        try {
          sc = new Scanner(new FileReader(args[i]));
          hasFile = true;
        } catch(IOException e) {
          System.out.println("File '" + args[i] + "' could not be opened; switching input to standard in.");
          hasFile = false;
        }
      }
    }




    Scanner in = new Scanner(System.in);
    //Commands C =  new Commands();
    ModQueue Q = new ModQueue();
/*
    do {
      if(verbose)
        hasFile ? C.verbose(sc.next(), Q) : C.verbose(in.next(), Q);
      else
        hasFile ? C.notVerbose(sc.next(), Q) : C.notVerbose(in.next(), Q);
    } while (true);*/
  }
}
