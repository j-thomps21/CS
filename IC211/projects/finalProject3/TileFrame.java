import javax.swing.*;
import java.util.*;
import java.awt.*;

/**
 * TileFrame class that creates the whole frame in which the game is based upon.
 * @author Thompson, Joshua - 206360
 */
public class TileFrame extends JFrame
{
  private Tile[][] tileGrid;
  private Tile t1, t2;
  private JPanel jp, all, top;
  private JButton startButton;
  private boolean exitReady;

  /**
   * Constructor for the TileFrame class. Creates two JPanels which are then put into a bigger JPanel,
   * which is then added to the frame. The top panel contains the startButton and the bottom JPanel
   * contains the grid of tiles.
   * @param c 2D array of Color objects which is used to create the grid of tiles.
   */
  public TileFrame(Color[][] c)
  {
    super("TileGame");
    exitReady = false;
    tileGrid = new Tile[6][6];
    t1 = new Tile();
    t2 = new Tile();
    jp = new JPanel(new GridLayout(6,6));
    all = new JPanel(new BorderLayout());
    top = new JPanel(new FlowLayout());
    startButton = new JButton("start");
    startButton.addActionListener(new StartButtonListener(this, startButton));
    top.add(startButton);

    //Creates an array of Tiles
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        tileGrid[i][j] = new Tile(j, i, c[i][j], this);
        jp.add(tileGrid[i][j]);
      }
    }
    all.add(top, BorderLayout.NORTH);
    all.add(jp, BorderLayout.CENTER);
    this.add(all);
    this.setLocation(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }

  /**
   * This method is called when the TileListener class wants to activate a tile.
   * The method adds the input tile to one of temporary tiles in the datafield. Then
   * checks to see if two tiles are activate. If so, then check to see if they match.
   * @param t [description]
   */
  public void activatedTiles(Tile t)
  {
    if(t1.getColor().toString().equals(Color.white.toString()))
    {
      t1 = t;
    }
    else if(t2.getColor().toString().equals(Color.white.toString()))
    {
      t2 = t;
      checkMatch();
    }
  }

  /**
   * Resets the temporary tiles.
   */
  public void resetTestTiles()
  {
    t1.manualReset();
    t2.manualReset();
    t1 = new Tile();
    t2 = new Tile();
  }


  /**
   * Checks to see if the two temporary tiles match by using their toString methods.
   * After checking, the method resets the temp tiles. After checking to see if the
   * tiles match, the method also checks to see if all the tiles in the board are
   * dead and if so, changes the top button to "exit"
   */
  public void checkMatch()
  {
    if(t1.equals(t2.getPos()))
    {
      t1.deactivated();
      t2.deactivated();
      resetTestTiles();
    }
    else if(t1.getColor().toString().equals(t2.getColor().toString()))
    {
      System.out.println(t1.toString() + " deactivated");
      System.out.println(t2.toString() + " deactivated");
      t1.kill();
      t2.kill();
      resetTestTiles();
    }
    else
    {
      t1.deactivated();
      t2.deactivated();
      resetTestTiles();
    }
    System.out.println();

    if(checkAllDead() == true)
    {
      exitReady = true;
      startButton.setText("exit");
    }
  }

  /**
   * Checks to see if all the tiles on the board are dead by checking their
   * .getDead methods.
   * @return [description]
   */
  public boolean checkAllDead()
  {
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        if(!tileGrid[i][j].getDead())
          return false;
      }
    }
    return true;
  }

  /**
   * This method toggles the user's abilty to interact with the tiles.
   * When the program is first started, the user is not allowed to
   * interact with the tiles, but when the startButton is clicked,
   * this method is called which then allows them to interact with the tiles.
   */
  public void toggleStopTileClick()
  {
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        if(!tileGrid[i][j].getDead())
          tileGrid[i][j].toggleListen();
        else
          tileGrid[i][j].listenToFalse();
      }
    }
  }

  /**
   * If the TileFrame is ready to be exited, then return true.
   * @return Returns exitReady boolean
   */
  public boolean getExitReady()
  {
    return exitReady;
  }
}
