
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * TileClickListener class that listens to mouse actions that
 * happen on the tile object.
 * @author Thompson, Joshua - 206360
 */
public class TileClickListener implements MouseListener
{
  private boolean action = false;
  private Tile t;

  /**
   * Constructor for the TileClickListener class
   * @param t Tile object
   */
  public TileClickListener(Tile t)
  {
    this.t = t;
  }

  /**
   * When the user clicks the mouse, the action boolean is toggled,
   * which then prints a message depending on what state the
   * boolean variable is in
   * @param e MouseEvent object when the event happens
   */
  public void mouseClicked(MouseEvent e)
  {
    if(action == false)
    {
      action = true;
      System.out.println("Tile activated");
    }
    else
    {
      action = false;
      System.out.println("Tile deactivated");
    }
    System.out.println();
  }

  /**
   * When the user pressses down on the mouse while in the Tile,
   * "Tile pressed" string is printed
   * @param e MouseEvent object
   */
  public void mousePressed(MouseEvent e)
  {
    System.out.println("Tile pressed");
  }

  /**
   * When the user releases the mouse button (after pressing down on the tile)
   * "Tile released" string is printed
   * @param e MouseEvent object
   */
  public void mouseReleased(MouseEvent e)
  {
    System.out.println("Tile released");
  }

  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e) {}

}
