import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    public Object data;
    public Node next;

    //Node constructor
    
    public Node(Object data) {
	  this.data = data;
      next = null;
    }
    
    public Node(Object data, Node next) {
	  this.data = data;
	  this.next = next;
    }
    
    public Object getData() {
	return data;
    }
	
    public void setData(Object data) {
	  this.data = data;
    }
	
    public Node getNext() {
	  return next;
    }
	
    public void setNext(Node next) {
	  this.next = next;
    }
}

public class LinkList {
  
  private static Node head;
  private static int size;
  
  public LinkList() {
   // this is an empty list, so the reference to the head node is set to a new node with no data
	  
	head = new Node(null);
	size = 0;
  }
		
  public static void addFirst(Object object) {
   /**
	 * Add an item to the front of the linkedlist.
	 */
  Node temp = new Node(object);
  Node current = head;	  
  
  if(head == null) {
	head = temp;
	head.next = null;
  }
  
  else {
    temp.next = head;
    head = temp;
  }
  size++;   	
  }
  
  public static void add(int index,Object object) {
   /**
	 * Add an item on a specific index in the linkedlist.
	 */
	  
  Node temp = new Node(object);
  Node current = head;	
  
  if(index < 0) {  
	System.out.println("Index entered by the user is negative. No element can be added.");
    return;
  }
  
  if(index == 0) {  
	temp.next = head;
	head = temp;
	size++;
	return;
  }
    
  if(head == null) {
	head = temp;
	head.next = null;
  }

  else {
  // crawl to the requested index or the last element in the list, whichever comes first
  for(int i = 1; i < index && current.getNext() != null; i++) {
    current = current.getNext();
  }
  // set the new node's next-node reference to this node's next-node reference
  temp.setNext(current.getNext());
  // now set this node's next-node reference to the new node
  current.setNext(temp);
   }
  size++; 
  }
	 
  public static void addLast(Object object) {
   /**
	 * Add an item to the back of the linkedlist.
	 */
  Node temp = new Node(object);
  Node current = head;
  
   if(head == null) {
	head = temp;
	head.next = null;
   }
   
   else {	  
  // starting at the head node, crawl to the end of the list
  while(current.getNext() != null) {
	current = current.getNext();
  }
  // the last node's "next" reference set to our new node
  current.setNext(temp);
   }
  size++;
  }

  public static Object removeFirst() {
   /**
	 * Removes the first item from the linked list.	 
	 */	 
	  
  System.out.println();	 	
  if(size==0) {	   
    System.out.println("The linked list is currently empty and has no elements.");	 	
    return head == null;  
  }	  
  
  Node current = head;
  head = head.getNext();
  
  System.out.println("The linked list has successfully removed " + current.getData());	   
  size--;
  return current;
  }
  
  public static Object removeLast() {
   /**
	 * Removes the last item from the linked list.	 
	 */	 
	  
   System.out.println();	 	
   if(size==0) {	   
	 System.out.println("The linked list is currently empty and has no elements.");	 	
	 return head == null;  
   }
  
  Node current = head;
  Node previousNode = head;
  while(current.getNext() != null) {
	previousNode = current;
	current = current.getNext();  
  }
  
  previousNode.setNext(null);
 
  System.out.println("The linked list has successfully removed " + current.getData());			 
  size--;
  return current;
  }
  
  public static boolean remove(int index) {
   /**
	 * Removes the item at the specified place in the linked list.	 
	 */	 
	  
  System.out.println();	
  
  Node current = head;
  
  if(index == 0) {  
	head = head.getNext();
	System.out.println("The linked list has successfully removed " + current.getData());	 
	size--; 
    return false;
  }
  	  
  if(index < 0) {  
	System.out.println("Index entered by the user is negative.");
    return false;
  }
  
  if(index >= size) {  
	System.out.println("Index entered by the user is greater than size.");
    return false;
  }
	  
  if(size==0) {	   
	System.out.println("The linked list is currently empty and has no elements so no elements can be removed.");	
	return false;
  }	  
	  
  else {		
	  for(int i=1; i < index; i++) {
	    if(current.getNext() == null) {
	      System.out.println("The linked list has ended before reaching the index. No element can be removed from the linked list.");	
		  return false;
	    }
	   current = current.getNext();
	  }	 		  
	}
  System.out.println("The linked list has successfully removed " + current.getNext().getData());
  current.setNext(current.getNext().getNext());
  size--; 
  return true;
  }

  public static boolean isEmpty() {
    /**
	 * Test if the link list is empty.
	 */	
	  
  System.out.println();	 	  
  if(size==0) {	   
  System.out.println("The linked list is currently empty and has no elements.");	 	  	   
  }
  else{
  System.out.println("The linked list is currently not empty.");	 		   
  }
  return head == null;  
  }
		 
  public static void size() {
   /**
	* Returns the number of items currently in the link list.
	*/
  System.out.println();	 	  
  System.out.println("The size of the linked list is: " + size);	 
		//   return link list.size();
  }
		 
  public static void display() {
   /**
	* Displays all the contents of the link list.
	*/
	  
   System.out.println();	   
   if(size==0) {	   
   System.out.println("The linked list is currently empty and has no elements.");	 	  	   
   }
   
   else {
   Node current = head;
   System.out.print("Contents of the linked list are: ");	 
   while(current != null) {	   
   System.out.print(current.getData() + " ");	 	
   current = current.getNext();
    }
   System.out.println();	 
   }
  }
  
  public static void displayFirst() {
   /**
     * Displays the first element of the linked list.
	 */

  System.out.println();	  
	  
  if(size==0) {	   
    System.out.println("The linked list is currently empty and has no elements.");	 	  	   
  }	  
  
  else {
   Node current = head;	  
   System.out.println("Content of the first element of the linked list is: " + current.getData());
   }
  }
  
  public static void displayLast() {
   /**
	* Displays the last element of the linked list.
    */

  System.out.println();	 	  
	  
  if(size==0) {	   
    System.out.println("The linked list is currently empty and has no elements.");	 	  	   
  }
  
  else {		   
  Node current = head.getNext();
  while(current.getNext() != null) {	  	  
	current = current.getNext();  
  }
  System.out.println("Content of the last element of the linked list is: " + current.getData());
  }
 }
  
  public static void display(int index) {
  /**
	* Displays the element at the specified position in the linked list.
	*/
	 
  System.out.println();	
  
  Node current = head;
  
  if(index == 0) {  
   head = head.getNext();
   System.out.println("Content of the specific element of the linked list is: " + current.getData());	 
   return;
  }
  
  if(index < 0) {  
   System.out.println("Index entered by the user is negative.");
   return;
  }
  
  if(index >= size) {  
   System.out.println("Index entered by the user is greater than size.");
   return;
  }
  
  if(size==0) {	   
  System.out.println("The linked list is currently empty and has no elements.");	 	  	   
  }
  
  else {		
  for(int i = 1; i < index-1; i++) {
    if(current.getNext() == null) {
	  System.out.println("The linked list has ended before reaching the index.");	
	  return;
	}
	current = current.getNext();
   }
  if(index==1){
   System.out.println("Content of the specific element of the linked list is: " + current.getData());
   return;
  }
  System.out.println("Content of the specific element of the linked list is: " + current.getNext().getData());
   }
  }
    
  public static void reverse() {
   /**
    * Sorts the elements of the linked list in an ascending order.
    */
	  
  Node current = head;	  
  Node previous = null;
 	    
  if(size==0) {	   
    System.out.println("The linked list is currently empty and has no elements.");	 	  	   
  }
		   
  else { 
	  
    while(current!=null) {
      Node next = current.next;
      current.next = previous;
      previous = current;
	  current = next;
	}	
    head = previous;
  }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

	int choice = 0;
	    
  do{	
	 System.out.println("1. For inserting an element at the first position in the linked list.");
	 System.out.println("2. For inserting an element at a given index in the linked list.");
	 System.out.println("3. For inserting an element at the end of a linked list.");
	 System.out.println("4. For deleting the first element from the linked list if it is present.");
	 System.out.println("5. For deleting the last element from the linked list if it is present.");
	 System.out.println("6. For deleting an element from the linked list if it is present.");
	 System.out.println("7. For displaying the first element of the linked list.");
	 System.out.println("8. For displaying the last element of the linked list.");
	 System.out.println("9. For displaying the element at the specified position in the linked list.");
	 System.out.println("10. For displaying the contents of the linked list.");
	 System.out.println("11. For checking the contents of the linked list are empty or not.");
	 System.out.println("12. For checking the size of the linked list.");
	 System.out.println("13. For reversing the linked list.");
	 System.out.println("14. For exiting from the program.");
	 
	 System.out.println();	
	 System.out.print("Enter your choice: ");
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	 choice = Integer.parseInt(br.readLine());
  switch (choice) {
   case 1:  System.out.println();	
	   	System.out.print("Enter a element to insert as the first element in the linkedlist: ");
	        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
	        String element = br1.readLine();
	        addFirst(element);
	    	break;
	case 2: System.out.println();	
		System.out.print("Enter the index of the element in the linkedlist: ");
	        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));  	
	        int index = Integer.parseInt(br2.readLine());
	        System.out.println();	
	    	System.out.print("Enter a element to insert in the linkedlist: ");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));  	
		String element1 = br3.readLine();
		add(index, element1);
	        break;
	case 3: System.out.println();	
		System.out.print("Enter a element to insert as the last element in the linkedlist: ");
	   	BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));  	
	   	String element2 = br4.readLine();
	   	addLast(element2);
	        break;
	case 4: removeFirst();
	        break;
	case 5: removeLast();
	        break;  
	case 6: System.out.println();	
		System.out.print("Enter the index of the element in the linkedlist: ");
	        BufferedReader br7 = new BufferedReader(new InputStreamReader(System.in));  	
		int index2 = Integer.parseInt(br7.readLine());
		remove(index2);
     		break;
	case 7: displayFirst();
     		break;  
	case 8: displayLast();
     		break;  
	case 9: System.out.println();	
		System.out.print("Enter the index of the element in the linkedlist: ");
	 	BufferedReader br8 = new BufferedReader(new InputStreamReader(System.in));  	
	        int index3 = Integer.parseInt(br8.readLine());
	        display(index3);
	 	break;  		
	case 10: display();
	         break; 
        case 11: isEmpty();
		 break;  
	case 12: size();
	   	 break;  
	case 13: reverse();
                 break;     	 
	}
	 System.out.print("\n");
		}while(choice!=14);
	 }
  }
