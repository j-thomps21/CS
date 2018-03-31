public class shiftTest
{
  public static void main(String[] args)
  {
    System.out.println("Type some shit: ");
    String s = System.console().readLine();
    char[] sc = s.toCharArray();
    char[] temp = new char[sc.length];
    for(int i = 0; i < sc.length; i++)
    {
      int index = i;
      char c = sc[i];
      index = index - 5;
      if(index < 0)
        index+= sc.length;
      temp[index] = c;
    }

    String t = new String(temp);
    System.out.println("result: " + t);
  }
}
