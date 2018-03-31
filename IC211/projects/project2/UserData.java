public class UserData
{
  private Hasher H;
  private char[] hashText;

  public UserData(Hasher h, char[] ht, char[] password)
  {
    H = h;
    hashText = ht;
    H.init(password);
  }


}
