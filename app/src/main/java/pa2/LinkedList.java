package pa2;

//import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A sorted singly linked list of integers
 */
public class LinkedList {

    /**
     * A node in the linked list
     */
    public Node head;

    /**
     * Constructor
     * Initialize the linked list with a null head
     */
    public LinkedList() {
        
    }
    public LinkedList(Node head) {
        this.head = head;
    }

    /** 
     * Add a new node to the linked list 
     * so that the list remains sorted
     * @param value The value to add
     * @return void
     */
    public void add(int value) {
    	if (this.head == null) {
    		this.head = new Node(value);
    		return;
    	}
    	if (this.head.value >= value) {
    		Node new_head = new Node(value);
    		new_head.next = this.head;
    		this.head = new_head;
    		return;
    	}
    	Node curr = this.head;
    	while (curr.next != null) {
    		if (curr.next.value >= value) {
    			Node new_node = new Node(value);
    			new_node.next = curr.next;
    			curr.next = new_node;
    			return;
    		}
    		curr = curr.next;
    	}
    	curr.next = new Node(value);
    }

    /**
     * Remove the first node with the given value
     * If the value is not found, do nothing
     * @param value The value to remove
     * @return void
     */
    public void remove(int value) {
    	Node dummy = new Node(0);
    	dummy.next = this.head;
    	Node curr = dummy;
    	while (curr.next != null) {
    		if (curr.next.value == value) {
    			curr.next = curr.next.next;
    			this.head = dummy.next;
    			return;
    		}
    		curr = curr.next;
    	}

    }

    /**
     * Traverse the linked list RECURSIVELY and returns a string representation of the list
     * @param current
     * @return String
     */
    private String traverse(Node current){
    	if (current == null)
    		return "";
    	return Integer.toString(current.value) + " " + traverse(current.next);
    }

    /**
     * Traverse the linked list and returns a string representation of the list
     * @return String
     */
    public String traverse(){
        return traverse(this.head);
    }

    public String reverse(){
        if (this.head == null) {
        	return "";
        }
        return reverse(this.head);
    }

    /**
     * Traverse the linked list RECURSIVELY and 
     * returns a string representation of the list
     * @return String
     */
    private String reverse(Node current){
    	if (current.next == null)
    		return Integer.toString(current.value);
    	return reverse(current.next) + " " + Integer.toString(current.value);
    }
    /**
     * Merges two sorted linked list and returns the 
     * merged linked list that is also sorted
     * @param list1 The first sorted linked list
     * @param list2 The second sorted linked list 
     * @return LinkedLists
     */
    public static LinkedList merge(LinkedList list1, LinkedList list2){
       Node dummy = new Node(0);
       Node res = dummy;
       Node h1 = list1.head;
       Node h2 = list2.head;
       while (h1 != null && h2 != null) {
    	   if (h1 == h2) {
    		   System.out.println("some nodes were common");
    		   return null;
    	   }
    	   if (h1.value < h2.value) {
    		   dummy.next = h1;
    		   h1 = h1.next;
    	   }
    	   else {
    		   dummy.next = h2;
    		   h2 = h2.next;
    	   }
    	   dummy = dummy.next;
       }
       if (h1 == null) {
    	   dummy.next = h2;
       }
       else {
    	   dummy.next = h1;
       }
       return new LinkedList(res.next);
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.traverse());
        list.remove(3);
        System.out.println(list.traverse());    
        
    }
}


