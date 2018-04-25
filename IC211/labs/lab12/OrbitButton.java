import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class OrbitButton performs methods when the button in the gui is clicked.
 * @author Thompson, Joshua  - 206360
 */
public class OrbitButton implements ActionListener
{
  private OrbitFrame oFrame;
  private OrbitThread oThread;

  /**
   * Constructor for the OrbitButton class.
   * @param oFrame Takes an OrbitFrame object for parameter.
   */
  public OrbitButton(OrbitFrame oFrame)
  {
    this.oFrame = oFrame;
  }

  /**
   * When the action is performed(button clicked) a new OrbitThread is created and started.
   * @param e Takes ActionEvent object
   */
  public void actionPerformed(ActionEvent e)
  {
      oThread = new OrbitThread(oFrame);
      oThread.start();
  }
}
