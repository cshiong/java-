import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/** Returns the next integer a in the in-order traversal of the given binary tree.
   * For example, given a binary tree below,
   *       4
   *      / \
   *     2   6
   *    / \ / \
   *   1  3 5  7
   * the outputs will be 1, 2, 3, 4, 5, 6, 7. 
   *  next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
   */ 
public class BSTIteratorInOrder {

	Stack <TreeNode> stack;
    public BSTIteratorInOrder(TreeNode root) {
    	
    	stack =  new Stack<TreeNode>();
    	pushLeftTree(root);
    }
    
    private void pushLeftTree(TreeNode root){
    	while(root != null){
    		stack.add(root);
    		root = root.left;
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
        pushLeftTree(node.right);
    	return node.val;
    }


}
