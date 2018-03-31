public class miniHashtest
{
  public static void main(String[] args)
  {
    EncHash e = new EncHash('v');
    System.out.print("password : ");
    String pwd = System.console().readLine();
    char[] password = pwd.toCharArray();

    e.init(password);
    char[] hash = new char[16];
    try{
      hash = e.computeHash();
    } catch(Throwable v) {}

    String h = new String(hash);
    System.out.println("final output: " + h);

  }
}
