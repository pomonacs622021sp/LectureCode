
public class StackVQueue {
	public static void testStack(Stack<String> stack){
		stack.push("apple");
		stack.push("banana");
		stack.push("carrot");
		stack.push("daikon");
		
		while( !stack.empty() ){
			System.out.println(stack.pop());
		}
	}
	
	public static void testQueue(Queue<String> q){
		q.enqueue("apple");
		q.enqueue("banana");
		q.enqueue("carrot");
		q.enqueue("daikon");
		
		while( !q.empty() ){
			System.out.println(q.dequeue());
		}
	}
	
	public static void testLinear(Linear<String> l){
		l.add("apple");
		l.add("banana");
		l.add("carrot");
		l.add("daikon");
		
		while( !l.empty() ){
			System.out.println(l.remove());
		}
	}
	
	public static void main(String[] args) {
		Linear<String> l = new LinkedStack<String>();
		//Linear<String> l = new LinkedQueue<String>();
		
		testLinear(l);
	}
}
