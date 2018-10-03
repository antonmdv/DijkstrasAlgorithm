package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class graphAdjacencyList {
    
    vertice[] adjacencyList, refreshList;

    
    public graphAdjacencyList(String fileName) throws FileNotFoundException{
        
        //Creates an array of vertices of a given size from file
        
        Scanner sc = new Scanner(new File(fileName));
        adjacencyList = new vertice[sc.nextInt()];
        
        //read into vertices without any connection 
        
        for(int i = 0; i < adjacencyList.length; i++){
            
            adjacencyList[i] = new vertice(sc.next().toUpperCase(), null);
        }
        
        //establish edges
        
        while(sc.hasNext()){
            
            String hisPositionString = sc.next().toUpperCase();
            int hisPosition = namesIndex(hisPositionString);
            
            String hisFriendsPositionString = sc.next().toUpperCase();
            int hisFriendsPosition = namesIndex(hisFriendsPositionString);
            
            
            adjacencyList[hisPosition].theFriend = new node(hisFriendsPosition, adjacencyList[hisPosition].theFriend);
            adjacencyList[hisPosition].theFriend.weight = sc.nextInt();
            
            adjacencyList[hisFriendsPosition].theFriend = new node(hisPosition, adjacencyList[hisFriendsPosition].theFriend);
            adjacencyList[hisFriendsPosition].theFriend.weight = adjacencyList[hisPosition].theFriend.weight;
        }
        
    }
    
    //returns requested match position in adjacencyList
    
    public int namesIndex(String name){
        
        for(int i = 0; i < adjacencyList.length; i++){
            
            if(adjacencyList[i].name.equals(name)){
                
                return i;
            }
        }
        
        return (Integer) null;
    }
    
    
    public void printNormalTest(){
        
       for(int i = 0; i < adjacencyList.length; i++){
           
           System.out.print(adjacencyList[i].name + " has edges with: ");
           
          
           while(adjacencyList[i].theFriend != null ){
               System.out.print(adjacencyList[adjacencyList[i].theFriend.verticeNumber].name + " (this path weight = " + adjacencyList[i].theFriend.weight + "); ");
               adjacencyList[i].theFriend = adjacencyList[i].theFriend.next;
           }
           System.out.println(" ");
           }
          
       }
    
    
 
    public vertice[] breadthFirstSearch(int index){
        
        vertice start = adjacencyList[index];
        
        queue q = new queue();
        refreshList = adjacencyList;
        
        vertice[] bfsList = new vertice[adjacencyList.length];
        
        
        start.colorOfVertice = "gray";
        q.enque(start);
        vertice next;
        
        while(q.isEmpty() != true){
            
            next = q.deque();
            
            int lowestCostPath = next.theFriend.weight;
            int pointTo = -1;
            
            while(next.theFriend != null){               
                
                if(lowestCostPath > next.theFriend.next.weight) {
                    
                    lowestCostPath = next.theFriend.next.weight;
                    pointTo = next.theFriend.next.verticeNumber;
                    next.theFriend.color = "gray";
                    next.theFriend.next.color = "black";
              
                } 
                    
                    pointTo = next.theFriend.verticeNumber;
                    next.theFriend.color = "black";   
                    next.theFriend = next.theFriend.next;
            }    
            
            while((pointTo > 0) ||(pointTo < adjacencyList.length) ){
                
                for(int i = 0; i < adjacencyList.length; i++){
                    
                    bfsList[i] = next;
                    next = adjacencyList[pointTo];
                    q.enque(next);
                }
                
            }
            
        }
        adjacencyList = refreshList; 
        return bfsList;
    }

        
       
      //White => not yet visited
      //Grey => has been scoped but not visited 
      //Black => has been visited

    
    //main action
    
    public static void main(String[] args) throws IOException{
        
        String filename = "charAndPaths.txt";
        graphAdjacencyList graph = new graphAdjacencyList(filename);
        graph.printNormalTest();
        
        int index = graph.namesIndex("B");
        vertice[] graph1 = graph.breadthFirstSearch(index);
        graph.printNormalTest();
        
    }
 
}
