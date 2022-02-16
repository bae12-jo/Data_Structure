class Solution
{
    //Function to count nodes of a linked list.
    public static int getCount(Node head)
    {
        Node n = head;
        
        if(head==null)
            return 0;
            
        int count = 1;
        while(n.next != null)
        {
            n = n.next;
            count++;
        }
        return count;
    }
}
  
