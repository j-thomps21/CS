import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class StartButtonListener implements ActionListener
{
  private boolean pause;
  private TileFrame tf;
  private JButton startButton;

  public StartButtonListener(TileFrame tf, JButton startButton)
  {
    pause = false;
    this.tf = tf;
    this.startButton = startButton;
  }

  public void actionPerformed(ActionEvent e)
  {
    if(!pause)
    {
      startButton = new JButton("pause");
      pause = true;
    }
    else
    {
      startButton = new JButton("resume");
      pause = false;
    }
    startButton.repaint();
    tf.toggleStopTileClick();
  }
}
