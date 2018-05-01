import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.imageio.*;
import java.io.*;

/**
 * Tile object that is the fundamental core of the TileGame.
 * @author Thompson, Joshua - 206360
 */
public class Tile extends JPanel
{
  private Pos coord;
  private Color tcolor;
  private TileListener tl;
  //State:         true = activated          false = deactivated
  //Dead:          true = dead               false = not dead
  //mousePress:    true = mouse was pressed  false = mouse has not been pressed
  //listen:        true = tile is listening for input
  //               false = tile is not listening for input
  private boolean state, dead, mousePress, listen;


  /**
   * Constructor for Tile class. Adds a MouseListener so that whenever the user clicks
   * the tile a corresponding method is called. Initializes all the boolean values.
   * @param i  Row value of the tile
   * @param j  Column value of the tile
   * @param c  Color of the tile
   * @param tf TileFrame object so tile can call certain methods from the frame
   */
  public Tile(int i, int j, Color c, TileFrame tf)
  {
    super(new FlowLayout());
    super.setPreferredSize(new Dimension(100,100));
    super.setBorder(BorderFactory.createLineBorder(Color.black));
    super.setBackground(c);
    addMouseListener(new TileClickListener(this));
    coord = new Pos(i, j);
    tcolor = c;
    tl = new TileListener(this, tf);
    state = false;
    dead = false;
    mousePress = false;
    listen = false;
  }

  /**
   * Secondary Constructor that takes no arguments. Only to make an empty tile
   */
  public Tile()
  {
    state = false;
    tcolor = Color.white;
  }

  /**
   * Calls the repaint method and changes the mousePress boolean to true
   */
  public void manualDraw()
  {
    mousePress = true;
    repaint();
  }

  /**
   * Calls the repaint method and changes the mousePress boolean to false
   */
  public void manualReset()
  {
    mousePress = false;
    repaint();
  }


  /**
   * Overwrites the paintComponent method. Based on the state of the boolean
   * datafields, either thickens the border of the tile or returns the border
   * to its normal state
   * @param g [description]
   */
  protected void paintComponent(Graphics g)
  {
    if(mousePress == true && listen == true && dead == false)
    {
      super.paintComponent(g);
      super.setBorder(BorderFactory.createLineBorder(Color.black, 5));
    }
    else
    {
      super.paintComponent(g);
      super.setBorder(BorderFactory.createLineBorder(Color.black));
    }
  }

  /**
   * method to add a TileListener.
   * @param tl TileListener object
   */
  public void addTileListener(TileListener tl)
  {
    this.tl = tl;
  }

  /**
   * Returns the row value of the tile
   * @return Row int value
   */
  public int getRow()
  {
    return coord.getRow();
  }

  /**
   * Gets the column value
   * @return column int value
   */
  public int getCol()
  {
    return coord.getCol();
  }

  /**
   * Gets the position of the tile
   * @return Pos object of tile
   */
  public Pos getPos()
  {
    return coord;
  }

  /**
   * Returns the coordinates of the tile
   * @return String for the coordinates
   */
  public String toString()
  {
    return coord.toString();
  }

  /**
   * Checks if the Tile is in the same position as the given point
   * @param  p Position object for a different tile (or possibly the same tile)
   * @return   Boolean value is positions are the same or not
   */
  public boolean equals(Pos p)
  {
    return coord.equals(p);
  }

  /**
   * Gets the color of the tile
   * @return Color object of the tile
   */
  public Color getColor()
  {
    return tcolor;
  }

  /**
   * Activates the tile if it isnt dead
   */
  public void activated()
  {
    if(!dead)
      tl.activated();
  }

  /**
   * deactivates the tile if it isnt dead
   */
  public void deactivated()
  {
    if(!dead)
      tl.deactivated();
  }

  /**
   * Gets the state of the tile
   * @return State boolean variable
   */
  public boolean getState()
  {
    return state;
  }

  /**
   * Sets the state to false
   */
  public void stateToFalse()
  {
      state = false;
  }

  /**
   * Kills the tile. sets the dead variable to true, and changes the color to white.
   */
  public void kill()
  {
    dead = true;
    tcolor = Color.white;
    this.setBackground(tcolor);
  }

  /**
   * Gets the dead value of the tile.
   * @return Dead variable
   */
  public boolean getDead()
  {
    return dead;
  }

  /**
   * Gets the listen value of the tile
   * @return Listen variable
   */
  public boolean getListen()
  {
    return listen;
  }

  /**
   * Toggles the state of the listen datafield
   */
  public void toggleListen()
  {
    if(listen)
      listen = false;
    else
      listen = true;
  }

  /**
   * Manualy switches the listen datafield to false, no matter what it was before.
   */
  public void listenToFalse()
  {
    listen = false;
  }
}
