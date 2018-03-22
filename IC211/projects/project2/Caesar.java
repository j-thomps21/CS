/**
*/
public class Caesar implements Encryptor
{
  /**
  */
  private int shift;

  /**
  */
  public String getAlgName()
  {
    return "caesar";
  }

  /**
  */
  public void init(char[] key) throws Throwable
  {
    shift = 0;
    int total = 18;
    for(int i = 0; i < key.length; i++)
    {
      if(key[i] < 42 || key[i] > 122)
        throw new Throwable("error " + key[i] + " not allowed in key");

      total += ((int)(key[i]) - 42);
    }

    total = total % 81;
    shift = total + 42;
  }

  /**
  */
  public String encrypt(String plain) throws Throwable
  {
    int k, p, c, cc;
    k = shift - 42;
    char[] pt = plain.toCharArray();
    for(int i = 0; i < pt.length; i++)
    {
      if(pt[i] < 42 || pt[i] > 122)
       throw new Throwable("error " + pt[i] + " not allowed in plaintext");

      p = pt[i] -42;
      c = (p+k) % 81;
      cc = 42 + c;
      pt[i] = (char)(cc);
    }
    String cypher = new String(pt);
    return cypher;
  }

  /**
  */
  public String decrypt(String cipher)
  {
    int k, p, c, cc;
    k = shift - 42;
    char[] ct = cipher.toCharArray();
    for(int i = 0; i < ct.length; i++)
    {
      c = ct[i] - 42;
      p = (c + (81 - k)) % 81;
      ct[i] = (char)(42 + p);
    }
    String plaintext = new String(ct);
    return plaintext;
  }
}
