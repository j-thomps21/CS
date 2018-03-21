import java.util.*;
import java.io.*;
import java.lang.*;
/**
An extra class that helps the Lab08 class parse the input from the txt file.
This helps split the workload.
@author Thompson, Joshua - 206360
*/
public class ParseFile
{
  /**
  Method that takes the fileScanner and ArrayList and alters them. Reads in from the
  Scanner, parsing it and correctly inputting it into the ArrayList.
  @param Scanner Scanner to the fileScanner
  @param ArrayList<Event> an ArrayList of type Event which utilizes polymorphism
  @param Random A random object that is passed to the probabilityDay objects
  */
  public static void FileIO(Scanner sc, ArrayList<Event> all, Random rand)
  {
    Event a = null;
    MyDate eventStart = null;
    //int i, d, m, y;
    int amount = 0, monthAmt = 0;
    double prob = 0;
    String[] ind;
    String line, item;

    while(sc.hasNextLine())
    {
      line = sc.nextLine();
      ind = line.split(" ");


      eventStart = parseDate(ind[indexOf("start", ind) + 1]);
      item = searchItem(ind);

      if(line.contains("days"))
      {
        amount = Integer.parseInt(ind[1]);
        if(line.contains("prob"))
        {
          prob = Double.parseDouble(ind[indexOf("prob", ind)+1]);
          a = new ProbabilityDay(eventStart, item, amount, prob, rand);
        }
        else
        {
          a = new Day(eventStart, item, amount);
        }
      }
      else if(line.contains("months"))
      {
        amount = Integer.parseInt(ind[1]);
        if(line.contains("for"))
        {
          monthAmt = Integer.parseInt(ind[indexOf("for", ind)+1]);
          a = new EndMonth(eventStart, item, amount, monthAmt);
        }
        else
        {
          a = new Month(eventStart, item, amount);
        }
      }

      all.add(a);
    }
  }


  /**
  Takes an input string of "mm/dd/yyyy" and turns it into a MyDate object
  @param String The string that will be parsed to a MyDate
  @return MyDate returns the Mydate that the String represents
  */
  public static MyDate parseDate(String date)
  {
    String[] a = new String[3];
    int[] x = new int[3];
    a = date.split("/");
    for(int i = 0; i < a.length; i++)
      x[i] = Integer.parseInt(a[i]);
    return MyDate.makeDate(x[2], x[0], x[1]);
  }


  /**
  Takes an array and a string and tells where in the array that string is
  @param string the String we are searching for
  @param String[] the String array that we are searching through
  @return the index of where the string is
  */
  public static int indexOf(String a, String[] s)
  {
    int index = 0;
    for(int i = 0; i < s.length; i++)
    {
      if(s[i].equals(a))
      {
        index = i;
        break;
      }
    }
    return index;
  }


  /**
  Method that searches for the item name. Basically just looks for the keywords "expense" or "income"
  and saves all the strings that come after those keywords
  @param String[] String array that we are searching through
  @return A string that can be saved as the item name for the Event
  */
  public static String searchItem(String[] s)
  {
    boolean check = false;
    String a = "";
    for(int i = 0; i < s.length; i++)
    {
      if(s[i].equals("expense") || s[i].equals("income"))
      {
        check = true;
        a += s[i+1];
        i++;
        continue;
      }
      if(check == true)
        a += (" " + s[i]);
    }
    return a;
  }
}
