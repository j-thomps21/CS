import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * StartButtonListener class is a listener that listens to the start button at the top of the TileFrame gui.
 * When first displayed to the screen the button shows as "start" and prevents the user from interacting with
 * the tiles. When the button is pressed, the text changes to "pause" and the user can then click on the
 * tiles and play the game.
 * @author Thompson, Joshua - 206360
 */
public class StartButtonListener implements ActionListener
{
  private boolean pause, exitReady;
  private TileFrame tf;
  private JButton startButton;

  /**
   * Constructor for the StartButtonListener class. Initializes the data fields.
   * @param tf          TileFrame object
   * @param startButton JButton object
   */
  public StartButtonListener(TileFrame tf, JButton startButton)
  {
    pause = false;
    exitReady = false;
    this.tf = tf;
    this.startButton = startButton;
  }

  /**
   * When the button is clicked, this method is called. First checks if all the tiles in the
   * TileFrame are dead, if so, exit. If not, then continue. Then checks whether the button should
   * pause the game or resume based on what its state was previously.
   * @param e ActionEvent object
   */
  public void actionPerformed(ActionEvent e)
  {
    //If all the tiles are dead then exit.
    if(tf.getExitReady())
    {
      System.exit(0);
    }
    //If the game was going, then change the button text to resume and pause the game
    else if(!pause)
    {
      startButton.setText("pause");
      pause = true;
    }
    //If the game was paused, then change the button text to "pause" and resume the game
    else
    {
      startButton.setText("resume");
      pause = false;
    }
    //Repaint the button so the new text shows and toggle the users ability to
    //interact with the tiles
    startButton.repaint();
    tf.toggleStopTileClick();
  }


}
