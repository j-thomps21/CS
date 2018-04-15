import java.util.*;
import java.io.*;
/**
Class HW20 that creates Readers and inputs them into a Scanner to read from
either standard input or  from a file. These are meant to read integers
which are used for a computation. Errors are give with messages and Line
numbers where the error was found.
@author Thompson, Joshua - 206360
*/
public class HW20 {
  /**
  Main method of HW20 class. Creates a scanner which is based off
  of a reader from standard in or a FileReader. Then converts them
  into a LineNumberReader which is then used in the creation of a
  scanner object. Then used to get integers for a computation.
  LineNumberReader is used to print the line number in the error.
  @param args Input desired file as input, otherwise default to stdin
  */
  public static void main(String[] args) {
    Reader  r  = new InputStreamReader(System.in);
    boolean fileCheck = false;
    FileReader f = null;
    try{
      if(args.length > 0)
      {
        fileCheck = true;
        try{
          f = new FileReader(args[0]);
        } catch (IOException e) {
          e.printStackTrace();
          System.exit(1);
        }
      }
    } catch(Throwable e) {
      System.out.println("some shit happened");
    }

    Scanner sc = null;
    LineNumberReader lnr = null;
    if(fileCheck)
      lnr = new LineNumberReader(f);
    else
      lnr = new LineNumberReader(r);

    sc = new Scanner(lnr);

    try {
      System.out.println(Mystery.compute(sc));
    } catch (Exception e)    {
      System.out.println("Error " + e.getMessage() + " at line " + lnr.getLineNumber());
    }
  }
}
