import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;

public class Tile extends JPanel
{
  private Pos coord;
  private Color tcolor;
  private TileListener tl;
  private boolean state, dead;

  public Tile(int i, int j, Color c)
  {
    super(new FlowLayout());
    super.setPreferredSize(new Dimension(100,100));
    super.setBorder(BorderFactory.createLineBorder(Color.black));
    super.setBackground(c);
    addMouseListener(new TileClickListener(this));
    coord = new Pos(i, j);
    tcolor = c;
    tl = new TileListener(this);
    state = false;
    dead = false;
  }

  public Tile()
  {
    state = false;
    tcolor = Color.white;
  }

  public void addTileListener(TileListener tl)
  {
    this.tl = tl;
  }

  public int getRow()
  {
    return coord.getRow();
  }

  public int getCol()
  {
    return coord.getCol();
  }

  public Pos getPos()
  {
    return coord;
  }

  public String toString()
  {
    return coord.toString() + " Color: " + tcolor.toString();
  }

  public boolean equals(Pos p)
  {
    return coord.equals(p);
  }

  public Color getColor()
  {
    return tcolor;
  }

  public void activated()
  {
    if(!dead)
      tl.activated(this);
  }

  public void deactivated()
  {
    if(!dead)
      tl.deactivated(this);
  }

  public boolean getState()
  {
    return state;
  }

  public void stateToFalse()
  {
      state = false;
  }

  public void kill()
  {
    dead = true;
    tcolor = Color.white;
    this.setBackground(tcolor);
  }
}
