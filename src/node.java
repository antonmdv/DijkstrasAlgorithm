package graph;

//the "FriendShip" connection or edge of the graph;
public class node {
  
  public int verticeNumber;
  public int weight;
  public node next;
  public String color;
  
  public node(int verticeNumber, node nextFriend){
      this.verticeNumber = verticeNumber;
      this.next = nextFriend;
      this.weight = 0;
      this.color = "white";
  }
  
}
