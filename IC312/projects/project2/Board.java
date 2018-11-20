//The ONLY java.util classes allowed!
import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

//IO library --- you can use different IO libraries for speed, if you want...
import java.io.*;

//--------
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.BufferUnderflowException;
//----------



/** This is the main class that does the Boggle playing, using
 * your data structure.
 */
public class Board {
  // These are the faces of the 25 actual Boggle game dice!
  private static String[] dice = new String[] {
    "AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM",
      "AEEGMU", "AEGMNN", "AFIRSY", "BJKQXZ", "CCENST",
      "CEIILT", "CEILPT", "CEIPST", "DDHNOT", "DHHLOR",
      "DHLNOR", "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU",
      "FIPRSY", "GORRVW", "IPRRRY", "NOOTUW", "OOOTTU",
  };

  private Random rgen;

  private char[][] board = new char[5][5];

  private Set<String> englishWords; //This is your structure for holding all
                                    //words in the dictionary!

  /** Constructs the board, using a random seed for the random number generator.
   */
  public Board() {
    rgen = new Random(); // seed will be different every time
    initBoard();
    initDictionary();
  }

  /** Constructs the board, using a given seed for the random number
   * generator.  Constructing the board includes filling your data structure
   * with words from the american-english file.  If this file is not in the
   * current directory, prints an error message.
   *
   * @param seed the seed for the random object; running this with identical
   * seeds should get you identical dice rolls and placement.
   */
  public Board(long seed) {
    rgen = new Random(seed);
    initBoard();
    initDictionary();
  }

  /**Reads the file "american-english" and adds each word to a data structure
   * of your choosing (variable name 'englishWords')
   */
  private void initDictionary() {
    englishWords = new MyHashSet(); //TODO: this should be one of your data
                              //      structures!

    Scanner s = null;
    try { s = new Scanner(new File("american-english")); }
    catch (FileNotFoundException ee) {
      System.err.println("No american-english dictionary found! Aborting.");
      System.exit(1);
    }

    try{
      while (s.hasNext())
        englishWords.add(s.next().toUpperCase()); // store each word in your
                                                  // Set
    }catch(NoSuchElementException e){
      System.out.println(englishWords.size());
    }

    s.close();
  }

  /** Used to roll the dice, and fill the Boggle board with the results.*/
  private void initBoard() {
    List<Character> diceRolls = new ArrayList<Character>(25);
    for (String die : dice) {
      // Choose a random side from this die, and add it to the list
      diceRolls.add(diceRolls.size(),die.charAt(rgen.nextInt(6)));
    }

    // put the rolls into a random order
    for(int i=diceRolls.size();i>1;i--){
      int newIdx = rgen.nextInt(i);
      Character tmp = diceRolls.get(newIdx);
      diceRolls.set(newIdx, diceRolls.get(i-1));
      diceRolls.set(i-1,tmp);
    }

    for (int row = 0; row < 5; ++row) {
      for (int col = 0; col < 5; ++col) {
        board[row][col] = diceRolls.get(row*5+col);
      }
    }
  }

  /**
   * String representation of the Board.
   * Uses Unicode "box drawing" characters to make it look all purty.
   */
  @Override
  public String toString() {
    String s = "";
    s += "\u256d\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u256e\n";
    for (int r = 0; r < 5; r++) {
      s += "\u2502 ";
      for (int c = 0; c < 5; c++) {
        s += board[r][c];
        if (board[r][c]=='Q') s += "u";
        else s += " ";
      }
      s += "\u2502\n";
    }
    s += "\u2570\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u256f\n";
    return s;
  }

  /** Given a List full of Strings, returns the number of points that list of
   * Strings receives in a game of Boggle.
   */
  public static int countPoints(List<String> l) {
    int pts = 0;
    for(String s : l){
      switch(s.length()) {

        case 0:
        case 1:
        case 2: break;
        case 3:
        case 4: pts += 1;
                break;
        case 5: pts += 2;
                break;
        case 6: pts += 3;
                break;
        case 7: pts += 5;
                break;
        default:pts += 11;
                break;

      }
    }
    return pts;
  }

  /**
   * A method that returns a List filled with every word that appears in the
   * Boggle board.
   *
   * @return A List containing all English words in the board.
   *
   * This has two steps:
   * (1) Fill your data structure with all words that appear on the Boggle
   * board.
   * (2) Traverse that data structure and return the Queue.
   *
   * Remember the rules of Boggle; you can move to any of the (up to) eight
   * surrounding blocks for the next letter, but may not reuse a block.
   * And don't forget that a Q character automatically includes the "QU"!
   */
  public List<String> allWords() {
    // At first, no characters have been used, so these are all false.
    boolean[][] used = new boolean[5][5];

    //TODO: Fix this line and fill in your data structure here,
    //this could be an AVL or something else!
    Set<String> foundWords = new MyHashSet();

    // This loop calls your helper function, starting from each position.
    for (int r = 0; r < 5; r++)
      for (int c = 0; c < 5; c++){
        allWords("", r, c, used, foundWords);
      }


    //return all the found keys, or words in the board!
    return foundWords.toList();
  }

  /** Helper function for the allWords() method.
   * The whole point of this function is to fill in foundWords with
   * all the English words on the board.
   * May I suggest recursion???
   *
   * @param sofar The partial word constructed so far.
   * @param row The row in the board to get the next letter from.
   * @param col The column in the board to get the next letter from.
   * @param used Indicates which board letters are already in the word.
   * @param foundWords Holds all the actual English words on the board.
   */
  private void allWords(String sofar, int row, int col,
      boolean[][] used, Set<String> foundWords)
  {
    // Give up on words longer than 8 letters.
    // Feel free to take this out if your data structure is REALLY fast!
    if (sofar.length() > 8) return;


    /* TODO: You have to complete this method! Here's a rough sketch at how I
     * recommend to solve this:
     * 1) add the next letter to the word
     * 2) check if it's an english word, and if so add it to the data struct
     * 3) make a bunch of recursive calls (at most 8) for the surrounding
     * letters.
     *
     * You have to figure out how the "used" array fits into this!
     */

    //Check to see if the character is a Q and add a U
    //with it when adding to sofar
    if(board[row][col] == 'Q')
      sofar += "QU";
    else
      //otherwiese just add the character
      sofar += board[row][col];

    //mark the added character as used
    used[row][col] = true;

    //if the string sofar is in the english language
    //then add to foundWords
    if(englishWords.contains(sofar))
      foundWords.add(sofar);

    //8 recursive cases to check if the characters around
    //the current row/col have been used or not. If not,
    //then call the allWords method again on the next row/col
    if((row-1) >= 0 && (col-1) >= 0){
      if(!used[row-1][col-1])
        allWords(sofar, row-1, col-1, used, foundWords);
    }
    if((row-1) >= 0){
      if(!used[row-1][col])
        allWords(sofar, row-1, col, used, foundWords);
    }
    if((row-1) >= 0 && (col+1) <= 4){
      if(!used[row-1][col+1])
        allWords(sofar, row-1, col+1, used, foundWords);
    }
    if((col+1) <= 4){
      if(!used[row][col+1])
        allWords(sofar, row, col+1, used, foundWords);
    }
    if((row+1) <= 4 && (col+1) <= 4){
      if(!used[row+1][col+1])
        allWords(sofar, row+1, col+1, used, foundWords);
    }
    if((row+1) <= 4){
      if(!used[row+1][col])
        allWords(sofar, row+1, col, used, foundWords);
    }
    if((row+1) <= 4 && (col-1) >= 0){
      if(!used[row+1][col-1])
        allWords(sofar, row+1, col-1, used, foundWords);
    }
    if((col-1) >= 0){
      if(!used[row][col-1])
        allWords(sofar, row, col-1, used, foundWords);
    }

    //before exiting the method, mark the current character
    //as unused so that the later recursive calls can use the
    //character.
    used[row][col] = false;

  }
}














//
