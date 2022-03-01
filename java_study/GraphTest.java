// https://www.youtube.com/watch?v=_hxFgg7TLZQ&list=PLjSkJdbr_gFY8VgactUs6_Jc9Ke8cPzZP&index=6

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.EmptyStackException;


class Queue<T> {

	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void enqueue(T item) {
		Node<T> t = new Node<T>(item);
		
		if(last != null){
			last.next = t;
		}
		last = t;
		if(first == null){
			first = last;
		}
	}
	
	public T dequeue(){
		if(first == null){
			throw new NoSuchElementException();
		}
		
		T tmp = first.data;
		first = first.next;
		
		if(first == null){
			last = null;
		}
		
		return tmp;
		
	}
	
	public T peek(){
		if(first == null){
			throw new NoSuchElementException();
		}
		
		return first.data;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
}

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

class Graph{

	/* Graph의 Node 구현, adjacency list 사용 */
	class Node{
		int data;
		LinkedList<Node> adjacent; // 인접한 노드와의 관계 표현 (노드 개수의 2배)
		boolean marked; // 방문 여부
		
		Node(int data){ // 데이터를 받아서 방문 false로 초기화
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	/* Graph의 노드 생성 */
	Node[] nodes;
	Graph(int size){ // 편의를 위해서 사이즈 고정
		nodes = new Node[size];
		for(int i=0; i<size; i++){
			nodes[i] = new Node(i);
		}
	}
	
	/* 두 노드 간 관계성 저장 */
	void addEdge(int i1, int i2){
		Node n1 = nodes[i1]; // 받은 숫자를 인덱스로 사용 (인덱스와 데이터 같으므로)
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)){
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)){
			n2.adjacent.add(n1);
		}
	}
	
	/* stack을 이용한 dfs */
	void dfs(){ // 기본 호출 시 0부터 시작
		dfs(0);
	}
	
	void dfs(int index){
		Stack<Node> stack = new Stack<Node>();
		/* 루트를 스택에 추가 */
		Node root = nodes[index];
		stack.push(root); 
		root.marked = true;
		/* 스택이 빌 때까지 탐색 시작 */
		while(!stack.isEmpty()){
			Node r = stack.pop();
			for(Node n: r.adjacent){
				if(n.marked==false){
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	/* queue를 이용한 bfs */
	void bfs(){
		bfs(0);
	}
	void bfs(int index){
		Queue<Node> queue = new Queue<Node>();
		Node root = nodes[index];
		queue.enqueue(root);
		root.marked=true;
		while(!queue.isEmpty()){
			Node r = queue.dequeue();
			for(Node n: r.adjacent){
				if(n.marked==false){
					queue.enqueue(n);
					n.marked = true;
				}
			}
			visit(r);
		}
	}
	
	/* 재귀 호출는 노드를 받아야 함 */
	void dfsR(Node r){
		if(r==null) return;
		r.marked = true;
		visit(r);
		for(Node n: r.adjacent){
			if(n.marked==false){
				dfsR(n);
			}
		}
	}
	
	// 시작 위치를 지정하기 위한 메소드
	void dfsR(int index){
		Node n = nodes[index];
		dfsR(n);
	}
	
	// 시작 위치가 주어지지 않으면 0부터 시작
	void dfsR(){
		dfsR(0);
	}
	
	void visit(Node n){
		System.out.println(n.data + " ");
	}
}

public class GraphTest {
	public static void main(String[] args){
	
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);

		//g.dfs();
		g.dfsR(3);
		//g.bfs();
		
	}
}
