import java.util.*;
import java.io.*;

public class Dot
{
  public static Random rand = new Random(System.currentTimeMillis());
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
}
