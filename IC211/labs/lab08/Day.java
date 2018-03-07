/**
*/
public class Day extends Events
{
  /**
  amount variable is for "every command" ex: "every 2 days" amount = 2
  
  */
  private int amount;
  private int total = 0;

  /**
  */
  public Day(MyDate d, String i, String t, int a)
  {
    super(d, i, t);
    amount = a;
  }

  /**
  */
  public String toString()
  {
    return super.toString();
  }

  /**
  */
  public int getAmount()
  {
    return amount;
  }

  /**
  */
  public int getTotal()
  {
    return total;
  }

  /**
  */
  public boolean ifEventHappen()
  {
    total++;
    return total % amount == 0
  }

  /**
  */
  public void doEvent()
  {
    System.out.println(toString());
    super.getDate().incDay(amount);
  }

}
