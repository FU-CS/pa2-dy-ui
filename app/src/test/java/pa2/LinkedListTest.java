package pa2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAdd() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.traverse());
    }
    
    @Test
    void testAdd1() { //adding new head and in between the terms
    	LinkedList list = new LinkedList();
        list.add(1);
        list.add(-9);
        list.add(0);
        assertEquals("-9 0 1 ", list.traverse());
    }

    @Test
    void testRemove() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals("1 3 ", list.traverse());
    }
    
    @Test
    void testRemove1() { //removing head
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals("2 3 ", list.traverse());
    }
    
    @Test
    void testRemove3() { //removing tail
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals("1 3 ", list.traverse());
    }
    
    @Test
    void testTraverse() { //traversing normal list
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.traverse());
    }
    
    @Test
    void testTraverse1() { //traversing empty list
        LinkedList list = new LinkedList();
        assertEquals("", list.traverse());
    }
    
    @Test
    void testReverse() { //traversing normal list in reverse
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("3 2 1", list.reverse());
    }
    
    @Test
    void testReverse1() { //traversing list with head only in reverse with overloaded constructor
        LinkedList list = new LinkedList(new Node(5));
        assertEquals("5", list.reverse());
    }
    
    @Test
    void testMerge() { // merging two lists with equal length and commutativity
    	LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(8);
        LinkedList list2 = new LinkedList();
        list2.add(3);
        list2.add(5);
        list2.add(9);
        
        assertEquals(LinkedList.merge(list2, list1).traverse(), "1 2 3 5 8 9 ");
        
        list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(8);
        list2 = new LinkedList();
        list2.add(3);
        list2.add(5);
        list2.add(9);
        assertEquals(LinkedList.merge(list1, list2).traverse(), "1 2 3 5 8 9 ");
    }
    
    @Test
    void testMerge1() { // merging two lists with different lengths and commutativity
    	LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(8);
        list1.add(30);
        LinkedList list2 = new LinkedList();
        list2.add(3);
        list2.add(5);
        list2.add(9);
        
        assertEquals(LinkedList.merge(list2, list1).traverse(), "1 2 3 5 8 9 30 ");
        
        list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(8);
        list1.add(30);
        list2 = new LinkedList();
        list2.add(3);
        list2.add(5);
        list2.add(9);
        
        assertEquals(LinkedList.merge(list1, list2).traverse(), "1 2 3 5 8 9 30 ");
    }
    
    @Test
    void testMerge2() { // merging when one or both are null
    	LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        LinkedList list2 = new LinkedList();
        
        assertEquals(LinkedList.merge(list2, list1).traverse(), "1 2 ");
        
        list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list2 = new LinkedList();
        
        assertEquals(LinkedList.merge(list1, list2).traverse(), "1 2 ");
        
        list1 = new LinkedList();
        list2 = new LinkedList();
        
        assertEquals(LinkedList.merge(list1, list2).traverse(), "");
    }
    
    @Test
    void testMerge3() { // testing if some of the nodes in the too are common i.e. not two separate lists
    	LinkedList list1 = new LinkedList();
    	list1.add(1);
        list1.add(2);
    	
        assertEquals(LinkedList.merge(list1, list1), null);
    }
}
