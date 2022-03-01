// https://www.youtube.com/watch?v=whVUYv0Leg0

import java.util.EmptyStackException;

/* pop, push, peek, isEmpty */

class Stack<T>{
	class Node<t>{
	
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> top;
	
	/* top - 3- 2- 1... 순서로 오른쪽에서 왼쪽으로 스택이 자라남 */
	
	public T pop(){
		if(top==null){
			throw new EmptyStackException();
		}
		
		T item = top.data;
		top = top.next; // 다음 주소를 top으로 만들어준다
		return item;
	}
	
	public void push(T item){
		Node<T> t = new Node<T>(item);
		t.next = top; // top 앞에 그 노드를 위치시키고.. 
		top = t; // 이제 그 노드가 top이 된다
	}
	
	public T peek() {
		if (top == null){
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
}



public class StackTest{
	public static void main(String[] args){
	
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	
	}
}
