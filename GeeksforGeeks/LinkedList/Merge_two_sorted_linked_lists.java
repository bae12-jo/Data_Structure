class LinkedList
{

    Node sortedMerge(Node head1, Node head2) {

     Node head = new Node(0);
     Node result = head;
     
     while(true){
     
         if(head1 == null){
            result.next = head2;
            break;
         }
         if(head2 == null){
            result.next = head1;
            break;
             
         }
            
         if (head1.data <= head2.data){
            result.next = head1;
            head1 = head1.next;
         }
         else{
            result.next = head2;
            head2 = head2.next;
         }
         result = result.next;
         
     }
     return head.next;
   } 
}
