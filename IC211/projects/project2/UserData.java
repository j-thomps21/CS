import java.util.*;

/**
Class UserData that holds the data that is used to describe the attributes of
a user. Contains the username, hash type used for the user, the hashtext itself, and
an ArrayList for all the data that the user has.
@author Thompson, Joshua - 206360
*/
public class UserData
{
  //username
  private String userName;
  //Hash type
  private Hasher H;
  //The raw hashtext
  private char[] hashText;
  //ArrayList that contains DataEntry objects
  private ArrayList<DataEntry> data = new ArrayList<DataEntry>();

  /**
  constructor for the UserData class
  @param h for the Hash type
  @param ht for the Hash text
  @param un for the username
  */
  public UserData(Hasher h, String ht, String un)
  {
    H = h;
    hashText = ht.toCharArray();
    userName = un;
  }

  /**
  Returns the hashing object
  @return Hash object
  */
  public Hasher getHashType()
  {
    return H;
  }

  /**
  Returns the string of the username
  @return the username
  */
  public String getUserName()
  {
    return userName;
  }

  /**
  Returns the hashtext
  @return Hashtext in string form
  */
  public String getHashText()
  {
    return new String(hashText);
  }

  /**
  authenticate method used to check to see if the password the user inputted in
  the prompt is the same as the one used in the input file. Note that it does this
  by hashing the inputted password and comparing the hashtext to the one that
  is found in the input file.
  @param uname The username
  @param password The password inputted by the user
  @throws Throwable If something goes wrong in the computing method or the init method
  @return A boolean true or false if the password is correct or not
  */
  public boolean authenticate(String uname, char[] password) throws Throwable
  {
    boolean check = false;
    char[] tHash = new char[16];
    try {
      H.init(password);
    } catch (Throwable e) {
      return check;
    }
    tHash = H.computeHash();

    String x = new String(tHash);
    String y = new String(hashText);

    if(x.equals(y))
      check = true;
    if(!uname.equals(userName))
      check = false;
    return check;
  }

  /**
  Method that adds a new data entry to the ArrayList
  @param enc Encryption type
  @param ctext The cipher text
  */
  public void addDataEntry(String enc, String ctext)
  {
    data.add(new DataEntry(enc, ctext));
  }

  /**
  Method that decrypts the data so that it can be called upon later
  @param pwd Password that is needed to decrypt the data
  @throws Throwable If something goes wrong in the init method
  */
  public void decryptData(char[] pwd) throws Throwable
  {
    for(int i = 0; i < data.size(); i++)
        data.get(i).init(pwd);
  }

  /**
  Prints all the labels found in the data ArrayList for this user
  */
  public void printLabels()
  {
    for(int i = 0; i < this.data.size(); i++)
      System.out.println(data.get(i).getLabel());
  }

  /**
  Prints the datatext for the given label
  @param s The inputted label. Used for the "get" command
  */
  public void printDataText(String s)
  {
    for(int i = 0; i < this.data.size(); i++)
    {
      if(s.equals(data.get(i).getLabel()))
      {
        System.out.println(data.get(i).getDataText());
        break;
      }
    }
  }


  public void addDataEntry(String enc, String label, String text, char[] pwd) throws Throwable
  {
    data.add(new DataEntry(enc, label, text, pwd));

  }
  public String outputFileString()
  {
    return "data " + userName + " " + data.get(data.size() - 1).outputFileString();
  }
}
