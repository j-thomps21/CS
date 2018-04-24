public class OrbitThread extends Thread
{
  private OrbitFrame oFrame;

  public OrbitThread(OrbitFrame oFrame)
  {
    this.oFrame = oFrame;
  }

  public void run()
  {
    System.out.println("Here");
    try{
      while(true)
      {
        oFrame.moveOne();
        Thread.sleep(500);
        oFrame.repaint();
        oFrame.revalidate();
      }
    } catch(InterruptedException e) {
      System.out.print("Something broke");
    }
   }
}
