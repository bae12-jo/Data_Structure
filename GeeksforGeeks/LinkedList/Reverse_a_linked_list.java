class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        if(head == null || head.next == null)
            return head;
            
        Node curr = head, next = head, prev=null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        
        head = prev;
        
        return head;
    }
}
