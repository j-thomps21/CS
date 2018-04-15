/**
Class MyMath which is called in the HW14 class. Used for its arithmetic equation
*/
public class MyMath {
  /**
   * Returns x^k mod m
   * Note: k must be non-negative, and m must be positive
   * @param x integer for the equation
   * @param k integer for the equation
   * @param m integer for the equation
   * @return r integer which is the result of the equation
   */
  public static int modexp(int x, int k, int m) throws ArithmeticException{
    int r = 1;
    if(k < 0)
      throw new ArithmeticException();
    for (int i = 0; i < k; i++) {
      r = r * x % m;
    }
    return r;
  }
}
