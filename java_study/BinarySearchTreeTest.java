class BinarySearchTree{
	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	Node root;
	
	public Node search(Node root, int key){
		if(root==null || root.data==key) return root;
		if(root.data>key) return search(root.left, key);
		return search(root.right, key);
	}
	
	
	public void insert(int data){
		root = insert(root, data); // 데이터 입력 후 루트가 바뀌는 것을 고려해서 재귀함수로 루트 반환 받기
	}
	
	public Node insert(Node root, int data){
		if(root==null){ // tree가 비어있거나, leaf node에 도달했을 때
			root = new Node(data);
			return root;
		}
		if(data < root.data) root.left = insert(root.left, data);
		else if(data > root.data) root.right = insert(root.right, data);
		return root;
	}
	
	public void delete(int data){
		root = delete(root, data); // 데이터 삭제 후 루트가 바뀌는 것을 고려해서 재귀함수로 루트 반환 받기
	}
	
	public Node delete(Node root, int data){
		if(root==null) return root;
		if(data < root.data) root.left = delete(root.left, data);
		else if (data > root.data) root.right = delete(root.right, data);
		else{
			if(root.left==null && root.right==null) return null; // 자식이 없다면 부모에게 null을 반환
			else if(root.left == null) return root.right; // 하나 있는 자식을 부모에게 반환
			else if(root.right == null) return root.left; // 하나 있는 자식을 부모에게 반환
			root.data = findMin(root.right); // 오른쪽 subtree에서 가장 작은 값(현재 노드의 다음 값)으로 대체
			root.right = delete(root.right, root.data); // 오른쪽 subtree에서 가장 작은 값을 지우기
		}
		return root;
	}
	
	int findMin(Node root){
		int min = root.data;
		while(root.left != null){
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	
	public void inorder(){
		inorder(root);
		System.out.println("");
	}
	
	private void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
}

public class BinarySearchTreeTest{
		public static void main(String[] args){
			BinarySearchTree tree = new BinarySearchTree();
			/*
				  4
				/   \
			   2	 6
			  / \   / \
			 1   3 5   7 */
			 
			tree.insert(4);
			tree.insert(2);
			tree.insert(1);
			tree.insert(3);
			tree.insert(6);
			tree.insert(5);
			tree.insert(7);
			
			tree.delete(7);
			tree.inorder();
		}
	}
