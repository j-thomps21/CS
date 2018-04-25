import javax.swing.*;
import java.awt.*;


/**
 * Class OrbitFrame  extends JFrame and just creates a new custom frame with
 * the circles displaying in the main body and a start button at the top
 * @author Thompson, Joshua - 206360
 */
public class OrbitFrame extends JFrame
{
  private JButton start;
  private OrbitCircle oc;


  /**
   * Constructor for the OrbitFrame class creates all the objects that will be displayed in the
   * gui and adds an ActionListener to the button so that when the button is clicked
   * the action can be performed for that button click.
   */
  public OrbitFrame()
  {
    oc    = new OrbitCircle();
    start = new JButton("start");
    start.addActionListener(new OrbitButton(this));
    JPanel jp = new JPanel(new BorderLayout());

    jp.add(oc, BorderLayout.CENTER);
    jp.add(start, BorderLayout.NORTH);
    this.add(jp);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }

  /**
   * The moveOne method from the OrbitCircle class.
   */
  public void moveOne()
  {
    oc.moveOne();
  }
}
