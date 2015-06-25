import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NormalTree {

	public static class TreeNode{
		public List<TreeNode> children;
		public int value;
		
		public TreeNode(){
			
		}
		public TreeNode(int v){
			value=v;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode();
		
		
		Queue<TreeNode> queue= new LinkedList<TreeNode>();
		int currentLevelsize=1,nextLevelsize=0,maxLevel=0,level=0;
		int maxNode =1;
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node =queue.remove();
			queue.addAll(node.children);
			nextLevelsize +=node.children.size();
			if(--currentLevelsize==0){
				level++;
				currentLevelsize = nextLevelsize;
				nextLevelsize=0;
				if(currentLevelsize>maxNode){
					maxNode=currentLevelsize;
					maxLevel=level;
				}	
			}
		System.out.println("max size level: " + maxLevel);
	}
	}


}
