/**
*/
public class Vigenere implements Encryptor
{
  /**
  */
  private char[] mainKey;

  /**
  */
  public String getAlgName()
  {
    return "vigenere";
  }

  /**
  */
  public void init(char[] key) throws Throwable
  {
    for(int i = 0; i < key.length; i++)
      if(key[i] > 122 || key[i] < 42)
        throw new Throwable("error " + key[i] + " not allowed in key");

    mainKey = key;
  }

  /**
  */
  public String encrypt(String plain) throws Throwable
  {
    //check the key if there are any chars outside the range
    int k, p, c, cc;
    char[] pt = plain.toCharArray();
    int n = mainKey.length;
    for(int i = 0; i < pt.length; i++)
    {
      if(pt[i] > 122 || pt[i] < 42)
        throw new Throwable("error " + pt[i] + " not allowed in plaintext");

      k = mainKey[i%n] - 42;
      p = pt[i] - 42;
      c = (p + k) % 81;
      cc = 42 + c;
      pt[i] = (char)(cc);
    }
    String cipher = new String(pt);
    return cipher;
  }

  /**
  */
  public String decrypt(String cipher)
  {
    int k, p, c, cc, pc;
    char[] ct = cipher.toCharArray();
    int n = mainKey.length;
    for(int i = 0; i < ct.length; i++)
    {
      k = mainKey[i%n] - 42;
      c = ct[i] - 42;
      p = (c + (81 - k)) % 81;
      pc = 42 + p;
      ct[i] = (char)(pc);
    }
    String plaintext = new String(ct);
    return plaintext;
  }
}
