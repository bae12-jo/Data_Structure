// https://www.youtube.com/watch?v=W3jNbNGyjMs

import java.util.NoSuchElementException;

/* queue object class */
class Queue<T> {

	/* node object class */
	class Node<T> {
		private T data;
		private Node<T> next;
	
		/* constructor */
		public Node(T data){
			this.data = data;
		}
	}
	
	/* member variables */
	private Node<T> first;
	private Node<T> last;
	
	/* method - add, remove, peek, isEmpty */
	public void add(T item) {
		Node<T> t = new Node<T>(item);
		
		// when queue has more than two data
		if (last != null){
			last.next = t;
		}
		// when queue has only one data
		last = t;
		// when queue is empty
		if (first == null) {
			first = t;
		}
	}
	
	public T remove(){
		// when queue is empty
		if(first == null){
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		
		// when queue is empty after remove first node
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if (first == null){
			throw new NoSuchElementException();
		}		
		return first.data;	
	}
	
	public boolean isEmpty(){
		return first == null;
	}	
	
}

public class DataStructure_Queue {
	public static void main(String[] args){
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
	}
}
