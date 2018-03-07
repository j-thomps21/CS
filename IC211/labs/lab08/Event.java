/**
High level Event class that is abstract. This is used to represent the commonalities between the
different day and month type events that occur.
*/
public abstract class Event
{
  /**
  MyDate field for when the event begins.
  String item field for the name of the event
  type for whether the amount of money is an expense or income.
  */
  private MyDate date;
  private String item;
  private String type;

  /**
  Constructor for Event
  */
  public Event(MyDate d, String i, String t)
  {
    date = d;
    item = i;
    type = t;
  }

  /**
  toString method returns the date and item name
  */
  public String toString()
  {
    return date + ": " + item;
  }

  /**
  returns item String
  */
  public String getItem()
  {
    return item;
  }

  /**
  returns the date
  */
  public MyDate getDate()
  {
    return date;
  }

  /**
  abstract method that will be used later down in the lower classes.
  Will check to see if the event will happen
  */
  public abstract boolean ifEventHappen();

  /**
  If the above method returns true, then do this method to carry out the event
  */
  public abstract void doEvent();
}
