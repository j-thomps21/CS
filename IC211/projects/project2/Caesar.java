/**
*/
public class Caesar implements Encryptor
{
  /**
  */
  private int shift;

  /**
  */
  public Caesar()
  {
    shift = 0;
  }

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
    for(int i = 0; i < key.length; i++)
    {

    }
  }

  /**
  */
  public String encrypt(String plain)
  {
    return plain;
  }

  /**
  */
  public String decrypt(String cipher)
  {
    return cypher;
  }
}
