// https://www.youtube.com/watch?v=IrXYr7T8u_s

/* LinkedList object class */
class LinkedList {
	Node header;
	
	/* first node is only used as header */
	static class Node {
		int data;
		Node next = null;
	}
	
	/* constructor */
	LinkedList(){
		header = new Node();
	}
	
	/* method - append, delete, */
	void append(int d) {
		Node end = new Node();
		end.data = d;
		Node n = header;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}

	void delete(int d){
		Node n = header;
		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	void retrieve() {
		Node n = header.next;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
}

public class DataStructure_LinkedListNode {
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		ll.delete(1);
		ll.retrieve();
	}
}
