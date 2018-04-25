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
  private boolean state;

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
    tl.activated(this);
  }

  public void deactivated()
  {
    tl.deactivated(this);
  }
}
