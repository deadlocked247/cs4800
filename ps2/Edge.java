public class Edge {

  private Vertex to;

  private Vertex from;

  private int weight;

  public Edge(Vertex from, Vertex to) {
      this.to = to;
      this.from = from;
      this.weight = 1;
  }

  public Edge(Vertex from, Vertex to, int weight) {
      this.to = to;
      this.from = from;
      this.weight = weight;
  }

  @Override
  public String toString() {
      return this.getFrom().getValue() + "->" + this.getTo().getValue() + " (" + this.getWeight() + " )";
  }

  public Vertex getTo() {
      return this.to;
  }

  public Vertex getFrom() {
      return this.from;
  }

  public Integer getWeight() {
      return this.weight;
  }

  public Boolean equals(Edge other) {
      return (this.to.equals(other.getTo()) && this.from.equals(other.getFrom()) && this.weight == other.getWeight());
  }

}
