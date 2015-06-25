import java.util.Stack;

/** Returns the next integer a in the post-order traversal of the given binary tree.
   * For example, given a binary tree below,
   *       4
   *      / \
   *     2   6
   *    / \ / \
   *   1  3 5  7
   * the outputs will be 1, 3,2,5, 7,6,4.
   *  next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
   */ 
public class BSTIteratorPostOrder {

	Stack <TreeNode> stack;
    public BSTIteratorPostOrder(TreeNode root) {
    	
    	stack =  new Stack<TreeNode>();
        findNextLeaf(root);
    }
    /* put the first leaf on top of the stack

     */
    private void findNextLeaf(TreeNode root){
    	while(root != null){
    		stack.add(root);
            if(root.left != null)
    		  root = root.left;
            else
                root = root.right;
    	}	
		
    }
    

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty() )
        	return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode node = stack.pop();
        if(hasNext()){
            TreeNode next = stack.peek();
            if( next.left == node){
                findNextLeaf(next.right);
            }
        }
    	return node.val;
    }

}
