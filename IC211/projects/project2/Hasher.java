/**
Hasher class that is the interface for all hashing classes. Contins useful
methods which must be implemented to create different hashing types.
@author Thompson, Joshua - 206360
*/
public interface Hasher {
  public String getHashName();
  public void init(char[] p) throws Throwable;
  public char[] computeHash() throws Throwable;
}
