import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class P3
{
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("usage: java P2 <int seed>");
      System.exit(1);
    }
    Color[][] colorArray = DrBrownUtil.getRandomColorAssignments(Integer.parseInt(args[0]));
    TileFrame TF = new TileFrame(colorArray);
    TF.setVisible(true);
  }
}
