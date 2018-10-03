package graph;

//Holds Name of vertice in Array and his Friend

public class vertice{

  public String name;
  public node theFriend;
  public String colorOfVertice;
  public int distance;
  
  public vertice(String name, node friend){
      this.name = name;
      this.theFriend = friend;
      this.colorOfVertice = "white";
      this.distance = distance;
  }
  
}
