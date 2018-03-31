public interface Hasher {

  public String getHashName();
  public void init(char[] p);
  public char[] computeHash() throws Throwable;
}
