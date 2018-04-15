import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
Class Cbn that adds functionality to JButton and adds some ActionListening functionality.
@author Thompson, Joshua 206360
*/
public class CBn extends JButton implements ActionListener, WindowListener {
  /**
  count datafield that is used to count how many times the user has
  clicked the button
  */
  private int count = 0;

  /**
  Constructor for CBn.
  @param label The desired label for the button
  @param j Takes a JFrame object in order to add WindowListening
  */
  public CBn(String label, JFrame j)
  {
    super(label);
    this.addActionListener(this);
    j.addWindowListener(this);
  }

  /**
  When this method is called, the count datafield is incremented. Called when
  the user clicks the button.
  @param e ActionEvent parameter
  */
  public void actionPerformed(ActionEvent  e)
  {
    count++;
  }

  /**
  Method that listens for when the window is closing. When this is called, the
  count value is printed to the screen and the program is exitted.
  @param e WindowEvent parameter
  */
  public void windowClosing(WindowEvent e)
  {
    System.out.println("Button clicked " + count + " times.");
    System.exit(0);
  }
  public void windowActivated(WindowEvent e)
  {}
  public void windowClosed(WindowEvent e)
  {}
  public void windowDeactivated(WindowEvent e)
  {}
  public void windowDeiconified(WindowEvent e)
  {}
  public void windowIconified(WindowEvent e)
  {}
  public void windowOpened(WindowEvent e)
  {}
}
