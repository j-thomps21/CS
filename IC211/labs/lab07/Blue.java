import java.util.*;
import java.io.*;

public class Blue extends MovingDot
{
  private static final char C = 'b';

  public Blue(int r, int c)
  {
    super(r,c);
  }

  public String toString()
  {
    return super.toString();
  }

  public boolean ifDirChange(int round)
  {
    boolean check = false;
    if(round % 10 == 0)
      check = true;
    return check;
  }

  public boolean check(int n)
  {
    return ifDirChange(n);
  }
}
