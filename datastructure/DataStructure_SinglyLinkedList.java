// https://www.youtube.com/watch?v=C1SDkdPvQPA


/* Node object class */
class Node {
	int data;
	Node next = null;
	
	/* constructor */
	Node(int d){
		this.data = d;
	}	

	/* method - append, delete, */
	public void append(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}

	public void delete(int d){
		Node n = this;
		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	public void retrieve() {
		Node n = this;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}

public class DataStructure_SinglyLinkedList{
	public static void main(String[] args){
		// head is first data and in same time, it is head of whole list
		// so, we can remove head
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(3);
		head.delete(2);
		head.retrieve();
	}
}
