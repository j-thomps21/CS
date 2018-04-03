public class UserData
{
  private String userName;
  private Hasher H;
  private char[] hashText;
  

  public UserData(Hasher h, String ht, String un) throws Throwable
  {
    H = h;
    hashText = ht.toCharArray();
    userName = un;
  }

  public Hasher getHashType()
  {
    return H;
  }

  public String getUserName()
  {
    return userName;
  }

  public String getHashText()
  {
    return new String(hashText);
  }

  public boolean authenticate(String uname, char[] password) throws Throwable
  {
    System.out.println("Here!");
    char[] tHash = new char[16];
    H.init(password);
    tHash = H.computeHash();
    boolean check = false;

    String x = new String(tHash);
    String y = new String(hashText);

    if(x.equals(y))
      check = true;
    if(!uname.equals(userName))
      check = false;
    System.out.print("Check is: "+ check);
    return check;
  }
}
