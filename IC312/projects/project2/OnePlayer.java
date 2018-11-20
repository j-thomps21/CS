/* IC 312 Fall 2015
 * Project 2 starter code
 */

import java.util.List;
import java.util.Collections;

public class OnePlayer{
  /** Runs a one-player game (computer only), for speed.
   * If there are no command-line arguments, a fresh board is generated.
   * Otherwise, the first command-line argument is a seed value for the
   * random number generator.
   */
  public static void main(String[] args) {
    Board game;
    long start = System.nanoTime();

    if (args.length > 0) game = new Board(Long.parseLong(args[0]));
    else game = new Board();

    List<String> words = game.allWords();
    long elapsed = System.nanoTime() - start;
    System.out.println(game);
    Collections.sort(words);
    
    for(String s : words){
        System.out.println(s);
    }
    
    System.out.println(Board.countPoints(words) + " points");

    System.out.println((elapsed/1.0e9) + " seconds");
  }
}
