public class Green extends MovingDot
{
  private static final char C = 'g';

  public Green(int r, int c)
  {
    super(r, c);
  }

  public String toString()
  {
    return super.toString() +" " + C;
  }

  public boolean ifDirChange(int round)
  {
    boolean check = false;
    if(round% 15 == 0)
      check = true;
    return check;
  }

  public void round(int round)
  {
    if(ifDirChange(round))
      dirChange(this.rand);
    step();
  }

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
