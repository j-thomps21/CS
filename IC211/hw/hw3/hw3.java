import java.util.*;

public class hw3 {
  //This function takes in the desired company as x, the original mids array
  //the original amount of mids, and the final amount after the search
  //The function will return a mids array with the mids of the desired company
  public static mid[] search(int x, mid[] allMids, int amt, int finalamt)
  {
    mid[] finalMids = new mid[finalamt];
    int entryCount = 0;
    for(int i = 0; i < amt; i++)
    {
      if(allMids[i].company == x)
      {
        finalMids[entryCount] = allMids[i];
        entryCount++;
      }
      else
        continue;
    }
    return finalMids;
  }

  //This function searches for the mids of the desired company but
  //only returns how many there are in that particular company.
  //This returned amount is used in the above search function
  public static int searchAmount(int x, mid[] allMids, int amt)
  {
    int counter = 0;
    for(int i = 0; i < amt; i++)
    {
      if(allMids[i].company == x)
        counter++;
      else
        continue;
    }
    return counter;
  }

  public static void main(String[] args)
  {
    int x;
    System.out.print("How many mids? ");
    Scanner in = new Scanner(System.in);
    x = in.nextInt();

    mid[] Mids = new mid[x];
    for(int i = 0; i < x; i++)
      Mids[i] = mid.createMid();

    System.out.print("What company would you like to print out? ");
    int comp = in.nextInt();
    int finalamt = searchAmount(comp, Mids, x);
    mid[] finalMids = search(comp, Mids, x, finalamt);
    for(int i = 0; i < finalamt; i++)
      mid.printMid(finalMids[i]);
  }
}
