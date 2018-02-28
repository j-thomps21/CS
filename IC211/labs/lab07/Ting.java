public class Ting extends MovingDot
{
  private static final char C = 't';

  public Ting(int r, int c)
  {
    super(r,c);
  }

  public String toString()
  {
    return super.toString() + " " + C;
  }

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

  public void round(int round)
  {
    if(ifDirChange(round))
    {
      dirChange(this.rand);
    }
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
