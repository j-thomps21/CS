public class hw5
{
  public static void main(String[] args)
  {
    String[] x ={" bottles of beer on the wall, ", " bottles of beer.",
     "Take one down and pass it around, ", " bottles of beer on the wall."};
    Countdown A = new Countdown(100, 0);

    String s = A.next();
    while(A.done() != true)
    {
      if(s == "one")
      {
        System.out.println("One bottle of beer on the wall, one bottle of beer. ");
        System.out.println("Take one down and pass it around, no more" + x[3]);
        break;
      }
      String s1 = ChangeCap(s);
      System.out.println(s1 + x[0] + s + x[1]);
      s = A.next();
      System.out.println(x[2] + s + x[3]);
      System.out.println();
    }

  }

  public static String ChangeCap(String s)
  {
    String temp1, temp2;
    temp1 = s.toUpperCase();
    temp2 = temp1.charAt(0) + RestofWord(s);
    return temp2;
  }

  public static String RestofWord(String s)
  {
    String temp = "";
    for(int i = 1; i < s.length(); i++)
    {
      temp = temp + s.charAt(i);
    }
    return temp;
  }
}
