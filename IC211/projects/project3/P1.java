

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
public class P1
{
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
