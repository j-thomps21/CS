/**
Class Day that extends Event. Adds an amount field and nextDate field. Used to describe events that happen on a
somewhat daily basis
@author Thompson, Joshua - 206360
*/
public class Day extends Event
{
  /**
  amount is for "every command" ex: "every 2 days" amount = 2
  nextDate is the next date that the event will take place again
  */
  private int amount;
  private MyDate nextDate;

  /**
  Constructor for the day class
  @param MyDate Date when the Event will start
  @param String Item String for the event
  @param int amount of days between each event
  */
  public Day(MyDate d, String i, int a)
  {
    super(d, i);
    amount = a;
    nextDate = d;
  }

  /**
  toString method for Day class
  @return string
  */
  public String toString()
  {
    return super.toString();
  }


  /**
  Tells whether based on the give date if the event will happen or not
  @param MyDate An input date which will compare with the nextDate
  @return A boolean
  */
  public boolean ifEventHappen(MyDate d)
  {
    return d.daysUntil(this.nextDate) == 0;
  }

  /**
  does the event by printing a string and incrementing the nextDate
  */
  public void doEvent()
  {
    System.out.print(toString());
    nextDate.incDay(amount);
  }

}
