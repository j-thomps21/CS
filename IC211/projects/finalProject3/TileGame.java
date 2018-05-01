import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * Class TileGame that initiates the gui which the user interacts with.
 * @author Thompson, Joshua - 206360
 */
public class TileGame
{
  /**
   * Main method that creates an array of colors and passes it into
   * the TileFrame. Then shows the TileFrame to the user.
   * @param args User inputs an integer to be used as the seed for the random color generator.
   */
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("usage: java TileGame <int seed>");
      System.exit(1);
    }

    //Makes sure that the user inputs an integer for the args of the command 
    try{
      Color[][] colorArray = DrBrownUtil.getRandomColorAssignments(Integer.parseInt(args[0]));
      TileFrame TF = new TileFrame(colorArray);
      TF.setVisible(true);
    } catch(NumberFormatException e) {
      System.out.println("usage: java TileGame <int seed>");
    }
  }
}
