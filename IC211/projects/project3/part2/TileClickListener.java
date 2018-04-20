
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileClickListener implements MouseListener
{
  private boolean action = false;
  private Tile t;

  public TileClickListener(Tile t)
  {
    this.t = t;
  }

  public void mouseClicked(MouseEvent e)
  {
    if(action == false)
    {
      action = true;
      System.out.println("Tile " + t.toString() +  " activated");
    }
    else
    {
      action = false;
      System.out.println("Tile " + t.toString() + " deactivated");
    }
    System.out.println();
  }

  public void mousePressed(MouseEvent e)
  {
    System.out.println("Tile " + t.toString() + " pressed");
  }

  public void mouseReleased(MouseEvent e)
  {
    System.out.println("Tile " + t.toString() + " released");
  }

  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e) {}

}
