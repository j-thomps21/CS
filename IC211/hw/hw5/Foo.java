public class Foo
{
  private String s;
  private static int c = 0;
  public String show()
  {
    return "[" + s + "]";
  }
  private char first()
  {
    return s.charAt(0);
  }
  public static int mys()
  {
    return c++;
  }
  public static void prob()
  {
    Foo f = new Foo();
    Bar b = new Bar(3,7);
    show();
  }
}
