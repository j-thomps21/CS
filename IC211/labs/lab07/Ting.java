/*
Class ting that creates a ting dot
*/
public class Ting extends MovingDot
{
  /*
  char t that gets printed out (how you know its a ting dot)
  */
  private static final char C = 't';

  /*
  constructor
  */
  public Ting(int r, int c)
  {
    super(r,c);
  }

  /*
  toString method
  */
  public String toString()
  {
    return super.toString() + " " + C;
  }

  /*
  ifDirChange method that allows direction change completely Randomly
  */
  public boolean ifDirChange(int round)
  {
    boolean check = false;
    int t = 0;
    while(t == 0)
      t = this.rand.nextInt(10);
    if(round % t == 0)
      check = true;
    return check;
  }

  /*
  simulates a round
  */
  public void round(int round)
  {
    if(ifDirChange(round))
    {
      dirChange(this.rand);
    }
    step();
  }

  /*
  Special step method that only step in diagonal direction
  */
  public void step()
  {
    if(direction == 1)
    {
      this.incRow();
      this.incCol();
    }
    if(direction == 2)
    {
      this.incRow();
      this.subCol();
    }
    if(direction == 3)
    {
      this.subRow();
      this.incCol();
    }
    if(direction == 4)
    {
      this.subRow();
      this.subCol();
    }
  }
}
