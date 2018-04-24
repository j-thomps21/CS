import java.util.*;

public class Example
{
  public static void main(String[] args) {
    Parent P = new Parent();
    Child C = new Child();
    Brother B = new Brother();
    Sister S = new Sister();
    Neice N = new Neice();

    B = S;
    P = C;
    P.getName();
    C = P;
    P = N;
    String t1 = P.getLast();
    P = B;
    String t2 = P.getDegree();
    String t3 = B.getDegree();
    ArrayList<Parent> AL = new ArrayList<Parent>();
    AL.add(new Parent());
    AL.add(new Brother());
    AL.add(new Sister());
    AL.add(new Neice());

    String t4 = AL.get(1).getDegree();
    Child B2 = (Child)P;
  }
}
