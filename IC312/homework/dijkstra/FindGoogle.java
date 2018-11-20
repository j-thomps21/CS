import java.util.*;
import java.io.*;
public class FindGoogle{

  public static void main(String[] args) {
    String filename = args[0]; //simple.txt or pingdata.txt
    String startVertex = args[1]; //a hostname to start with
    Graph g = parseFile(filename);
    List<String> path = dijkstras(startVertex,g);
    System.out.println("The shortest path from "+startVertex+" to Google is:");
    for (String s : path){
      System.out.println(" "+s);
    }
  }

  /**
   * Build a Graph object by parsing the file.
   */
  public static Graph parseFile(String filename) {
  }

  /**
   * Return a List of Vertex names describing the shortest path, in order from
   * the starting vertex at index 0 to the final ending vertex, which should
   * be whichever Google host is closest.
   */
  public static List<String> dijkstras(String startV,Graph g) {
  }
}
