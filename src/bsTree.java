package graph;


public class bsTree {
    
   treeNode root;
   
   public void insertNode(vertice value){
       
       treeNode newNode = new treeNode(value);
       
       if(root == null){
           
           root = newNode;
           
       } else {
           
           treeNode targetNode = root;
           
           while(true) {
               
               newNode.parentNode = targetNode; 
               
               if(value.theFriend.weight < targetNode.data){
                   
                  targetNode = targetNode.leftChild;
                  
                  if(targetNode ==null){
                      
                      newNode.parentNode.leftChild = newNode;
                      return;
                      
                  }
               } else {
                   
                   targetNode = targetNode.rightChild;
                   
                   if(targetNode ==null){
                       
                       newNode.parentNode.rightChild = newNode;
                       return;
                       
                   }
               }
           }
       }
   }

       //In order Traverse Tree
       public void inOrderTT(treeNode targetNode){
           
           if(targetNode != null){

               inOrderTT(targetNode.leftChild);
               System.out.println(targetNode.data);
               inOrderTT(targetNode.rightChild);

           }
       
       }
       
       //Reverse in order Traverse Tree
       public void reverseInOrderTT(treeNode targetNode){
           
           if(targetNode != null){
               
               reverseInOrderTT(targetNode.rightChild);
               System.out.println(targetNode.data);
               reverseInOrderTT(targetNode.leftChild);

           }
       
       }
       
       //Pre-Order Traverse Tree
       public void preOrderTT(treeNode targetNode){
           
            if(targetNode != null){
                
               System.out.println(targetNode.data);
               preOrderTT(targetNode.leftChild);
               preOrderTT(targetNode.rightChild);

           }
       
       }
       //Reverse pre-Order Traverse Tree
       public void reversePreOrderTT(treeNode targetNode){
           
           if(targetNode != null){
               
              System.out.println(targetNode.data);
              preOrderTT(targetNode.rightChild);
              preOrderTT(targetNode.leftChild);

          }
      
      }
       
       //Post Order Traverse Tree
       public void postOrderTT(treeNode targetNode){
           
           if(targetNode != null){
               
              postOrderTT(targetNode.leftChild);
              postOrderTT(targetNode.rightChild);
              System.out.println(targetNode.data);
          }
      
      }
       
       //Reverse Post Order Traverse Tree
       public void reversePostOrderTT(treeNode targetNode){
           
           if(targetNode != null){
               
              postOrderTT(targetNode.rightChild);
              postOrderTT(targetNode.leftChild);
              System.out.println(targetNode.data);
          }
      
      }
       public treeNode findNode(int key){
           
           treeNode targetNode = root;
           
           while(targetNode.data != key){
               
               if(key < targetNode.data){
                   
                   targetNode = targetNode.leftChild;
                   
               } else {
                   
                   targetNode = targetNode.rightChild;
               }
           }
           return targetNode;
       }
       
       public int returnLeftChild(int value){
           treeNode targetNode = findNode(value);
           return targetNode.leftChild.data;
       }
       
       public int returnRightChild(int value){
           treeNode targetNode = findNode(value);
           return targetNode.rightChild.data;
       }
       
       public int returnParent(int value){
           treeNode targetNode = findNode(value);
           return targetNode.parentNode.data;
       }
       
       public int findMax(treeNode targetNode){
           if(targetNode == null) {
               return (Integer) null;
           } 
           if(targetNode.rightChild == null) {
               
               return targetNode.data;
           } else {
               
               return findMax(targetNode.rightChild);
           }

       }
       
       public int findMin(treeNode targetNode){
           if(targetNode == null) {
               return (Integer) null;
           } 
           if(targetNode.leftChild == null) {
               
               return targetNode.data;
           } else {
               
               return findMax(targetNode.leftChild);
           }

       }
       
/*       public void deleteNode(int value){
           Node targetNode = root;
           if (targetNode == null){
               return;
           } 
           if (targetNode.data < value) {
               
               deleteNode(targetNode.leftChild);
               
           } else {
               
               if(targetNode.data > value) {
                   
                   deleteNode(targetNode.rightChild);
               } else {
                   
                   if(targetNode.leftChild == null && targetNode.rightChild == null) {
                       
                       targetNode = null;
                   } else {
                       
                       if(targetNode.leftChild != null) {
                           int max = findMax(targetNode.leftChild);
                           targetNode.data = 
                       }
                   }
               }
               
           }
           
       }
       */

}
