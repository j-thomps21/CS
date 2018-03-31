import java.util.*;
/**
TestEncryptors class that is used to test the various encryption types that we created.
@author Thompson, Joshua - 206360
*/
public class TestHashers {
  /**
  Main method. Takes in the desired algorithm type that the user wants to use. Then takes in a password
  and then the text they want to encrypt. Throws exceptions when the user inputs characters that are
  outside of the required ASCII range.
  */
  public static void main(String[] args) throws Throwable {
    // Create ArrayList of all supported encryptors
    ArrayList<Hasher> E = new ArrayList<Hasher>();
    E.add(new ClearHash());
    E.add(new EncHash('c'));
    E.add(new EncHash('v'));

    // Get alg,psw,msg from user
    System.out.print("algorithm: ");
    String hashalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();
    // Find index of encryptor (throw exception if not found)
    int i = -1;
    try
    {
      while(!E.get(++i).getHashName().equals(hashalg));
    } catch(Exception e) {
      System.out.println("<Exception thrown out of main! Exact output not shown.>");
      System.exit(1);
    }

    // Encrypt, decrypt print sumamry of results
    try {
    E.get(i).init(password);
    } catch (Throwable e) {
      System.out.println("<Exception thrown out of main! Exact output not shown.>");
      System.exit(1);
    }
    String pwd = new String(password);
    System.out.println("password read : " + pwd);


        char[] hashText = new char[16];
    try{
      hashText = E.get(i).computeHash();
    } catch(Throwable e) {
      System.out.println("<Exception thrown out of main! Exact output not shown.>");
      System.exit(1);
      //will put error message here eventually
    }
    String h = new String(hashText);
    System.out.println("hash computed : " + h);
  }
}
