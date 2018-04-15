/**
Class DataEntry that is used to handle the entered data that the user
accesses once they have authenticated.
@author Thompson, Joshua - 206360
*/
public class DataEntry
{
  //inputted data in cipherText
  private String cipherText;
  //Encryption type
  private Encryptor e;
  //label once the cipherText is decrypted
  private String label;
  //The part after the label once the cipherText is decrypted
  private String dataText;
  //The password
  private char[] pwd;

  /**
  Constructor for DataEntry. Finds the correct encryption type for
  the object and sets the ciphertext to the ctext parameter
  @param enc name of the encyption desired
  @param ctext The cipherText
  */
  public DataEntry(String enc, String ctext)
  {
    Encryptor[] E = new Encryptor[3];
    E[0] = new Clear();
    E[1] = new Vigenere();
    E[2] = new Caesar();
    int i = 0;
    for(; i < 3; i++)
      if(enc.equals(E[i].getAlgName()))
        break;
    e = E[i];
    cipherText = ctext;
  }

  /**
  dlkfsj
  */
  public DataEntry(String enc, String l, String plaintext, char[] p) throws Throwable
  {
    pwd = p;
    String full = l + "_" + plaintext;
    Encryptor[] E = new Encryptor[3];
    E[0] = new Clear();
    E[1] = new Vigenere();
    E[2] = new Caesar();
    int i = 0;
    boolean check = false;
    for(; i < 3; i++)
    {
      if(enc.equals(E[i].getAlgName()))
      {
        check = true;
        break;
      }
    }
    if(check == false) throw new Throwable("Error! Encryption algorithm '" + enc + "' not supported.");
    e = E[i];
    label = l;
    dataText = plaintext;
    e.init(pwd);
    cipherText = e.encrypt(full);
  }

  /**
  Initialization method that sets the password to the given password
  and uses the splitPlainText method to decrypt the cipherText and
  split the label from the dataText.
  @param pwd The password
  @throws Throwable If something goes wrong in splitPlainText method
  */
  public void init(char[] pwd) throws Throwable
  {
    this.pwd = pwd;
    String[] raw = splitPlainText();
    label = raw[0];
    dataText = raw[1];
  }

  /**
  Method that decrypts the cipherText and splits the label from the dataText.
  @return String array for label and dataText.
  @throws Throwable If the cipherText is Corrupted, or if something goes wrong in the
  encryption  fucntions that are called.
  */
  private String[] splitPlainText() throws Throwable
  {
    String plaintext = null;
    try {
      e.init(pwd);
      plaintext = e.decrypt(cipherText);
    } catch (Throwable e) {
      System.out.println("Error! Corrupted entry '"+ cipherText + "' in vault file.");
      System.exit(1);
    }
    String[] raw = plaintext.split("_");
    if(raw.length < 2)
      throw new Throwable("Error! Corrupted entry '" + cipherText + "' in vault file.");
    else if(raw.length > 2)
      for(int i = 2; i < raw.length; i++)
        raw[1] += ("_" + raw[i]);
    return raw;
  }

  /**
  Returns the label
  @return The label in string form
  */
  public String getLabel()
  {
    return label;
  }

  /**
  Returns the datatext
  @return The dataText in string form
  */
  public String getDataText()
  {
    return dataText;
  }

  /**
  Returns a string that can be used in conjunction with the username as an output
  writable to a file. Used to add data entries for users.
  @return output string to a file
  */
  public String outputFileString()
  {
    return e.getAlgName() + " " + cipherText;
  }
}
