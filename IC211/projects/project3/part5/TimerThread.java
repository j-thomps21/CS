import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TimerThread extends Thread
{
  private TileFrame tf;
  private StartButtonListener startButton;
  private int time;
  private boolean first;
  private JLabel timeLabel;

  public TimerThread(TileFrame tf, StartButtonListener sb)
  {
    this.tf = tf;
    startButton = sb;
    time = 0;
    first = true;
    timeLabel = new JLabel("0");
  }

  public void run()
  {
    if(first)
    {
      tf.addTimerLabels(timeLabel);
      first = false;
    }

    while(true)
    {
      try{
        timeLabel.setText("" + time);
        time++;
        Thread.sleep(1000);
      } catch(Throwable e){}
    }
  }
}
