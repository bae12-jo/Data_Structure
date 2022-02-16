/* drive code */

class Node {
  
  int data;
  Node next;
  
  Node(int d){
    data = d;
    next = null;
  }
  
}

class DeleteNode {
  
  Node head;

  void printList(Node node)
  {
    while (node!=null)
    {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }
	
  public void addToTheLast(Node node) {
    
      if (head==null) {
        head = node;
      } else {
        Node temp = head;
        while (temp.next != null) {
          temp = temp.next;
        }
        temp.next = node;
      }
    
  }
  
  public static void main(String args[]) {
  
    Scanner sc = new Scanner(System.in);
    // the number of testcases
    int t = sc.nextInt();
	  
    while (t>0) {
      
      // the number of elements of linkedlist
      int n = sc.nextInt();
      linkedlist ll = new linkedlist();
      
      // head - first element
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      llist.addToTheLast(head);
      
      for (int i=1; i<n; i++){
        // each elements of linkedlist in order
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));
      }
	    
      // given index - wants it to delete
      int x = sc.nextInt();
	    
      GFG g = new GFG();
	    
      Node result = g.deleteNode(llist.head, x);
      llist.printList(result);      
      t--;
	    
    }
    
  }
  
}


/* soluction code */
class GfG
{
    Node deleteNode(Node head, int x)
    {
	    Node n = head, prev = null;
	    int count = 1;
	    
	    if(n!=null && count==x){
	        head = n.next;
	        return head;
	    }
	    
	    while(n.next!=null && count!=x){
	        prev = n;
	        n = n.next;
	        count++;
	    }
	    
	    if(prev==null){
	        return head;
	    }
	    
	    prev.next = n.next;
    
        return head;
    }
}
