import java.util.*;
import java.io.*;

/*
Class Dot which describes a dot. Basis for most of the lab classes
*/
public class Dot
{
  /*
  Data fieds are a Random field for random movement and position fields
  */
  public static Random rand = new Random(System.currentTimeMillis());
  private int row, col;

  /*
  Constructor that takes in a row and col and assigns them to the row and col data fields
  */
  public Dot(int r, int c)
  {
    row = r;
    col = c;
  }

  /*
  toString method for the class
  */
  public String toString()
  {
    return row + " " + col;
  }

  /*
  Adds one to the row
  */
  public void incRow()
  { row++; }

  /*
  Subtracts one from the row
  */
  public void subRow()
  { row--; }

  /*
  Adds one to the column
  */
  public void subCol()
  { col--; }

  /*
  Subtracts one from the column
  */
  public void incCol()
  { col++; }
}
