import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


public class MTree {
	
	public static class MTreeNode{
		List<MTreeNode> children;
		int value;
		
		MTreeNode (int v){
			value=v;
			children= new ArrayList<MTreeNode>();
		}
		
	}
	

	public static void main(String[] args) {
		MTreeNode root=createTree(3,4);
		printTree(root);
		int max=maxLevel(root);
		System.out.println("max level:" + max);

	}
	
	public static MTreeNode createTree(int level,int max){
		MTreeNode root = new MTreeNode(level);
		Queue<MTreeNode> current= new LinkedList<MTreeNode>();
		current.add(root);
		Queue<MTreeNode> next = new LinkedList<MTreeNode>();
		Random ran = new Random();
		while(--level > 0){
		  while(!current.isEmpty()){
			MTreeNode node=current.poll();
			int x = ran.nextInt(max-1) + 1;
		    for(int i=0;i<x;i++){
		    	MTreeNode child= new MTreeNode(ran.nextInt(max));
		    	node.children.add(child);	
		    }
		    next.addAll(node.children);
		}
		current.addAll(next);
		next.clear();
		}
		return root;
	}
	
	public static void printTree(MTreeNode root){
		Queue<MTreeNode> current= new LinkedList<MTreeNode>();
		current.add(root);
		Queue<MTreeNode> next = new LinkedList<MTreeNode>();
		while(!current.isEmpty()){
			MTreeNode node=current.poll();
			System.out.print(node.value);
		    next.addAll(node.children);
		    if(current.isEmpty()){
		       System.out.println();
		       current.addAll(next);
		       next.clear();
		    }
		}
	}
 	
	//Apple phone screen question, I failed on it even i wrote this before. :(
	//find the level with the maximum node and return the nodes number of it
	public static int maxLevel(MTreeNode root){
		if(root == null){
			return 0;
		}
		int current=1,max=1,nextLevel=0;
		Queue<MTreeNode> queue= new LinkedList<MTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			MTreeNode node=queue.poll();
			current--;
			queue.addAll(node.children);
			nextLevel +=node.children.size();
			if(current==0){
				current = nextLevel;
				if(current>max)
					max=current;
				nextLevel=0;
			}
		}
		return max;
	}

}
