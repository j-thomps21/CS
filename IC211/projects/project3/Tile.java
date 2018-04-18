import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;

public class Tile extends JPanel
{

  public Tile()
  {
    super(new FlowLayout());
    super.setPreferredSize(new Dimension(100,100));
    super.setBorder(BorderFactory.createLineBorder(Color.black));
    addMouseListener(new TileClickListener(this));
  }
}
