import java.awt.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class P1 used to create a basic Tile GUI
 * @author Thompson, Joshua - 206360
 */
public class P1
{
  /**
   * Creates a new JFrame which contrains a Tile object and other JLabels,
   * labeling north, south, east, and west
   * @param args none
   */
  public static void main(String[] args)
  {
    JFrame jf = new JFrame();
    JPanel tileUI = new JPanel(new BorderLayout());
    tileUI.add(new JLabel("WEST"), BorderLayout.WEST);
    tileUI.add(new JLabel("EAST"), BorderLayout.EAST);
    tileUI.add(new JPanel(new FlowLayout()).add(new JLabel("NORTH", SwingConstants.CENTER)), BorderLayout.NORTH);
    tileUI.add(new JPanel(new FlowLayout()).add(new JLabel("SOUTH", SwingConstants.CENTER)), BorderLayout.SOUTH);
    tileUI.add(new Tile());
    jf.add(tileUI);
    jf.pack();
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);




  }
}
