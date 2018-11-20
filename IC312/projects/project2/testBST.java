import java.io.*;
import java.util.*;

public class testBST{
  public static void main(String[] args) {
    Set<String> allWords = new MyHashSet();

    long start = System.nanoTime();
    Scanner sc = null;
    try{ sc = new Scanner(new File("american-english"));
  } catch(FileNotFoundException e){
    System.err.println("No american-english dictionary found! Aborting.");
    System.exit(1);}

    while(sc.hasNext())
      allWords.add(sc.next().toUpperCase());
    sc.close();

    /*
    allWords.add(1);
    allWords.add(2);
    allWords.add(3);
    allWords.add(4);
    allWords.add(5);
    allWords.add(6);
    allWords.add(7);
    allWords.add(8);
    allWords.add(9);
    allWords.add(10);
    */

    long elapsed = System.nanoTime() - start;
    List<String> printwords = allWords.toList();
    for(int i = 0; i < printwords.size(); i++)
      System.out.println(printwords.get(i));
    System.out.println(allWords.size());
    System.out.println(elapsed/1.0e9 + " seconds");
  }
}
