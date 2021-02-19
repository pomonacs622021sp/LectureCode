package linkedlist;

/**
 * A partial linked list implementation
 * 
 * @author dave
 *
 * @param <E>
 */
public class LinkedList<E>{ 
	private Node head; 

	public LinkedList() { 
		head = null; 
	} 
	
	public void addFirst(E value) {
		Node newNode = new Node(value);
		newNode.setNext(head);
		head = newNode;
	}
	
	public void addFirst2(E value) {
		// note order that things happen:
		// right hand side gets evaluated and head is a parameter
		// the result of the right hand side then gets associated with head
		head = new Node(value, head); 
	}
	
	public E removeFirst() {
		if( head == null ) {
			return null;
		} else {
			E returnMe = head.value(); 
			head = head.next(); // move head down the list 
			return returnMe;
		} 
	}

	public E getFirst() {
		return head == null ? null : head.value(); 
	}
	
	public boolean contains(E value){ 
		Node finger = head; 

		while (finger != null && !finger.value().equals(value)) { 
			finger = finger.next(); 
		}
		
		return finger != null; 
	}
	
	public boolean recursiveContains(E value){
		return containsHelper(head, value);
	}
	
	private boolean containsHelper(Node current, E value){
		if( current == null ){
			return false;
		}else if( current.value().equals(value) ){
			return true;
		}else{
			return containsHelper(current.next(), value);
		}
	}

	public void clear() { 
		head = null; 
	}
	
	
	public void remove(E value){
		if( head.value().equals(value) ){
			head = head.next();
		}else{
			Node finger = head.next(); 
			Node prev = head;
		
			while (finger != null && !finger.value().equals(value)){
				prev = finger;
				finger = finger.next();
			}
			
			if( finger != null ){
				prev.setNext(finger.next());
			}
		}
	}
	
	public int indexOf(E value){
		int index = 0;
		
		Node finger = head;
		
		while( finger != null && !finger.value().equals(value) ){
			finger = finger.next();
			index++;
		}
		
		return index;
	}
	
	public void addLast(E value){
		if( head == null ){
			head = new Node(value);
		}else{
			Node finger = head;
			
			while( finger.next() != null ){
				finger = finger.next();
			}
			
			finger.setNext(new Node(value));
		}
	}
	
	public E get(int index){
		Node finger = head;
		
		for( int i = 0; i < index && finger != null; i++ ){
			finger = finger.next();
		}
		
		return finger == null ? null : finger.value();
	}

	private class Node{
		private E data; 
		private Node next; 
		
		public Node(E v, Node next) { 
			data = v; 
			this.next = next; 
		} 
		
		public Node(E v) { 
			this(v,null); 
		}
		
		public Node next() { 
			return next;
		} 
		
		public void setNext(Node next) { 
			this.next = next; 
		} 
		
		public E value() { 
			return data; 
		} 
		
		public void setValue(E value) { 
			data = value; 
		} 
		
		public String toString() { 
			return "<Node: "+value()+">"; 
		} 
	}
}