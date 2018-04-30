import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class StartButtonListener implements ActionListener
{
  private boolean pause, exitReady;
  private TileFrame tf;
  private JButton startButton;
  private TimerThread ttimer;

  public StartButtonListener(TileFrame tf, JButton startButton)
  {
    pause = false;
    exitReady = false;
    this.tf = tf;
    this.startButton = startButton;
    ttimer = new TimerThread(tf, this);
  }

  public void actionPerformed(ActionEvent e)
  {
    if(tf.getExitReady())
    {
      System.exit(0);
    }
    else if(!pause)
    {
      startButton.setText("pause");
      pause = true;
    }
    else
    {
      startButton.setText("resume");
      pause = false;
    }
    startButton.repaint();
    tf.toggleStopTileClick();

    if(!ttimer.interrupted())
      ttimer.start();
    else
      ttimer.interrupt();
  }


}
