/**
*/
public class ProbabilityDay extends Day
{  

  /**
  */
  private double probability;
  private Random rand;

  /**
  */
  public ProbabilityDay(MyDate d, String i, String t, int a, double p, Random r)
  {
    super(d, i, t, a);
    probability = p;
    rand = r;
  }

  /**
  */
  public String toString()
  {
    return super.toString();
  }

  /**
  */
  public void doEvent()
  {
<<<<<<< HEAD
    if(super.ifEventHappen() == 1) {
       int i = randnextInt((1/probability));
       if(i == 1) {
         super.doEvent();
       }
    }
=======
    int t = super.getTotal();
    int a = super.getAmount();
    //if()
    //{

    //}
>>>>>>> c02fd9fdc943c15a2101bceba89682f99d932c48
  }

}
