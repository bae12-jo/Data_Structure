
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
