import java.util.*;


public class BTreePlayer {

	public static int counter=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int b[]={9,5,7,4,1,3};
/*        System.out.println(Arrays.toString(b));
        TreeNode root=new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left=left;
        root.right = right;*/
        TreeNode root=new TreeNode(7);
        for(int i=0; i<b.length ;i++){
        	root=TreeUtil.insert(root, b[i]);
        }
        TreeUtil.printInOrder(root);
       /* BTNode root2=array2Tree(b,0,b.length -1);
        List<BTNode> currentLevel= new ArrayList<BTNode>();
        currentLevel.add(root2);
       
        TreeUtil.printTreeVetically(currentLevel, null)	;
        TreeUtil.printKthNode(root2, 3);*/
      /*  BSTIterator bIterator= new BSTIterator(root);
        while(bIterator.hasNext() ){
        	System.out.println(bIterator.next());
        }*/
      //  System.out.println("Kth node is: " + TreeUtil.getKthNode(root2, 4).value);
	 /* List<TreeNode> list = new LinkedList<TreeNode>();
	  TreeUtil.flatten(root, list);
       for (TreeNode node:list){
    	   System.out.print(node.val+",");
       }*/
//        SumRoot2LeafNumber sum = new SumRoot2LeafNumber();
//        int v = sum.sumNumbers(root);
        TreeNode v = TreeUtil.getKthNode2(root,4);   //.ceiling(root,6);
        System.out.println("sum: " +v.val);
	}

	/*
	 * convert a sorted array to BST
	 */
	
	public static TreeNode array2Tree(int[]a, int low, int high){
		if(low>high)
			return null;
		int mid=low+(high-low)/2;
		TreeNode root=new TreeNode(a[mid]);
		root.left =array2Tree(a,low,mid-1);
		root.right =array2Tree(a,mid+1,high);
		return root;
	}

   /* left to right , balance tree */
    class Node {
        Node left;
        Node right;
        String value;
        public Node(String val){
            value = val;
        }
    }

/*root is the first one in the array. from left to right */

    public Node createBinaryTree(String[] values){
        if( values == null)
            return null;
        Node root = new Node(values[0]);
        Queue<Node> treeNodes = new LinkedList<Node>();
        treeNodes.add(root);
        int level =  values.length/2;
        for( int i = 0; i <level; i++ ){

            Node parent = treeNodes.remove();
            int left = 2*i + 1;
            int right = 2*i + 2;

            if(left < values.length){
                parent.left= new Node(values[left]);
                treeNodes.add(parent.left);
            }
            if(right< values.length){

                parent.right = new Node(values[right]);
                treeNodes.add(parent.right);
            }

        }

        return root;

    }
	
	/*
	 * are two BTree identical(both value and structure are the same)
	 */
	
	public static boolean identicalTree(TreeNode root1, TreeNode root2){
		if( root1 == null && root2 == null)
			return true;
		
		if(root1 != null && root2 != null){
		  return root1.val == root2.val && 
		      identicalTree(root1.left,root2.left) &&
	          identicalTree(root1.right,root2.right);
         }else{
        	 return false;
         }
	}

	
	/*
	 * printout all the kth node from the leaf in a binary tree
	 */
	
	/*public BTNode printKthNode(BTNode root, int k){
		if(root == null)
			return null;
		BTNode kNode=null;
		if(root.left !=null){
			kNode = printKthNode(root.left ,k);	
		}
		if(counter != k){
			counter++;
			 if(root.right !=null){
				   kNode=printKthNode(root.right ,k);
			     }			
		}else{
			System.out.println(kNode.value );
		     return null;
    	}
     }*/
}