public class Red extends MovingDot
{
  private static final char C = 'r';

  public Red(int r, int c)
  {
    super(r,c);
  }


  public String toString()
  {
    return super.toString() + C;
  }


  public void dirChange()
  {
    int i = rand.nextInt(3)
      if(i == 1)
      {
        direction--;
        if(direction < 1)
          direction = 4;
      }
      else if(i == 2)
      {
        direction++;
        if(direction > 4)
          direction = 1;
      }
  }
}
