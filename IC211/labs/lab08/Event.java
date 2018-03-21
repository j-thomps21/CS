/**
High level Event class that is abstract. This is used to represent the commonalities between the
different day and month type events that occur.
@author Wiltshire, Jared - 206948
*/
public abstract class Event
{
  /**
  startDate represents the date where the event begins
  String item field for the name of the event
  */
  private MyDate startDate;
  private String item;

  /**
  Constructor for Event
  @param MyDate the Date when the Event starts
  @param String the item name for the Event
  */
  public Event(MyDate d, String i)
  {
    startDate = d;
    item = i;
  }

  /**
  toString method returns the date and item name
  @return the item String for the Event
  */
  public String toString()
  {
    return item;
  }

  /**
  @return the date
  */
  public MyDate getDate()
  {
    return startDate;
  }

  /**
  abstract method that will be used later down in the lower classes.
  Will check to see if the event will happen
  @param MyDate Takes a date and checks if the Event will occur on that day
  @return a boolean whether the event takes place or not
  */
  public abstract boolean ifEventHappen(MyDate d);

  /**
  If the above method returns true, then do this method to carry out the event
  */
  public abstract void doEvent();
}
