import java.util.*;
//going to need to implement this using an
//adjacency list also with a hash table
public class Graph {
  private Hashtable<String, List<String>> graphTable;
////////////////////////////////////////////////////////////////////////
  public Graph() {
    graphTable = new Hashtable<String,List<String>>();
  }
////////////////////////////////////////////////////////////////////////
//add a new vertex, which will initially have no neighbors
  public void addVertex(String v) {
    graphTable.put(v, new ArrayList<Edge>());
  }
////////////////////////////////////////////////////////////////////////
//adds a new edge from v1 to v2 with an associated weight
  public void addEdge(String v1, String v2, double weight) {
    ArrayList<Edge> neighs1 = graphTable.get(v1);
    ArrayList<Edge> neighs2 = graphTable.get(v2);

    for(Edge tempEdge : neighs1){
      if(tempEdge.getOther(v2) == null){

      }
    }

  }
////////////////////////////////////////////////////////////////////////
//returns a list of edges that start from the vertex labeled v
  public List<Edge> neighbors(String v) {

  }
////////////////////////////////////////////////////////////////////////
//returns the Edge object from v1 to v2 or null if there is no such edge
  public Edge getEdge(String v1, String v2) {

  }
////////////////////////////////////////////////////////////////////////
}
