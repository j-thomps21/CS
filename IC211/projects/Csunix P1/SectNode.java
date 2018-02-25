import java.util.*;

/**
*SectNode class that is used to create a linked list of Sections
*/
public class SectNode
{
  /**
  *Data for the SectNode is a Section, the next is another SectNode.
  *The all and end members are Pointer to the beginning and end of the particular linked list.
  *This allows the user to have more than one linked list when they declare more than one SectNode
  */
  private Section data;
  private SectNode next;
  private SectNode all, end;


  /**
  *Constructor for SectNode
  */
  public SectNode(String cn, String s, String d, String r, SectNode n)
  {
    this.data = new Section(cn, s, d, r);
    this.next = n;
  }


  /**
  *Another Constructor that simply initializes the data and next members to null;
  */
  public SectNode()
  {
    this.data = null;
    this.next = null;
  }


  /**
  *Read method that takes in a scanner type(for files) and creates a linked list of Sections
  */
  public void read(Scanner sc)
  {
    boolean check = true;
    while(sc.hasNext())
    {
      String cn = sc.next();
      String  s = sc.next();
      String  d = sc.next();
      String  r = sc.next();
      if(check == true)
      {
        SectNode temp = new SectNode();
        this.end = new SectNode();
        this.all = new SectNode(cn, s, d, r, temp);
        this.end = all.next;
        check = false;
      }
      else
      {
        this.end.data = new Section(cn, s, d, r);
        this.end.next = new SectNode();
        this.end = end.next;
      }
    }
  }


  /**
  *Prints the Sections within the linked list that match the desired class.
  *Ex: input "IC221" returns all the sections with class IC221
  */
  public void printClass(String s)
  {
    for(SectNode temp = this.all; temp.next != null; temp = temp.next)
    {
      temp.data.printSearchSection(s);
    }
  }


  /**
  *Prints all the sections held within the linked list
  */
  public void printEverything()
  {
    for(SectNode temp = all; temp.data != null; temp = temp.next)
      System.out.println(temp.data.toString());
  }


  /**
  *Checks if the input classNum and section are found within the SectionList linked list.
  *If they match a section, then add that section to this linked list. Also adds the class
  *to mySchedule so that can be printed out later.
  *IF not found, then print out error message.
  */
  public void hasCourseSection(String cn, String s, SectNode SectionList, Week mySchedule)
  {
    boolean check = false;
    for(SectNode temp = SectionList.all; temp.next != null; temp = temp.next)
    {
      if(temp.data.searchClassSection(cn, s) == true)
      {
        check = true;
        if(this.data == null)
        {
          this.data = temp.data;
          this.next = new SectNode();
          end = this.next;
          all = this;
        }
        else
        {
          end.data = temp.data;
          end.next = new SectNode();
          end = end.next;
        }
        mySchedule.add(temp.data.returnDays());
        mySchedule.makeSched();
      }
    }
    if(check == false)
      System.out.println("Error! Section not found!");
  }
}
