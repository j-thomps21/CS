import javax.swing.*;
import java.util.*;
import java.awt.*;

public class TileFrame extends JFrame
{
  public TileFrame(Color[][] c)
  {
    super("P2");
    this.add(new TileGrid(c));
    this.setLocation(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }
}
