import java.util.*;
import java.io.*;
/*
Red class that creates a red dot type
*/
public class Red extends MovingDot
{
  /*
  char r that stands for red
  */
  private static final char C = 'r';

  /*
  Constructor
  */
  public Red(int r, int c)
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
  simulates a round
  */
  public void round(int round)
  {
    this.dirChange(this.rand);
    step();
  }

}
