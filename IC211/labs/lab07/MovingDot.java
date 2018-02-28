import java.util.*;
import java.io.*;
/*
MovingDot class that extends dot
*/
public class MovingDot extends Dot
{
  /*
  Data field that contains the direction of the dot
  */
  protected int direction;

  /*
  Constructor for the moving dot initializes the dot with a random direction
  */
  public MovingDot(int r, int c)
  {
    super(r, c);
    direction = this.rand.nextInt(4);
  }

  /*
  simulates a step in the current direction of the dot
  */
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

  /*
  Takes a rand and if the number is a 1 then make a left, 2 is a right, and 3 is nothing
  */
  public void dirChange(Random rand)
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

  /*
  toString method for the movingdot
  */
  public String toString()
  {
    return super.toString();
  }

  /*
  a placeholder method that allows for polymorphic calls
  */
  public void round(int round)
  {
    String s = " ";
  }

}
