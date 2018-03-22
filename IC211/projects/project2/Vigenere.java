/**
class Vigenere that implements the functions from Encryptor
@author Thompson, Joshua - 206360
*/
public class Vigenere implements Encryptor
{
  /**
  data field mainKey is a char array that is used for encryption.
  */
  private char[] mainKey;

  /**
  Method that tels what implementation of the encyptor class it is.
  @return "vigenere"
  */
  public String getAlgName()
  {
    return "vigenere";
  }

  /**
  Method that initializes the vigenere type. Checks each character first to make sure it is
  in the ASCII range. Then it simply sets the mainKey equal to the inputted key.
  @param key Char array that is used as the mainKey in the encryption
  */
  public void init(char[] key) throws Throwable
  {
    for(int i = 0; i < key.length; i++)
      if(key[i] > 122 || key[i] < 42)
        throw new Throwable("error " + key[i] + " not allowed in key");

    mainKey = key;
  }

  /**
  Encrypt method for caesar. Using the mainKey array, the method uses each character as its own shift
  amount for the encryption. Basically a more complicated version of the caesar shift. Using the shift
  the method encrypts the input string.
  @param plain input String given by the user
  @return the cipher version of the inputted plaintext
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
  Decrypt method that does the same thing as the encryption method, but in reverse.
  @param cipher The String that was previously encrypted
  @return the plaintext
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
