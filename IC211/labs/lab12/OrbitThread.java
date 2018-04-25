/**
 * Class OrbitThread extends Thread and runs all the
 * orbiting calculations in a different thread from the gui
 * @author Thompson, Joshua - 206360 
 */
public class OrbitThread extends Thread
{
  private OrbitFrame oFrame;

  /**
   * Constructor for the OrbitThread
   * @param oFrame Takes an OrbitFrame object.
   */
  public OrbitThread(OrbitFrame oFrame)
  {
    this.oFrame = oFrame;
  }

  /**
   * Run method is started with the start() call and performs an infinite loop of
   * orbit calculations with the thread sleeping 50 after every run.
   */
  public void run()
  {
    try{
      while(true)
      {
        oFrame.moveOne();
        Thread.sleep(50);
        oFrame.repaint();
        oFrame.revalidate();
      }
    } catch(InterruptedException e) {
    }
   }
}
