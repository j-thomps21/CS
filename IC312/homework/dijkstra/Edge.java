public class Edge implements Comparable<Edge>{
  /** a and b are the two Vertex names connected by this Edge*/
  private String a,b;
  /** the weight associated with this Edge */
  private double weight;

  /**
   * Build an Edge connecting vertices a and b, with the given weight
   * @param a One vertex name connected by this Edge
   * @param b The other vertex name connected by this Edge
   * @param weight The weight of this edge
   */
  public Edge(String a, String b, double weight) {
    this.a=a;
    this.b=b;
    this.weight=weight;
  }
  /**
   * Get one of the vertices connected by this edge
   */
  public String getFirst() {
    return a;
  }
  /**
   * Get the other vertex connected by this edge
   */
  public String getSecond() {
    return b;
  }
  /**
   * Given one of the vertices connected by this Edge, return the other one.
   * If the input vertex is not associated with this Edge, return null.
   */
  public String getOther(String x) {
    if (x.equals(a))
      return b;
    if (x.equals(b))
      return a;
    return null;
  }
  /**
   * Get the weight of this Edge.
   */
  public double getWeight() {
    return weight;
  }
  /**
   * Returns whether the input String is the name of either of the two
   * vertices associated with this Edge.
   */
  public boolean isIn(String x) {
    return (x.equals(a) || x.equals(b));
  }
  /**
   * Returns true if the input Object o is an Edge that connects the same two
   * vertices, regardless of order, with the same weight.  Returns false
   * otherwise.
   */
  public boolean equals(Object o) {
    if (o instanceof Edge) {
      Edge other = (Edge)o;
      if (other.isIn(a) && other.isIn(b) && other.getWeight()==weight)
        return true;
    }
    return false;
  }
  /**
   * Defines the "natural ordering" of Edges, where an Edge with a smaller
   * weight is less than an Edge with a larger weight.
   */
  public int compareTo(Edge other) {
    return new Double(weight).compareTo(new Double(other.weight));
  }
  /**
   * Returns a hashcode constructed of the two vertices' hashCodes and the
   * hashCode of the weight.
   */
  public int hashCode() {
    return a.hashCode()+b.hashCode()+(new Double(weight)).hashCode();
  }
}
