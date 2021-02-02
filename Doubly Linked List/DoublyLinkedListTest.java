import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    
    
    /**
     * Check if the isEmpty works
     */
    
    
    @Test
    public void testisEmpty()
    {    DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    
    assertTrue("Checking isEmpty for an empty list - expected result = true", testDLL.isEmpty());
    
    testDLL.insertBefore(0,1);
    
    /**
     * Check if the isEmpty works for filled lists
     */
    
    assertFalse("Checking isEmpty for a filled list - expected result = false", testDLL.isEmpty());
    }
    
    
    /**
     * Check if get() works
     */
    
    
    @Test
    public void testGet() {
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertBefore(0,1);
    	 testDLL.insertBefore(1,2);
    	 testDLL.insertBefore(2,3);
    	 
    	 int data = testDLL.get(1);
    	 
    	 assertEquals( "Checking the get method - expected result  = 2", "2", data );
    	 
    	 /**
    	     * Check if the get() works for empty lists
    	     */
    	 testDLL = new DoublyLinkedList<Integer>();
    	 data = testDLL.get(2);
    	  assertEquals( "Checking the get method - expected result  = null", null, data );
    	  
    	  /**
  	     * Check if the get() works position greater than the size of the list
  	     */
  	 testDLL = new DoublyLinkedList<Integer>();
  	 int index = testDLL.returnSize() + 1;
  	 data = testDLL.get(index);
  	  assertEquals( "Checking the get method - expected result  = null", null, data );
  	  
  	 /**
	     * Check if the get() works if position lesser than 0
	     */
	 testDLL = new DoublyLinkedList<Integer>();
	 data = testDLL.get(-2);
	  assertEquals( "Checking the get method - expected result  = null", null, data );
    	 
    }
    
    
    /**
     * Check if deleteAt works
     */
    
    @Test
    public void testDeleteAt() {
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertBefore(0,1);
    	 testDLL.insertBefore(1,2);
    	 testDLL.insertBefore(2,3);
    	 
    	 boolean result = testDLL.deleteAt(1);
    	 
    	 assertEquals( "Checking the deleteAt() method - expected result  = 1,3", "1,3",testDLL.toString());
    	 assertTrue( "Checking the get method - expected result  = true", result );
    	 
    	 /**
 	     * Check if the deleteAt() works if position lesser than 0
 	     */
    	 
 	 boolean result = testDLL.deleteAt(-2);
 	  assertFalse( "Checking the get method - expected result  = false", result );
 	  
 	 /**
	     * Check if the deleteAt() works if position greater than the size of the list
	     */

	 boolean result = testDLL.deleteAt(testDLL.returnSize() + 1);
	  assertFalse( "Checking the get method - expected result  = false", result );
    	 
    	 
    }
    
    
    /**
     * Check if reverse() works
     */
    
    @Test
    public void testReverse() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
   	 testDLL.insertBefore(0,1);
   	 testDLL.insertBefore(1,2);
   	 testDLL.insertBefore(2,3);
   	testDLL.insertBefore(3,4);
  	 testDLL.insertBefore(4,5);
  	 testDLL.insertBefore(5,6);
  	 
  	 testDLL.reverse();
  	 
  	 assertEquals( "Checking the reverse() method - expected result  = 6,5,4,3,2,1 ", "6,5,4,3,2,1",testDLL.toString());
  	 
  	/**
	     * Check if the reverse() works for list with only one element
	     */
  	 
  	testDLL = new DoublyLinkedList<Integer>();
  	testDLL.insertBefore(0,3);
  	testDLL.reverse();
  	assertEquals( "Checking the reverse() method - expected result  = 3 ", "3",testDLL.toString());
    }
    
    
    
    
    
    
    
    
    /**
    * Check if makeUnique() works
    */
   
   @Test
   public void testMakeUnique() {
   	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
  	 testDLL.insertBefore(0,1);
  	 testDLL.insertBefore(1,2);
  	 testDLL.insertBefore(2,3);
  	testDLL.insertBefore(3,1);
 	 testDLL.insertBefore(4,2);
 	 testDLL.insertBefore(5,4);
 	 
 	 testDLL.makeUnique();
 	 
 	 assertEquals( "Checking the makeUnique() method - expected result  = 1,2,3,4 ", "1,2,3,4",testDLL.toString());
 	 
 	/**
	     * Check if the makeUnique() works for list with only one element
	     */
 	 
 	testDLL = new DoublyLinkedList<Integer>();
 	testDLL.insertBefore(0,3);
 	testDLL.makeUnique();
 	assertEquals( "Checking the makeUnique() method - expected result  = 3 ", "3",testDLL.toString());
  
 	/**
     * Check if the makeUnique() works for list with only 2 elements
     */
	 
	testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,3);
	testDLL.insertBefore(1,3);
	testDLL.makeUnique();
	assertEquals( "Checking the makeUnique() method - expected result  = null ",null,testDLL.toString());
   
   }
   
  
    
    
    /**
     * Check if push works
     */
    
    
    @Test
    public void testPush() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
      	 testDLL.insertBefore(0,1);
      	 testDLL.insertBefore(1,2);
      	 testDLL.insertBefore(2,3);
      	testDLL.insertBefore(3,4);
      	
      	int testInt = 10;
      	
      	testDLL.push(testInt);
      	
      	assertEquals( "Checking the reverse() method - expected result  = 10,1,2,3,4 ", "10,1,2,3,4",testDLL.toString());
    	
    }
    
    /**
     * Check if pop works
     */
    
    
    @Test
    public void testPop() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
      	 testDLL.insertBefore(0,1);
      	 testDLL.insertBefore(1,2);
      	 testDLL.insertBefore(2,3);
      	testDLL.insertBefore(3,4);
      	
      	testDLL.pop();
      	
      	assertEquals( "Checking the reverse() method - expected result  = 2,3,4 ", "2,3,4",testDLL.toString());
    	
    }
    
    /**
     * Check if enqeueu works
     */
    
    @Test
public void testEnqeueu() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
      	 testDLL.insertBefore(0,1);
      	 testDLL.insertBefore(1,2);
      	 testDLL.insertBefore(2,3);
      	testDLL.insertBefore(3,4);
      	
      	int testInt = 13;
      	
      	testDLL.enqeueu(testInt);
      	
      	assertEquals( "Checking the reverse() method - expected result  = 13,1,2,3,4 ", "13,1,2,3,4",testDLL.toString());
    	
    }
    
    /**
     * Check if deqeueu works
     */
    
    @Test
    public void testDeqeueu() {
        	
        	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
          	 testDLL.insertBefore(0,1);
          	 testDLL.insertBefore(1,2);
          	 testDLL.insertBefore(2,3);
          	testDLL.insertBefore(3,4);
          	
          	testDLL.enqeueu();
          	
          	assertEquals( "Checking the reverse() method - expected result  = 1,2,3 ", "1,2,3",testDLL.toString());
        	
        }
        
    
}

