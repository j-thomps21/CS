public interface Hasher {

  public String getHashName();
  public void init(char[] p) throws Throwable;
  public char[] computeHash() throws Throwable;
}
