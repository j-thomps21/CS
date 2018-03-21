/**
class Month that extends Event. similar to Day class execpt events happen on a monthly basis
@author Thompson, Joshua - 206360
*/
public class Month extends Event
{
  /**
  The amount variable is for "every" command. Ex: "every 2 days" amount = 2
  total variable shows how many monaths have passed
  */
  private int amount;
  private MyDate nextDate;

  /**
  Constructor for the Month class
  @param MyDate Date when the event starts
  @param String item name for the event
  @param Int the amount of months to skip between each event
  */
  public Month(MyDate d, String i, int a)
  {
    super(d, i);
    amount = a;
    nextDate = d;
  }

  /**
  toString method for this class
  @return the super class' toString method
  */
  public String toString()
  {
    return super.toString();
  }

  /**
  @return the amount of the object.
  */
  public int getAmount()
  {
    return amount;
  }

  /**
  Determines if the event should happen
  @param MyDate Takes a date and checks whether the event should happen on that Date
  @return A boolean of true or false
  */
  public boolean ifEventHappen(MyDate d) {
    return d.daysUntil(this.nextDate) == 0;
  }

  /**
  ifEventHappen is true, then do the event (ie print out the string and set the next event date)
  */
  public void doEvent() {
    System.out.print(toString());
    nextDate.incMonth(amount);
   }
}
