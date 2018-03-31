public class ClearHash implements Hasher
{
  private char[] pwd;
  public String getHashName()
  {
    return "clear";
  }

  public void init(char[] p) throws Throwable
  {
    for(int i = 0; i < p.length; i++)
    {
      if(p[i] > 122 || p[i] < 42)
        throw new Throwable("error " + p[i] + " not allowed in password");
    }
    pwd = p;
  }


  public char[] computeHash()
  {
    char[] hash = new char[16];
    int i;
    for(i = 0; (i < 16) && (i < pwd.length); i++)
      hash[i] = pwd[i];

    if(i < 16)
    {
      for(; i < 16 ; i++)
        hash[i] = 'x';
    }
    return hash;
  }
}
