class GfG 
{
    
    static Queue<Tree> q = new LinkedList<>();
    
    public static Tree convert(Node head, Tree node) {
        
        if(head==null) return null;
        
        Tree t = new Tree(head.data);
        q.offer(t);
        head = head.next;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- >0){
                Tree tmp = q.peek();
                if(head!=null){
                    tmp.left = new Tree(head.data);
                    q.offer(tmp.left);
                    head = head.next;
                }
                if(head!=null){
                    tmp.right = new Tree(head.data);
                    q.offer(tmp.right);
                    head = head.next;
                }
                q.poll();
            }
        }
        
        
        return t;
    }
}  
