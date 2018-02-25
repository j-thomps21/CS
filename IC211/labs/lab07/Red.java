import java.util.*;
import java.io.*;

public class Red extends MovingDot
{
  private static final char C = 'r';

  public Red(int r, int c)
  {
    super(r,c);
  }

  public boolean check(int n)
  {
    return ifDirChange(n);
  }


  public String toString()
  {
    return super.toString() + C;
  }

  public boolean ifDirChange(int round)
  {
    return true;
  }

}
