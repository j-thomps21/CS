
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * TileClickListener class listens for when the user interacts with the tile via the mouse.
 * @author Thompson, Joshua - 206360
 */
public class TileClickListener implements MouseListener
{
  private boolean clicked, pressed;
  private Tile t;

  /**
   * Constructor for the TileClickListener class.
   * @param t Takes in a Tile object
   */
  public TileClickListener(Tile t)
  {
    this.t = t;
    clicked = false;
    pressed = false;
  }

  /**
   * If the user clicked the tile then execute this method. Method checks whether its
   * associated tile is supposed to be listening to input. If so, then check the state
   * of the tile and either activate it or deactivate it.
   * @param e MouseEvent object
   */
  public void mouseClicked(MouseEvent e)
  {
    clicked = true;
    if(t.getListen())
    {
      if(!t.getState())
        t.activated();
      else
        t.deactivated();
    }
  }

  /**
   * If the user presses the mousebutton down on the tile then execute this method.
   * Note that the user does not have to fully click the mouse, only press down
   * on the mousebutton. When the mousebutton is pressed, it redraws the button
   * so that a border shows as visual feedback to the user that they pressed the button.
   * @param e MouseEvent object
   */
  public void mousePressed(MouseEvent e)
  {
    pressed = true;
    if(!t.getDead() && t.getListen())
      t.manualDraw();
  }

  /**
   * Resets the boolean values to false. Done whenever the user presses the mouse down on the tile
   * but exits the tile before clicking.
   */
  public void resetBool()
  {
    clicked = false;
    pressed = false;
  }

  /**
   * This method is executed everytime the user's mouse exits the tile. Does a check
   * to see if the user presses the mouse down on the tile, but exits before clicking.
   * If this happens, the tile border goes back to normal.
   * @param e MouseEvent e
   */
  public void mouseExited(MouseEvent e)
  {
    if(!clicked && pressed)
      t.manualReset();
    resetBool();
  }

  public void mouseReleased(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
}
