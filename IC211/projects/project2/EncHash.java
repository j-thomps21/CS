import java.lang.*;
/**
*/
public class EncHash implements Hasher
{
  private char[] vector;
  private char[] pwd;
  private char type;

  /**
  */
  public EncHash(char c)
  {
    type = c;
    String t = "GO_NAVY_2018^mid";
    vector = t.toCharArray();
  }

  /**
  */
  public String getHashName()
  {
    String s = null;
    if(type == 'c')
      s = "shift+caesar";
    else if(type == 'v')
      s = "shift+vigenere";
    return s;
  }

  /**
  */
  public void init(char[] p)
  {
    for(int i = 0; i < p.length; i++)
    {
      if(p[i] > 122 || p[i] < 42)
        throw new Throwable("error " + p[i] + " not allowed in password");
    }
    pwd = p;
  }

  /**
  */
  public char[] computeHash() throws Throwable
  {
    for(int i = 0; i < 16; i++)
    {
      char c = vector[i];
      int k = c % 16;
      this.shiftString(k);
      String v = new String(vector);
      if(type == 'c')
      {
        Encryptor e = new Caesar();
        e.init(pwd);
        v = e.encrypt(v);
      }
      else if(type == 'v')
      {
        Encryptor e = new Vigenere();
        e.init(pwd);
        v = e.encrypt(v);
      }
      vector = v.toCharArray();
    }
    return vector;
  }

  public void shiftString(int k)
  {
    char[] temp = new char[16];
    for(int i = 0; i < 16; i++)
    {
      int index = i;
      char c = vector[index];
      index = index - k;
      if(index < 0)
        index += 16;
      temp[index] = c;
    }
    vector = temp;
  }
}
