public class Dot
{
  private int row, col;

  public Dot(int r, int c)
  {
    row = r;
    col = c;
  }

  public String toString()
  {
    return row + " " + col;
  }

  public void incRow()
  { row++; }

  public void subRow()
  { row--; }

  public void subCol()
  { col--; }

  public void incCol()
  { col++; }

  public void step(){ String s = ""; }

}
