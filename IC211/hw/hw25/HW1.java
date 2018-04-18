import java.util.*;
/**
 * Class HW1 that only has a main.
 * @author Thompson, Joshua 206360
 */
public class HW1
{
  /**
   * main method that creates a Tree object of type integer. Adds 10 integers to that tree and prints them out
   * @param args Command line arguments are ignored
   */
  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());

    TreeSet<Integer> tr = new TreeSet<Integer>();

    for(int i = 0; i < 10; i++)
      tr.add(rand.nextInt(1000));

    Iterator<Integer> i = tr.iterator();

    while(i.hasNext())
      System.out.println(i.next());
  }
}
