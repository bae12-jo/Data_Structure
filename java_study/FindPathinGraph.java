// https://www.youtube.com/watch?v=VHNOQZBXS0o&list=PLjSkJdbr_gFY8VgactUs6_Jc9Ke8cPzZP&index=7
// Graph에서 두 지점 찾기

import java.util.LinkedList;

class Graph{
	class Node{
		int data;
		boolean marked;
		LinkedList<Node> adjacent;
		Node(int data){
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}
	
	/* Graph 노드 초기화 */
	
	Node[] nodes;
	
	Graph (int size){
		nodes = new Node[size];
		for(int i=0; i<size; i++){
			nodes[i] = new Node(i);
		}
	}
	
	/* 노드 연결 (간선 추가) */
	
	void addEdge(int i1, int i2){
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if (!n2.adjacent.contains(n1)){
			n2.adjacent.add(n1);
		}
		if (!n1.adjacent.contains(n2)){
			n1.adjacent.add(n2);
		}
	}
	
	/* 모든 마킹 플래그가 false인지 확실히 하기 위함 (기본값이 false이긴 함) */
	void initMarks(){
		for(Node n: nodes){
			n.marked=false;
		}
	}
	
	/* 배열 번호로 호출하면 노드로 변환하는 함수 */
	boolean search(int i1, int i2){
		return search(nodes[i1], nodes[i2]);
	}
	
	/* BFS로 경로 탐색 */
	boolean search(Node start, Node end){
		initMarks();
		LinkedList<Node> q = new LinkedList<Node>(); // queue로 사용
		q.add(start);
		while(!q.isEmpty()){
			Node root = q.removeFirst();
			if(root==end) return true;
			for(Node n: root.adjacent){
				if(n.marked==false){
					n.marked=true;
					q.add(n);
				}
			}
		}
		return false;
	}
	
}

public class FindPathinGraph{
	public static void main(String[] args){
		
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		//g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		System.out.println(g.search(1,8));
	
	}
}
