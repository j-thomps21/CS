import java.util.*;

public class hw14
{
  public static void main(String[] args)
  {
    boolean verbose = args.length > 0 && args[0].equals("-v");
    Scanner sc      = new Scanner (System.in);

    if(verbose)
    {
      System.out.print("Enter x, k, m: ");
    }
    int x = 0, k = 0, m = 0, r = 0;
    try{
    x = sc.nextInt();
    k = sc.nextInt();
    m = sc.nextInt();
    r = MyMath.modexp(x,k,m);
  } catch(Throwable e) {
      if(verbose)
        System.out.println("Error in HW14! invalid input.");
    }

    if(verbose)
    {
      System.out.print(x + "^" + k + "%" + m + " = ");
    }
    System.out.println(r);
  }
}
