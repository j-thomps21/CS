public class BoardListener
{
  private boolean tile1, tile2;
  private 
  private TileListener[][] tlArray;

  public BoardListener(TileListener[][] tl)
  {
    tlArray = tl;
    tile1 = false;
    tile2 = false;
  }

  public void detect(TileListener tl, int row, int col)
  {
    if(tile1 == false)
      tile1 = true;
    else
      tile2 = true;

    if(tile1 == true && tile2 == true)
      match();
  }

  public void match()
  {

  }


}
