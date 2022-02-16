// // Java program to swap two given nodes of a linked list

// class Node {
// 	int data;
// 	Node next;
// 	Node(int d)
// 	{
// 		data = d;
// 		next = null;
// 	}
// }

// class LinkedList {
// 	Node head; // head of list

// 	/* Function to swap Nodes x and y in linked list by
// 	changing links */
// 	public void swapNodes(int x, int y)
// 	{
// 		// Nothing to do if x and y are same
// 		if (x == y)
// 			return;

// 		// Search for x (keep track of prevX and CurrX)
// 		Node prevX = null, currX = head;
// 		while (currX != null && currX.data != x) {
// 			prevX = currX;
// 			currX = currX.next;
// 		}

// 		// Search for y (keep track of prevY and currY)
// 		Node prevY = null, currY = head;
// 		while (currY != null && currY.data != y) {
// 			prevY = currY;
// 			currY = currY.next;
// 		}

// 		// If either x or y is not present, nothing to do
// 		if (currX == null || currY == null)
// 			return;

// 		// If x is not head of linked list
// 		if (prevX != null)
// 			prevX.next = currY;
// 		else // make y the new head
// 			head = currY;

// 		// If y is not head of linked list
// 		if (prevY != null)
// 			prevY.next = currX;
// 		else // make x the new head
// 			head = currX;

// 		// Swap next pointers
// 		Node temp = currX.next;
// 		currX.next = currY.next;
// 		currY.next = temp;
// 	}

// 	/* Function to add Node at beginning of list. */
// 	public void push(int new_data)
// 	{
// 		/* 1. alloc the Node and put the data */
// 		Node new_Node = new Node(new_data);

// 		/* 2. Make next of new Node as head */
// 		new_Node.next = head;

// 		/* 3. Move the head to point to new Node */
// 		head = new_Node;
// 	}

// 	/* This function prints contents of linked list starting
// 	from the given Node */
// 	public void printList()
// 	{
// 		Node tNode = head;
// 		while (tNode != null) {
// 			System.out.print(tNode.data + " ");
// 			tNode = tNode.next;
// 		}
// 	}

// 	/* Driver program to test above function */
// 	public static void main(String[] args)
// 	{
// 		LinkedList llist = new LinkedList();

// 		/* The constructed linked list is:
// 			1->2->3->4->5->6->7 */
// 		llist.push(7);
// 		llist.push(6);
// 		llist.push(5);
// 		llist.push(4);
// 		llist.push(3);
// 		llist.push(2);
// 		llist.push(1);

// 		System.out.print(
// 			"\n Linked list before calling swapNodes() ");
// 		llist.printList();

// 		llist.swapNodes(4, 3);

// 		System.out.print(
// 			"\n Linked list after calling swapNodes() ");
// 		llist.printList();
// 	}
// }
// // This code is contributed by Rajat Mishra


// Java program to swap two given nodes of a linked list
public class Solution {

	// Represent a node of the singly linked list
	class Node {
		int data;
		Node next;

		public Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	// Represent the head and tail of the singly linked list
	public Node head = null;
	public Node tail = null;

	// addNode() will add a new node to the list
	public void addNode(int data)
	{
		// Create a new node
		Node newNode = new Node(data);

		// Checks if the list is empty
		if (head == null) {
			// If list is empty, both head and
			// tail will point to new node
			head = newNode;
			tail = newNode;
		}
		else {
			// newNode will be added after tail such that
			// tail's next will point to newNode
			tail.next = newNode;
			// newNode will become new tail of the list
			tail = newNode;
		}
	}

	// swap() will swap the given two nodes
	public void swap(int n1, int n2)
	{
		Node prevNode1 = null, prevNode2 = null,
			node1 = head, node2 = head;

		// Checks if list is empty
		if (head == null) {
			return;
		}

		// If n1 and n2 are equal, then
		// list will remain the same
		if (n1 == n2)
			return;

		// Search for node1
		while (node1 != null && node1.data != n1) {
			prevNode1 = node1;
			node1 = node1.next;
		}

		// Search for node2
		while (node2 != null && node2.data != n2) {
			prevNode2 = node2;
			node2 = node2.next;
		}

		if (node1 != null && node2 != null) {

			// If previous node to node1 is not null then,
			// it will point to node2
			if (prevNode1 != null)
				prevNode1.next = node2;
			else
				head = node2;

			// If previous node to node2 is not null then,
			// it will point to node1
			if (prevNode2 != null)
				prevNode2.next = node1;
			else
				head = node1;

			// Swaps the next nodes of node1 and node2
			Node temp = node1.next;
			node1.next = node2.next;
			node2.next = temp;
		}
		else {
			System.out.println("Swapping is not possible");
		}
	}

	// display() will display all the
	// nodes present in the list
	public void display()
	{
		// Node current will point to head
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {
			// Prints each node by incrementing pointer
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{

		Solution sList = new Solution();

		// Add nodes to the list
		sList.addNode(1);
		sList.addNode(2);
		sList.addNode(3);
		sList.addNode(4);
		sList.addNode(5);
		sList.addNode(6);
		sList.addNode(7);

		System.out.println("Original list: ");
		sList.display();

		// Swaps the node 2 with node 5
		sList.swap(6, 1);

		System.out.println("List after swapping nodes: ");
		sList.display();
	}
}

