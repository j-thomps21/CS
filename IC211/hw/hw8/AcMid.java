public class AcMid extends Mid
{
  private String major;

  public AcMid(String ln, String al, String m)
  {
    super(ln, al);
    major = m;
  }

  public String toString()
  {
    String s = super.getLast() + " " + super.getAlpha() + " " + major;
    return s;
  }
}
