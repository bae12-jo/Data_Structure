import java.util.*;

/* Driver Code */
class Node {
  
  int data;
  Node next;
  
  Node(int d){
    data = d;
    next = null;
  }
  
}

public class linkedlist {
  
  Node head;
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
      
      for (int i=1; i<n; i++){
        // each elements of linkedlist in order
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));
      }
      
      Solution ob=new Solution();
      ob.display(llist.head);
      System.out.println();
      
      t--;
    }
    
  }
  
}

/* Solution Code */
class Solution
{
    // Print elements of a linked list on console
    // head pointer input could be NULL as well
    // for empty list
    void display(Node head)
    {
        Node n = head;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
