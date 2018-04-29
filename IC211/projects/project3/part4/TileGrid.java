import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TileGrid extends JPanel
{
  public TileGrid(Color[][] colorArray)
  {
    super(new GridLayout(6,6));
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        Tile t = new Tile(j, i, colorArray[i][j]);

        this.add(t);
      }
    }
  }

}
