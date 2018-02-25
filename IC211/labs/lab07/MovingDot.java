import java.util.*;
import java.io.*;

public class MovingDot extends Dot
{
  protected int direction;

  public MovingDot(int r, int c)
  {
    super(r, c);
    direction = rand.nextInt(4);
  }

  public void step()
  {
    if(direction == 1) //1 = up/north
      this.incRow();
    if(direction == 2) //2 = right/east
      this.incCol();
    if(direction == 3) //3 = down/south
      this.subRow();
    if(direction == 4) //4 = left/west
      this.subCol();
  }

  public void dirChange()
  {
    int i = rand.nextInt(3);
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
  public String toString()
  {
    return super.toString();
  }

  public boolean check(int n)
  {
    return true;
  }

}
