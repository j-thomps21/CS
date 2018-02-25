public class MovingDot extends Dot
{
  private int round;
  protected int direction;


  public MovingDot(int r, int c)
  {
    super(r, c);
    direction = rand.nextInt(4);
    round = 0;
  }

  public void step()
  {
    if(direction == 1) //1 = up/north
      row++;
    if(direction == 2) //2 = right/east
      col++;
    if(direction == 3) //3 = down/south
      row--;
    if(direction == 4) //4 = left/west
      col--;
  }

  public void round()

  public String toString()
  {
    return super.toString();
  }


}
