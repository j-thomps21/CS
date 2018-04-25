import javax.swing.*;
import java.util.*;
import java.io.*;

public class TileListener implements MyListener
{
  private Tile t;
  private boolean active, dead;
  private BoardListener bl;

  public TileListener(Tile t)
  {
    this.t = t;
    active = false;
    dead = false;
  }

  public void addBoardListener(BoardListener bl)
  {
    this.bl = bl;
  }

  public void activated(Tile t)
  {
    if(dead != true)
    {
      active = true;
      System.out.println("Tile " + t.toString() + " activated");
    }
  }

  public void deactivated(Tile t)
  {
    if(dead != true)
    {
      active = false;
      System.out.println("Tile " + t.toString() + " deactivated");
    }
  }

  public void kill()
  {
    dead = true;
    active = false;
  }
}
