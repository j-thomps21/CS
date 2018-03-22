/**
Encryptor class that is the interface for all the encryption classes. Contains
useful methods that are implemented to create different encryption types.
@author Thompson, Joshua - 206360
*/
public interface Encryptor {
  public String getAlgName();
  public void   init(char[] key) throws Throwable;
  public String encrypt(String plain) throws Throwable;
  public String decrypt(String cipher);
}
