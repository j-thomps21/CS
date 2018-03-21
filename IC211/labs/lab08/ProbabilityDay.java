import java.lang.*;
import java.util.*;

/**
ProbabilityDay class that adds funcitonality of Day events that may or may not happen based on a given probability
@author Wiltshire, Jared -206498
*/
public class ProbabilityDay extends Day
{

  /**
  fields are a probability and a random field
  */
  private double probability;
  private Random rand;

  /**
  Constructor for the class
  @param MyDate Beginning date
  @param String item String
  @param Int amount of Days between each event
  @param double probability of an event happening when it should
  @param Random Random object
  */
  public ProbabilityDay(MyDate d, String i, int a, double p, Random r)
  {
    super(d, i, a);
    probability = p;
    rand = r;
  }

  /**
  toString method for the class
  @return toString
  */
  public String toString()
  {
    return super.toString();
  }

  /**
  Uses same ifEventHappen method in the above class but also takes into account the probability that was given
  @param MyDate Compares the input date to the nextDate
  @return boolean variable
  */
  public boolean ifEventHappen(MyDate d)
  {
    boolean check = super.ifEventHappen(d);
    if(check == true)
    {
      if(rand.nextDouble() == 0.0)
        check = true;
      else
        check = false;
    }
    return check;
  }
}
