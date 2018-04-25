import javax.swing.*;
import java.util.*;
import java.awt.*;

public class TileFrame extends JFrame
{
  private Tile[][] tileGrid;
  private static Tile t1, t2;
  private JPanel jp;

  public TileFrame(Color[][] c)
  {
    super("P2");
    tileGrid = new Tile[6][6];
    t1 = new Tile();
    t2 = new Tile();
    jp = new JPanel(new GridLayout(6,6));

    //Creates an array of Tiles
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        tileGrid[i][j] = new Tile(j, i, c[i][j]);
        jp.add(tileGrid[i][j]);
      }
    }
    this.add(jp);
    this.setLocation(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }

  public static void activatedTiles(Tile t)
  {
    System.out.println("Activating Tiles");
    if(t1.getColor().toString().equals(Color.white.toString()))
    {
      System.out.println("Tile 1 activated");
      t1 = t;
    }
    else if(t2.getColor().toString().equals(Color.white.toString()))
    {
      System.out.println("Tile 2 activated");
      t2 = t;
      checkMatch();
    }
  }

  public static void resetTestTiles()
  {
    System.out.println();
    System.out.println();
    System.out.println("RESETING TILES");
    System.out.println();
    System.out.println();
    t1 = new Tile();
    t2 = new Tile();
  }


  public static void checkMatch()
  {
    System.out.println("Checking tiles...");
    if(t1.equals(t2.getPos()))
    {
      System.out.println("NO MATCH");
      t1.deactivated();
      System.out.println("Tile 1 deactivated");
      t2.deactivated();
      System.out.println("Tile 2 deactivated");
      resetTestTiles();
    }
    else if(t1.getColor().toString().equals(t2.getColor().toString()))
    {
      System.out.println("MATCH");
      t1.kill();
      t2.kill();
      resetTestTiles();
    }
    else
    {
      System.out.println("NO MATCH");
      t1.deactivated();
      System.out.println("Tile 1 deactivated");
      t2.deactivated();
      System.out.println("Tile 2 deactivated");
      resetTestTiles();
    }
    System.out.println();
  }


}
