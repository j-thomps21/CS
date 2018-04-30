
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileClickListener implements MouseListener
{
  private boolean clicked, pressed;
  private Tile t;

  public TileClickListener(Tile t)
  {
    this.t = t;
    clicked = false;
    pressed = false;
  }

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

  public void mousePressed(MouseEvent e)
  {
    pressed = true;
    if(!t.getDead() && t.getListen())
      t.manualDraw();
  }

  public void mouseReleased(MouseEvent e){}

  public void resetBool()
  {
    clicked = false;
    pressed = false;
  }
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e)
  {
    if(!clicked && pressed)
      t.manualReset();
    resetBool();
  }

}
