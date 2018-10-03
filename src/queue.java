package graph;


public class queue {

    int size = 10;
    vertice[] queue = new vertice[size];
    int head = -1;
    int tail = -1;
    
    public boolean isEmpty(){
        if(( head == -1)||( tail == -1)){
            return true;
        } else {
            return false;
        }
    
    }
    
    public void enque(vertice value){
         
        if(isEmpty() == true){
            
             head =  head+1;
             tail =  tail+1;
             queue[ head] = value;
            
        } else if(( tail+1)% size ==  head) {
            
            throw new IllegalStateException("Queue is full");
            
        } else {
            
             tail =  tail+1;
        }
        
         queue[tail] = value;
        
    }
    
    public vertice deque(){
        
        if(isEmpty() == true){

            throw new IllegalStateException("Queue is empty, cant dequeue"); 
            
        } else if ( head ==  tail) {
            
             head = -1;
             tail = -1;
             return queue[head+1];
            
        } else {
            
             head =  head+1;
        }
        return  queue[ head];
    }
    
    public void peek(){
        if(isEmpty() == true){
            System.out.println("Queue is empty");
        }else{
            System.out.println(queue[head]);
        }
    }

    
}
  
