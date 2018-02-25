public class Dot
{
  private int row, col;

  public Dot(int r, int c)
  {
    row = r;
    col = c;
  }

  public void round(int round)
  {
    
  }

  public void dirChange(int round)
  {
  }

  public String toString()
  {
    return row + " " + col;
  }


  public void step(){ String s = ""; }

////////////////////////////////////////////////////////////
  public static Dot newR()
  {
    Dot temp = new Dot(45, 50, rand.nextInt(4), 'r');
    return temp;
  }

  public static Dot newB()
  {
    Dot temp = new Dot(55, 50, rand.nextInt(4), 'b');
    return temp;
  }
}
