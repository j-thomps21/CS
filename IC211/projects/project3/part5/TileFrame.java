import javax.swing.*;
import java.util.*;
import java.awt.*;

public class TileFrame extends JFrame
{
  private Tile[][] tileGrid;
  private Tile t1, t2;
  private JPanel jp, all, top;
  private JButton startButton;
  private boolean exitReady;

  public TileFrame(Color[][] c)
  {
    super("P2");
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

  public void resetTestTiles()
  {
    t1.manualReset();
    t2.manualReset();
    t1 = new Tile();
    t2 = new Tile();
  }


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

  public void toggleStopTileClick()
  {
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 6; j++)
      {
        if(!tileGrid[i][j].getDead())
        {
          tileGrid[i][j].toggleListen();
        }
        else
          tileGrid[i][j].listenToFalse();
      }
    }
  }

  public boolean getExitReady()
  {
    return exitReady;
  }

  public void addTimerLabels(JLabel time)
  {
    top.add(time);
    this.repaint();
  }
}
