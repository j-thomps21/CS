/**
class Clear that implements the functions from encryptor
@author Thompson, Joshua - 206360
*/
public class Clear implements Encryptor {
  /**
  Method that tells what implementation of Encryptor this is.
  @return string clear
  */
  public String getAlgName()
  {
    return "clear";
  }

  /**
  Method that initializes the Clear type encryption. For Clear it doesnt do anything
  but check to ensure that the password inputted contains characters that are in the
  correct range.
  @param key Char array that doesnt really do anything
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
  Encrpt method for Clear. doesnt do anything but return the input plaintext.
  There is a check to ensure that the characters are all in the correct ASCII range
  @param plain String of plaintext inputted by the user. All characters must be within 42-122 ASCII range
  @return The encrypted text which in this case is the same as the plaintext
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
  Decrypt method that simply returns the inputted string.
  @param cipher String that was encrypted
  @return the same string that was inputted
  */
  public String decrypt(String cipher)
  {
    return cipher;
  }
}
