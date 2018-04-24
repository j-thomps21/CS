import javax.swing.*;
import java.awt.*;

public class OrbitFrame extends JFrame
{
  private JButton start;
  private OrbitCircle oc;


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

  public void moveOne()
  {
    oc.moveOne();
  }

  public void draw()
  {
    oc.draw();
  }
}
