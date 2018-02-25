/*
class that uses the interface of the other classes.
Takes an input file and decides what kind of file it is
*/
public class HW11 {
  /*
  Main method for the class.
  */
  public static void main(String[] args) {
    //Creates new Categorizer object
    Categorizer C = new Categorizer();
    
    C.add(new RecogASCII());
    C.add(new RecogJPG());
    C.add(new RecogPDF());
    C.printCategories(System.in);
  }
}
