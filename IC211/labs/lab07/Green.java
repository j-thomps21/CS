/*
Green Class that creates green dots
*/
public class Green extends MovingDot
{
  /*
  Char field that prints out the g
  */
  private static final char C = 'g';

  /*
  Constructor
  */
  public Green(int r, int c)
  {
    super(r, c);
  }

  /*
  toString method
  */
  public String toString()
  {
    return super.toString() +" " + C;
  }

  /*
  ifDirChange method that allows the chance to change direction every 15 rounds
  */
  public boolean ifDirChange(int round)
  {
    boolean check = false;
    if(round% 15 == 0)
      check = true;
    return check;
  }

  /*
  simulates a round
  */
  public void round(int round)
  {
    if(ifDirChange(round))
      dirChange(this.rand);
    step();
  }

  /*
  special step function that goes diagonally
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
