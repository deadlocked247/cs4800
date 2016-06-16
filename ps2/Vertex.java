public class Vertex {

  private String name;

  public Vertex(String name) {
      this.name = name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

  public Boolean equals(Vertex v) {
      return this.name.equals(v.name);
  }
}
