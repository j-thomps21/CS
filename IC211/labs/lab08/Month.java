/**
*/
public class Month extends Event
{
  /**
  */
  private int amount;
  private int total = 0;

  /**
  */
  public Month(MyDate d, String i, String t, int a)
  {
    super(d, i, t);
    amount = a;
  }

  /**
  toString method for this class
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
  public int getTotal() {
    return total;
  }

  /**
    */
  public int totalInc() {
    total++;
  }

  public boolean ifEventHappen() {


  }

  public void doEvent() {
   System.out.println(toString());
   getDate.incMonth(amount);
   }

}
