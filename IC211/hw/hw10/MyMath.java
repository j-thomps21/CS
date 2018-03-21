import java.util.*;
public class MyMath
{
  public static int modexp(int x, int k, int m) throws Throwable
  {
    if(k < 0)
    {
      throw new Throwable();
    }
    int r = 1;
    for(int i = 0; i < k; i++)
      r = r * x % m;

      return r;
  }
}
