import java.util.*;

/**
*Section class that handles each individual section.
*/
public class Section
{
  /**
  *Data members that makeup a section.
  */
  protected String classNum, section, days, room;


  /**
  *Section Constructor that initializes everything to the the corresponding strings
  *and makes the next Section object null;
  */
  public Section(String cn, String s, String d, String r)
  {
    classNum  = cn;
    section   = s;
    days      = d;
    room      = r;
  }


  /**
  *Returns a string of the data members in the section
  */
  public String toString()
  {
    return classNum + " " + section + " " + days + " " + room;
  }


  /**
  *Checks if the input classnum is the same as the one stored in the section
  */
  public void printSearchSection(String s)
  {
    if(classNum.equals(s))
      System.out.println(toString());
  }


  /**
  *Checks if the input ClassNum and Section number are the same
  *as the one stored withing the section
  */
  public boolean searchClassSection(String cn, String s)
  {
    boolean check;
    if(classNum.equals(cn) && section.equals(s))
      check = true;
    else
      check = false;
    return check;
  }

  /**
  *Returns the String of the days stored within the section
  */
  public String returnDays()
  {
    return days;
  }
}
