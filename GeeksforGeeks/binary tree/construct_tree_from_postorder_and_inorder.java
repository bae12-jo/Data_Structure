class GfG
{
    HashMap<Integer, Integer> inorder = new HashMap<>();
    
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        
        Node root = null;
        
        for(int i=0; i<in.length; i++){
            inorder.put(in[i], i);
        }
        
        return buildTreeUtil(in, 0, in.length-1, post, 0, post.length-1);
        
    }
    
    Node buildTreeUtil(int in[], int inStart, int inEnd, int po[], int poStart, int poEnd){
        
        if(inStart>inEnd || poStart>poEnd) return null;

        
        Node root = new Node(po[poEnd]);
        int inRoot = inorder.get(root.data);
        
        int numright = inEnd-inRoot;
        
        root.left = buildTreeUtil(in, inStart, inRoot-1, po, poStart, poEnd-numright-1);
        root.right = buildTreeUtil(in, inRoot+1, inEnd, po, poEnd-numright, poEnd-1);

        return root;
        
        
    }
}
