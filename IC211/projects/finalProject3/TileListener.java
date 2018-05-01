import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * Custom listener class that implements the MyListener interface.
 * @author Thompson, Joshua - 206360
 */
public class TileListener implements MyListener
{
  private Tile t;
  private TileFrame tf;

  /**
   * Constructor for the TileListener class. Takes a tile object, and a TileFrame
   * object so that it can communicate between the two objects. Acts as a middleman.
   * @param t  Tile object
   * @param tf TileFrame object.
   */
  public TileListener(Tile t, TileFrame tf)
  {
    this.t = t;
    this.tf = tf;
  }

  /**
   * Activates the tile by sending it to the TileFrame object and adding it to one of
   * the two temporary tiles to be checked for a match.
   */
  public void activated()
  {
    System.out.println(t.toString() + " activated");
    tf.activatedTiles(t);
  }

  /**
   * deactivates the tile by changing its state to false.
   */
  public void deactivated()
  {
    System.out.println(t.toString() + " deactivated");
    t.stateToFalse();
  }
}
