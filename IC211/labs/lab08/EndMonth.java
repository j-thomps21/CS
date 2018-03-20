/**
Class that extends month in order to show payments that have a set amount of repitions
*/
public class EndMonth extends Month
{
  /**
  Saves how many more months need to be paid for
  */
  private int monthsToDo;

  /**
  Constructor for the EndMonth class. Only extra variabl is for the monthsToDo
  */
  public EndMonth(MyDate d, String i, String t, int a, int b) {
    super(d,i,t,a);
    monthsToDo = b;
  }

  /**
  Method that check when all of the monthly payments have been paid. When
  the monthsToDo variable has reached 0, then you know that all of the months
  have been paid.
  */
  public boolean doneCheck(){
    return monthsToDo == 0;
  }

  /**
  Signifies that one month has been paid off
  */
  public void incMonth()
  {
    monthsToDo--;
  }

  /**
  toString method for this class.
  */
  public String toString() {
    return super.toString();
  }

}
