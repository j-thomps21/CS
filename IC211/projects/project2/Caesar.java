/**
class Caesar that implements the functions from encryptor
@author Thompson, Joshua - 206360
*/
public class Caesar implements Encryptor
{
  /**
  data field shift which tells the encyption method the shift of the encyption
  */
  private int shift;

  /**
  Method that tells what implementation of the encryptor class it is.
  @return string "caesar"
  */
  public String getAlgName()
  {
    return "caesar";
  }

  /**
  Method that initializes the Caesar type. Checks each character to make sure it is
  in the ASCII range. Then does an algorithm to calculate the shift amount
  @param key Char array that determines the shift amount
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
  Encrypt method for caesar. Using the shift amount, does a calculation by shifting each character
  in the plaintext. Then returns the shifted string.
  @param String of plaintext inputted by the user. All charcters must be within 42-122 ASCII range
  @return The encyrpted text
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
  Decrypt method that does the same thing as the encyption method, but in reverse.
  @param cipher The String that was previously encyrpted
  @return The plaintext
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
