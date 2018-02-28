import java.util.*;
import java.io.*;

public class Red extends MovingDot
{
  private static final char C = 'r';

  public Red(int r, int c)
  {
    super(r,c);
  }

  public String toString()
  {
    return super.toString() + " " + C;
  }

  public void round(int round)
  {
    this.dirChange(this.rand);
    step();
  }

}
