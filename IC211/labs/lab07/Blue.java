import java.util.*;
import java.io.*;

/*
Class Blue that extends MovingDot
*/
public class Blue extends MovingDot
{
  /*
  Char b that gets printed out, how you know it is a blue dot
  */
  private static final char C = 'b';

  /*
  Constructor
  */
  public Blue(int r, int c)
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
  allows for the chance to change direction every 10 rounds
  */
  public boolean ifDirChange(int round)
  {
    boolean check = false;
    if(round % 10 == 0)
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
}
