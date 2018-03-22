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
  public void init(char[] key)
  {
    shift = 0;
    int total = 18;
    for(int i = 0; i < key.length; i++)
    {
      if(key[i] < 42 || key[i] > 122)
      {
        throw new CharacterException("Character is outside of 42-122 ASCII range");
      }

      total += ((int)(key[i]) - 42);
    }

    total = total % 81;
    shift = total + 42;
  }

  /**
  */
  public String encrypt(String plain)
  {
    int k, p, c, cc;
    k = shift - 42;
    char[] pt = plain.toCharArray();
    for(int i = 0; i < pt.length; i++)
    {
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
