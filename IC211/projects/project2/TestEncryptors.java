
import java.util.*;
/**
TestEncryptors class that is used to test the various encryption types that we created.
@author Thompson, Joshua - 206360
*/
public class TestEncryptors {
  /**
  Main method. Takes in the desired algorithm type that the user wants to use. Then takes in a password
  and then the text they want to encrypt. Throws exceptions when the user inputs characters that are
  outside of the required ASCII range.
  @param args In this case all args are ingnored
  @throws Throwable Throws execptions when inputted characters are outside of the required ASCII range.
  */
  public static void main(String[] args) throws Throwable {
    // Create ArrayList of all supported encryptors
    ArrayList<Encryptor> E = new ArrayList<Encryptor>();
    E.add(new Clear());
    E.add(new Caesar());
    E.add(new Vigenere());

    // Get alg,psw,msg from user
    System.out.print("algorithm: ");
    String encalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();
    System.out.print("message  : ");
    String plaintext = System.console().readLine();

    // Find index of encryptor (throw exception if not found)
    int i = -1;
    try
    {
      while(!E.get(++i).getAlgName().equals(encalg));
    } catch(Exception e) { throw new Exception("Unknown algorithm '" + encalg +"'."); }

    // Encrypt, decrypt print sumamry of results
    try {
    E.get(i).init(password);
    } catch (Throwable e) {
      System.out.println("<Exception thrown out of main! Exact output not shown.>");
      System.exit(1);
    }
    String ciphertext = null;
    try{
      ciphertext = E.get(i).encrypt(plaintext);
    } catch(Throwable e) {
      System.out.println("<Exception thrown out of main! Exact output not shown.>");
      System.exit(1);
      //will put error message here eventually
    }
    String hopefully = E.get(i).decrypt(ciphertext);
    System.out.println("plain : " + plaintext);
    System.out.println("cipher: " + ciphertext);
    System.out.println("decryp: " + hopefully);
  }
}
