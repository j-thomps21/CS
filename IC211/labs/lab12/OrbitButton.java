import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class OrbitButton implements ActionListener
{
  private OrbitFrame oFrame;

  public OrbitButton(OrbitFrame oFrame)
  {
    this.oFrame = oFrame;
  }

  public void actionPerformed(ActionEvent e)
  {
    System.out.println("HEREERERERER");
    OrbitThread oThread = new OrbitThread(oFrame);
    oThread.start();
  }
}
