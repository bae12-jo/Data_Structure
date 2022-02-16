/* driver code */
import java.util.*;
import java.io.*;

class Node {
  
  int data;
  Node next;
  
  Node(int d){
    data = d;
    next = null;
  }
  
}

class GFG {
  
  static void printList(Node node)
  {
    while (node!=null)
    {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }
  
  public static void main(String args[]) throws IOException {
  
    Scanner sc = new Scanner(System.in);
    // the number of testcases
    int t = sc.nextInt();
    while (t>0) {
      
      // the number of elements of linkedlist
      int n = sc.nextInt();
      Node head = null;
      
      for (int i=0; i<n; i++){
        // each elements of linkedlis
        int value = sc.nextInt();
        int indicator = sc.nextInt();
        
        Solution ob = new Solution();
        if(indicator == 0)
          head = ob.insertAtBeginning(head, value);
        else
          head = ob.insertAtEnd(head, value);
      }
      
      printList(head);      
      t--;
    }
    
  }
  
}




/* soluction code */
class Solution
{
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        Node n = new Node(x);
        if (head == null){
            head = n;
        } else {
            n.next = head;
            head = n;
        }
        return head;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        Node n = new Node(x);
        if (head == null) {
            head = n;
        } else {
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n;
        }
        return head;
    }
}
