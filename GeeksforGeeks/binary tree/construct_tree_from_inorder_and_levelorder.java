class GfG
{
    
    Node buildTree(int inord[], int level[])
    {
        Node root = null;
        return buildTreeUtil(root, inord, level, 0, inord.length-1);
    }
    
    static Node buildTreeUtil(Node root, int inord[], int level[], int inStart, int inEnd){
        
        if(inStart>inEnd) return null;
        if(inStart==inEnd) return new Node(inord[inStart]);
        
        int index = 0;
        
        found: for(int i=0; i<level.length-1; i++){
            int levStart = level[i];
            for(int j=inStart; j<inEnd; j++){
                if(inord[j]==levStart){
                    root = new Node(levStart);
                    index = j;
                    break found;
                }
            }
        }
        
        root.left = buildTreeUtil(root, inord, level, inStart, index-1);
        root.right = buildTreeUtil(root, inord, level, index+1, inEnd);
        
        return root;
        
    }
    
   
}
