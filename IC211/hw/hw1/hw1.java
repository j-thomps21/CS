import java.util.*;

public class hw1 {
  public static int maxlength(String[] A)
  {
    int max = A[0].length();
    for(int i = 0; i < A.length; i++)
    {
      if(A[i].length() > max)
      {
        max = A[i].length();
      }
    }
    return max;
  }

  public static void Print(String[] words, int n)
  {
    //uses the maxlength function to get the word with the max length
    //and uses it in the first for loop
    int maxlength = maxlength(words);
    for(int i = 0; i < maxlength; i++)
    {
      //use nested for loop to write the words vertically
      for(int j = 0; j < n; j++)
      {
        //if the word has run out of characters, then instead of
        //printing characters then just put two spaces
        if(words[j].length() <= i)
          System.out.print("  ");
        else
          System.out.print(words[j].charAt(i) + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    //first gets how many words there will be
    int n = in.nextInt();
    //then use for loop to get the words
    String[] words = new String[n];
    for(int i = 0; i < n; i++)
      words[i] = in.next();
    System.out.println(maxlength(words));
    //calls the print function which does the rest of the work
    Print(words, n);
  }
}
