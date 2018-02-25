import java.util.*;

public class mid
{
  public String alpha;
  public String firstname;
  public String lastname;
  public int company;

  public static mid createMid()
  {
    Scanner in = new Scanner(System.in);
    System.out.print("Alpha? ");
    mid n = new mid();
    n.alpha = in.next();
    System.out.print("First name? ");
    n.firstname = in.next();
    System.out.print("Last name? ");
    n.lastname = in.next();
    System.out.print("Company? ");
    n.company = in.nextInt();
    return n;
  }

  public static void printMid(mid x)
  {
    System.out.println(x.alpha + " " + x.lastname + " "
    + x.firstname + " " + x.company);
  }
}
