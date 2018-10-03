package graph;

public class treeNode {
    
    int data;
    vertice me;
    
    
    treeNode leftChild,rightChild,parentNode; 
    
    treeNode(vertice me){
        this.me = me;
        this.data = me.theFriend.weight;
    }
    
}
