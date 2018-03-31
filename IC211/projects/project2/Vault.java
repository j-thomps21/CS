import java.io.*;
import java.util.*;
public class Vault
{
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("usage: java Vault <filename>");
      System.exit(1);
    }
    Scanner sc = null;
    try {
      sc = new Scanner(new FileReader(args[0]));
    } catch(IOException e) {
      System.out.println("Error! File '" + args[0] + "' could not be opened.");
      System.exit(1);
    }

    ArrayList<Hasher> E = new ArrayList<Hasher>();
    E.add(new ClearHash());
    E.add(new EncHash('c'));
    E.add(new EncHash('v'));

    ArrayList<Hasher> Final = new ArrayList<Hasher>();
    while(sc.hasNext())
    {
      int i = -1;
      String line = sc.nextLine();
      String[] cmds = line.split(" ");
      try {
        while(!E.get(i++).getHashName().equals(cmds[2]));
      } catch (Exception e) {
        System.out.println("<Exception thrown out of main! Exact output not shown.>");
        System.exit(1);
      }

      Final.add(E.get(i));
      System.out.println("Here!");
    }


  }
}
