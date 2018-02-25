/*
Public class that recognizes PDF files.
Basically a plugin that adds on to functionality of RecogASCII
*/
public class RecogPDF extends RecogASCII
{
  /*
  data fields for the class. header contains the header for PDF files.
  If the header of the input file matches that of this header then the file is
  a PDF file.
  */
  private static char[] header = {'%', 'P', 'D', 'F'};
  private int i = 0;

  /*
  Returns that this class is searching for PDF files
  */
  public String getName()
  {
    return "PDF";
  }

  /*
  Actually does the checking of the header file
  */
  public void feed(int nextByte)
  {
    if(getState() == 2)
    {
      if((header[i] >= 0) && (nextByte != header[i]))
      {
        setState(0);
      }
    }
    i++;

    if((i > 3) && (getState() != 0))
      setState(1);
  }

  /*
  Returns whether the state is false or true. Telling if the file is PDF or not. 
  */
  boolean decision()
  {
    return getState() == 1;
  }
}
