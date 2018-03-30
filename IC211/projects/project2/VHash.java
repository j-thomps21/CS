public class VHash implements Hasher
{
  char[] pwd;
  public String getHashName()
  {
    return "shift+vigenere";
  }

  public void init(char[] p)
  {
    pwd = p;
  }

  public char[] computeHash()
  {
    
  }
}
