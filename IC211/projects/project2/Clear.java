/**
*/
public class Clear implements Encryptor {
  /**
  */
  public String getAlgName()
  {
    return "clear";
  }

  /**
  */
  public void   init(char[] key) throws Throwable
  {
    for(int i = 0; i < key.length; i++)
    {
      if(key[i] > 122 || key[i] < 42)
        throw new Throwable("error " + key[i] + " not allowed in key");
    }
  }

  /**
  */
  public String encrypt(String plain) throws Throwable
  {
    char[] pt = plain.toCharArray();
    for(int i = 0; i < pt.length; i++)
    {
      if(pt[i] > 122 || pt[i] < 42)
        throw new Throwable("error " + pt[i] + " not allowed in plaintext");
    }
    return plain;
  }

  /**
  */
  public String decrypt(String cipher)
  {
    return cipher;
  }
}
