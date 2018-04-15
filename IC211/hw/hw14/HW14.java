import java.util.*;
/**
Public class for the 14th homework. works on using Throwables for exceptions. IE error handling
@author Joshua Thompson - 206360
*/
public class HW14 {
  /**
  In main we compute an arithmetic sequence based on some numbers inputted from the user.
  The main also does some error handling for invalid inputs from the user.
  @param args arguments that come after the command is called.
   In this case only "-v"
  @return none
  */

  public static void main(String[] args) {
    boolean verbose = args.length > 0 && args[0].equals("-v");
    Scanner sc      = new Scanner(System.in);

    if (verbose) {
      System.out.print("Enter x, k, m: ");
    }
    int x = 0, k = 0, m = 0, r = 0;
    try{
      x = sc.nextInt();
      k = sc.nextInt();
      m = sc.nextInt();
      r = MyMath.modexp(x, k, m);
    } catch(InputMismatchException e){
      if(verbose)
        System.out.println("Error in HW14! invalid input");
      System.exit(1);
    } catch(ArithmeticException e){
      if(verbose)
        System.out.println("Error in HW14! invalid input");
      System.exit(1);
    }
        if (verbose) {
      System.out.print(x + "^" + k + " % " + m + " = ");
    }
    System.out.println(r);
  }
}
