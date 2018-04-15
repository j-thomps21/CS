import javax.swing.*;
import java.awt.*;

/**
Class HW1Frame that extends JFrame. Uses a CBn object that
adds some characteristics to button presses and window closing actions.
@author Thompson, Joshua 206360
*/
public class HW1Frame extends JFrame {
  /**
  Constructor for HW1Frame
  */
  public HW1Frame(){
    CBn b = new CBn("click me", this);
    add(b, BorderLayout.NORTH);
    pack();
  }
}
