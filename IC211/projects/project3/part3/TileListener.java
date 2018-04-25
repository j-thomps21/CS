import javax.swing.*;
import java.util.*;
import java.io.*;

public class TileListener implements MyListener
{
  private Tile t;

  public TileListener(Tile t)
  {
    this.t = t;
  }

  public void activated(Tile t)
  {
    System.out.println(t.toString() + " ACTIVATED");
    TileFrame.activatedTiles(t);
  }

  public void deactivated(Tile t)
  {
    System.out.println(t.toString() + " DEACTIVATED");
    t.stateToFalse();
  }
}
