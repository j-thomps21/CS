import java.lang.*;
/**
Class EncHash that implements Hasher to create another Hashing type. In this case
it actually creates two different hashing types based on what the user inputs into
the constructor. Used to create either shift+vigenere or shift+caesar
@author Thompson, Joshua - 206360
*/
public class EncHash implements Hasher
{
  //The vector that is used for all hashing in this project
  private char[] vector;
  //The inputted password
  private char[] pwd;
  //Character that denotes the type of hashing wanted either c or v
  private char type;

  /**
  Constructor for EncHash. Only 'v' or 'c' can be inputted which denote either
  shift+caesar or shift+vigenere
  @param c Character that denotes which hashing is desired
  */
  public EncHash(char c)
  {
    type = c;
    String t = "GO_NAVY_2018^mid";
    vector = t.toCharArray();
  }

  /**
  Resets all the datafields
  */
  public void reset()
  {
    String t = "GO_NAVY_2018^mid";
    vector = t.toCharArray();
    char[] p = new char[16];
    pwd = p;
  }

  /**
  Returns the hash name. Depends on the type datafield
  @return The name of the hash
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
  Method that initializes the EncHash object. Takes in a password and checks if
  all the characters are within the correct ASCII range.
  @param p Inputted password
  @throws Throwable If the password is out of ASCII range
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
  Method used to compute the actual hash. Creates a for loop for the length of
  the initialization vector and performs a computation. Encrypts the string and
  shifts for every character of the vector.
  @throws Throwable If something goes wrong in the Encryption methods.
  @return The newly hashed vector
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

  /**
  Method used to shift the string by k amount
  @param k Integer that denotes how much the string must be shifted by
  */
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
