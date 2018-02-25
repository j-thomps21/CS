import java.util.*;
public class Section
{
  /**
  *These are the characteristics of eachs
  */
  private String classNum, section, days, room;

  /**
    *Takes in a scanner class and read the file. Returns
    *An array of Sections
    */
  public static Section[] read(Scanner in)
  {
    Section[] all = new Section[11];
    for(int i = 0; i < 11; i++)
    {
      String cn, s, d, r;
      cn   = in.next();
      s    = in.next();
      d    = in.next();
      r    = in.next();
      Section temp = new Section(cn, s, d, r);
      all[i] = temp;
    }
    return all;
  }

  /**
    *Constructor that makes the sections
    */
  public Section(String cn, String s, String d, String r)
  {
    classNum = cn;
    section = s;
    days = d;
    room = r;
  }




  /**
    *Just a function that prints out the array of read in sections
    */
  public void printSection()
  {
    System.out.println(classNum + " " + section + " " + days + " " + room);
  }

  /**
    *Function that prints if the classNum matches s
    */
  public void printClassSection(String s)
  {
    if(this.classNum.equals(s))
      printSection();
  }

  /**
    *
    */
}
