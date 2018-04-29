
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileClickListener implements MouseListener
{
  private Tile t;

  public TileClickListener(Tile t)
  {
    this.t = t;
  }

  public void mouseClicked(MouseEvent e)
  {
    if(!t.getState())
      t.activated();
    else
      t.deactivated();
  }

  public void mousePressed(MouseEvent e)
  {
    t.manualDraw();
  }

  public void mouseReleased(MouseEvent e)
  {
  }
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e) {}

}
