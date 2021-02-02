import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{
	public int size = 0;

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  just a return operator(basic operation)
     */
    public boolean isEmpty()
    {
    	return size == 0;
    	
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  all the other operations are basic except the for loop which will asign "n" times(N* Theta(1)), hence the running time cost =Theta(n)
     */
    public void insertBefore( int pos, T data ) 
    {
    	DLLNode newNode = new DLLNode(data,null,null);
        if(pos < 0) {
        newNode.prev = head.prev;
        head = newNode;
        size++;
        }

        else if(pos >= size){
        newNode.next = tail.next;
        tail = newNode;
        size++;
        }

        else{
            DLLNode travs = new DLLNode(null,null,null);
            travs = head;
            for(int i = 0; i!=size;i++){
                travs = travs.next;
            }

            newNode.next = travs.prev.next;
            newNode.prev = travs.prev;
            travs.prev = newNode;

            size++;

        }
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  all the other operations are basic operations except the for loop which assigns n times hence the running time cost is Theta(n)
     *
     */
    public T get(int pos) 
    {
    	if(pos > size || pos < 0 ) return null;

        DLLNode temp = new DLLNode(null,null,null);
        
        if(isEmpty() == true) 
        	return null;
        else if(size == 1) {
        	return head.data;
        }
        else {
        
        	for(int i = 0; i <= pos; i++) {
        		temp = temp.next;
        		}
        	
        	return temp.data;
        }
    }
    
    //Worst-case asymptotic running time cost of remove() : Theta(1); since only basic operations are executed and
    //if-else statements are of running time theta(1) and the method calls execute in theta(1) as well
    
    public void remove (DLLNode node){

        if(node.prev == null) removeFirst();
        if(node.next == null) removeLast();
//make the pointers skip over the specified node
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;


    }
    

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(N/2)
     *
     * Justification:
     *  we are splitting the search in half, hence if the position is in the first half of the linked list, we just do the for loop in the first half(the same for the second half) 
     *  hence requiring Theta(N/2) time, other basic operations are worth theta(1) along with the if-else statements and also the remove() method call is worth theta(1)
     */
    public boolean deleteAt(int pos) 
    {
    	DLLNode travs = new DLLNode(null,null,null);
        if(pos<0 || pos >= size) return false;

        if(pos < size/2){
            travs = head;
            for(int i = 0; i < pos;i++)
                travs = travs.next; 
        }
        else { 
            travs = tail;
            for(int i = size-1; i != pos; i--)
                travs = travs.prev; 
        }

        remove(travs);
        return true;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(logN)
     *
     * Justification:
     *  the while loop uses Theta(logN) time adn teh other operations are basic operations along with the 
     *  if-else that just uses theta(1)
     */
    public void reverse()
    {
    	if(isEmpty()) throw new RuntimeException("Empty List");    
        
        DLLNode node = new DLLNode(null,null,null); 
        DLLNode currentNode = head; 
  //swapping the previous and nect of every node
        while (currentNode != null) { 
            node = currentNode.prev; 
            currentNode.prev = currentNode.next; 
            currentNode.next = node; 
            currentNode = currentNode.prev; 
        } 

    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(N^2)
     *
     * Justification:
     * the basic operations and the if-else statements only use theta(1) time
     *  the first for loop does basic operations N times, so the time is Theta(N) and the second
     *  for loop does the loop for (N-1) times, so the time is Theta(N-1)
     *  Theta(N)*Theta(N-1) = Theta(N^2 - N) = Theta(N^2)
     */
     public void makeUnique()
    { if(size == 0) throw new RuntimeException("Empty List");
      if(size == 1) //do nothing
      if(size == 2) {
    	  
    	  DLLNode node1 = head;
          DLLNode node2 = node1.next;
          
          T dataNd1 = node1.data;
          T dataNd2 = node2.data;
          
        	if(dataNd1.compareTo(dataNd2)==0) {head = null; tail = null;}	 
          
    	 
      }
      else {
      DLLNode node1 = head;
      DLLNode node2 = null;
      
      for(int i = 0; i<size;i++) {
    	  node2 = node1;
    	  for(int j = i; j<size; j++) {
    		 T dataNd1 = node1.data;
    		 T dataNd2 = node2.data;
    		 if(dataNd1.compareTo(dataNd2)==0)
    			 remove(node2);
    		 node2 = node2.next;
    	  }
      node1 = node1.next;
      }
      }
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  just a method call, where the method insertBefore uses Theta(N) time
     */   
     
    public void push(T item) 
    {
    	insertBefore(-1, item);
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  removeFirst() takes only theta(1) time adn the others are just basic operations taking theta(1) each
     */
    public T pop() 
    {
    	 T data = head.data;
         removeFirst();
         return data;
    }

  //Worst-case asymptotic running time cost of removeFirst() : Theta(1); since only basic operations are executed and
    //if-else statements are of running time theta(1) 
    
    public void removeFirst(){
        
        if(isEmpty()) throw new RuntimeException("Empty List");

        head = head.next;
        size--;
//if the list is empty now, set the tail to null as well
        if(isEmpty()) tail = null;
    
    } 
    
  //Worst-case asymptotic running time cost of removeLast() : Theta(1); since only basic operations are executed and
    //if-else statements are of running time theta(1) 
    
    
    public void removeLast(){
        
        if(isEmpty()) throw new RuntimeException("Empty List");

       
        tail = tail.prev;
        size--;
//if the list is empty now then set the head to null as well
        if(isEmpty()) head = null;
        
     
    } 
    
    
    
    
    
    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  the method call is theta(1) and the method itself uses theta(N) time hence the running time is theta(N)
     */
    public void enqueue(T item) 
    {
    	 insertBefore(-1, item);
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  the basic operations take theta(1) time and the removeLast() only takes theta(1) time
     */
    public T dequeue() 
    {
    	T data = tail.data;
        removeLast();
        return data;
    }
    
    // since it is just a return opertion it takes theta(1) time
    
    public int returnSize() {
    	return size;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



