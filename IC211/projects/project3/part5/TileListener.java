import javax.swing.*;
import java.util.*;
import java.io.*;

public class TileListener implements MyListener
{
  private Tile t;
  private TileFrame tf;

  public TileListener(Tile t, TileFrame tf)
  {
    this.t = t;
    this.tf = tf;
  }

  public void activated(Tile t)
  {
    System.out.println(t.toString() + " activated");
    tf.activatedTiles(t);
  }

  public void deactivated(Tile t)
  {
    System.out.println(t.toString() + " deactivated");
    t.stateToFalse();
  }
}
