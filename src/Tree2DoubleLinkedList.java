
public class Tree2DoubleLinkedList {
	
	public void convertNode(TreeNode node, TreeNode lastInlist){
		if(node == null)
			return;
		if(node.left != null){
			convertNode(node.left, lastInlist);		
		}
		node.left = lastInlist;
		if(lastInlist != null )
			lastInlist.right = node;
		lastInlist = node;
		
		if(node.right != null){
			convertNode(node.right,lastInlist);
		}
		return;	
	}

	public TreeNode convert(TreeNode root){
		if(root == null)
			return null;
		TreeNode lastInlist = null;
		convertNode(root,lastInlist);
		TreeNode newHead = lastInlist;
		while(newHead !=null && newHead.left != null){
			newHead = newHead.left;
		}
		return newHead;
	}
}
