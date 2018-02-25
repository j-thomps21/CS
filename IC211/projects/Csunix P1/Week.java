import java.util.*;

/**
*Class used to create the visual schedule which is printed out with the "week" command
*/
public class Week
{
  //first number is the days of the week and the second is the periods in the day
  private boolean[][] days;
  //array of chars that can easily be altered and printed out for the visual schedule
  private char[][] sched;

  /**
  *Constructor for the Week class
  */
  public Week()
  {
    //creates the days array
    days = new boolean[5][6];
    for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        days[i][j] = false;
      }
    }

    //creates the sched array
    sched = new char[7][11];
    sched[0][0] = ' '; sched[0][1] = ' ';
    sched[0][2] = 'M'; sched[0][3] = ' ';
    sched[0][4] = 'T'; sched[0][5] = ' ';
    sched[0][6] = 'W'; sched[0][7] = ' ';
    sched[0][8] = 'R'; sched[0][9] = ' ';
    sched[0][10] = 'F';
    for(int i = 1; i < 7; i++)
    {
      for(int j = 0; j < 11; j++)
      {
        if(j == 0)
        {
          char c = (char)(i + 48);
          sched[i][j] = c;
        }
        else
          sched[i][j] = ' ';
      }
    }
  }

  /**
  *Takes in the days in command form and explodes them into a
  *format that the function can read
  */
  public void add(String command)
  {
    String[] all = DrBrown.explode(command);
    for(int i = 0; i < all.length; i++)
    {
      this.add2Day(all[i]);
    }
  }


  /**
  *Takes in each of the individual exploded strings and adds them to the days
  *array
  */
  public void add2Day(String s)
  {
    char d = s.charAt(0);
    int t = s.charAt(1) - '0';
    t -= 1;
    days[this.dayToIndex(d)][t] = true;
  }

  /**
  *Converts day char to index
  */
  public int dayToIndex(char c)
  {
    int i = 0;
    if(c == 'M') i = 0;
    if(c == 'T') i = 1;
    if(c == 'W') i = 2;
    if(c == 'R') i = 3;
    if(c == 'F') i = 4;
    return i;
  }


  /**
  *Converts index to day
  */
  public int indexToDay(int i)
  {
    char c = ' ';
    if(i == 0) c = 'M';
    if(i == 1) c = 'T';
    if(i == 2) c = 'W';
    if(i == 3) c = 'R';
    if(i == 4) c = 'F';
    return c;
  }

  /**
  *Alters the sched data member to match the days boolean array
  */
  public void makeSched()
  {
    for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        if(days[i][j] == true)
        {
          String s;
          int index = 2*i+2;
          sched[j+1][index] = 'x';
        }
      }
    }
  }

  /**
  *Prints out the sched char array
  */
  public void print()
  {
    for(int i = 0; i < 7; i++)
    {
      for(int j = 0; j < 11; j++)
        System.out.print(this.sched[i][j]);
    System.out.println();
    }
  }


  /**
  *Main function for the Week class
  */
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    Week mySched = new Week();
    mySched.print();
    for(String s = in.next(); !s.equals("quit"); s = in.next())
    {
      mySched.add(s);
      mySched.makeSched();
      mySched.print();
    }
  }
}
