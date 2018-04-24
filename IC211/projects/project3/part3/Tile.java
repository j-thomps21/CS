import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;

public class Tile extends JPanel
{
  private Pos coord;
  private Color tcolor;
  public Tile(int i, int j, Color c)
  {
    super(new FlowLayout());
    super.setPreferredSize(new Dimension(100,100));
    super.setBorder(BorderFactory.createLineBorder(Color.black));

    super.setOpaque(false);
    super.setBackground(c);
    addMouseListener(new TileClickListener(this));
    coord = new Pos(i, j);
    tcolor = c;
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
    return coord.toString();
  }

  public boolean equals(Pos p)
  {
    return coord.equals(p);
  }
}
