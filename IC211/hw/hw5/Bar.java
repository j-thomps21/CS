public class Bar
{
  private int x;
  public int y;
  public static int z = 0;
  public Bar(int a, int b)
  {
    x = a;
    y =b;
    z++;
  }
  public int sum()
  {
    return x + y;
  }
  private int div()
  {
    return x/y;
  }
  public static int check()
  {
    return z;
  }
}
