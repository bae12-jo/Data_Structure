class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		
		/* constructor */
		Node(int data){
			this.data = data;
		}
	}
		
	/* member variables */
	Node root;
	
	/* method */
	// 배열을 글로벌로 선언하면? 배열이 여러개 들어오는 걸 감당할 수 없음..
	public void makeTree(int[] a){ // 재귀호출에 필요한 데이터를 던져주는 역할
		root = makeTreeR(a, 0, a.length-1);
	}
	
	public Node makeTreeR(int[] a, int start, int end){
		if(start>end) return null; // 끝나는 시점을 정의해주는 건 재귀에서 제일 중요
		int mid = (start+end)/2;
		Node node = new Node(a[mid]);
		node.left = makeTreeR(a, start, mid-1);
		node.right = makeTreeR(a, mid+1, end);
		return node;
	}
	
	public void searchBTree(Node n, int find){
		if(find<n.data){
			System.out.println("Data is less than " + n.data);
			searchBTree(n.left, find);
		}else if(find>n.data){
			System.out.println("Data is greater than " + n.data);
			searchBTree(n.right, find);
		}else{
			System.out.println("Data Found!");
		}
	}
}

public class BST_test {
	public static void main(String[] args){
		
		int[] a = new int[10];
		for(int i=0;i <a.length; i++){
			a[i]=i;
		}
		
		Tree t = new Tree();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
	
	}
}
