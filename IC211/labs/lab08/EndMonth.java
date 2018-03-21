/**
Class that extends month in order to show payments that have a set amount of repitions
@author Thompson, Joshua - 206360
*/
public class EndMonth extends Month
{
  /**
  Saves how many more months need to be paid for
  */
  private int monthsToDo;

  /**
  Constructor for the EndMonth class. Only extra variable is for the monthsToDo
  @param MyDate Beginning date
  @param String item String
  @param Int amount of Months between each event
  @param int amount of events left
  */
  public EndMonth(MyDate d, String i, int a, int b) {
    super(d,i,a);
    monthsToDo = b;
  }

  /**
  ifEventHappen method for the EndMonth class. Uses the same ifEventHappen method in the upper level class but
  checks if there are months left to make payments on (or get income)
  @param MyDate Compares the input date to the nextDate to see if the event takes place. If monthsToDo is 0 then
  even never takes place
  @return boolean variable
  */
  public boolean ifEventHappen(MyDate d) {
    boolean check = false;
    if(super.ifEventHappen(d))
    {
      if(monthsToDo != 0)
        check = true;
    }
    return check;
  }

  /**
  toString method for this class.
  @return toString
  */
  public String toString() {
    return super.toString();
  }

}
