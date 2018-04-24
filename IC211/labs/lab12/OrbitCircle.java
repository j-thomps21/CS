import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.geom.*;
import java.awt.image.*;


public class OrbitCircle extends JComponent
{
  Graphics2D g2;
  private double x0 = 150, y0 = 200;
  private double x1, y1;
  private double x2, y2;
  private double x3, y3;
  private double a0 = 0, a1 = 0;
  private double r0, r1;
  private Ellipse2D mainOrbit;
  private Ellipse2D mainPlanet;
  private Ellipse2D secondaryOrbit;
  private Ellipse2D secondaryPlanet;

  public OrbitCircle()
  {
    super();
    setPreferredSize(new Dimension(600, 600));
    x0 = 150;
    y0 = 200;
    x1 = x0 + 250 - 10/2;
    y1 = y0 + 250/2 - 10/2;
    x2 = x1 - 150/2;
    y2 = y1 - 150/2;
    x3 = x2 - 10/2 + 150;
    y3 = y2 - 10/2 + 150/2;
    r0 = 250/2;
    r1 = 150/2;
  }

  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g2 = (Graphics2D)g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    mainOrbit =       new Ellipse2D.Double(x0, y0, 250, 250);
    mainPlanet =      new Ellipse2D.Double(x1, y1, 10, 10);
    secondaryOrbit =  new Ellipse2D.Double(x2, y2, 150, 150);
    secondaryPlanet = new Ellipse2D.Double(x3, y3, 10, 10);

    draw();
  }

  public void moveOne()
  {
    a0++;
    a1++;

    x1 = (x0 + r0*Math.cos(a0));
    y1 = (y0 + r0*Math.sin(a0));
    x2 = (x1 + r1*Math.cos(a1));
    y2 = (y1 + r1*Math.sin(a1));
  }

  public void draw()
  {
    System.out.println("Drawing");
    g2.setColor(new Color(255,51,255,255));
    g2.draw(mainOrbit);
    g2.fill(mainPlanet);
    g2.setColor(new Color(155, 51, 255, 255));
    g2.draw(secondaryOrbit);
    g2.fill(secondaryPlanet);
  }
}
