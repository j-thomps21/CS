/**
Class ClearHash that implements Hasher. Doesn't really do much but
add x characters after the hash until the length of the hash is 16
@author Thompson, Joshua - 206360
*/
public class ClearHash implements Hasher
{
  //password
  private char[] pwd;

  /**
  Returns the hash name
  @return The hash name
  */
  public String getHashName()
  {
    return "clear";
  }

  /**
  initializes the hash object with the password
  @param p The inputted password
  @throws Throwable If the password is outside of the ASCII  range
  */
  public void init(char[] p) throws Throwable
  {
    for(int i = 0; i < p.length; i++)
    {
      if(p[i] > 122 || p[i] < 42)
        throw new Throwable("error " + p[i] + " not allowed in password");
    }
    pwd = p;
  }


  /**
  This method computed the hash by simply taking the password and adding
  x characters to the end until its length is 16
  @return The computed hash
  */
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
