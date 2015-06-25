import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;



public class TreeUtil
{
   // public static BTNode head=null;
	public static int counter=0;
    public TreeUtil()
    {
    }

    public static void printInOrder(TreeNode root)
    {
        if(root == null)
            return;
        if(root.left != null)
            printInOrder(root.left);
        System.out.println(root.val);
        if(root.right != null)
            printInOrder(root.right);
    }

    public static List<Integer> preorderTraversal(TreeNode root){
    	
    	 List<Integer> list = new ArrayList<Integer>();
    	 printPreOrder(root,list);
         return list;
    }
    public static void printPreOrder(TreeNode root,List<Integer> s)
    {
        if(root == null)
        {
            return;
        } else
        {
            s.add(root.val);
            printPreOrder(root.left,s);
            printPreOrder(root.right,s);
            return;
        }
    }
public static void printPostOrder(TreeNode root){
	if(root ==null)
		return;
		
	printPostOrder(root.left);
	printPostOrder(root.right);
	System.out.print(root.val+",");
	
}
    
    public static int maxDepth(TreeNode root){
	if(root == null)
		return 0;
	return 1+Math.max(maxDepth(root.left ), maxDepth(root.right ));
}

	public static TreeNode createBinaryTree(int arr[])
    {
        TreeNode root = new TreeNode(arr[0]);
       
         int i=1;
        while(i<arr.length ){
            
        	insertBT(root, new TreeNode(arr[i++]));
           
        }
   
        return root;
    }

    public static void insertBT(TreeNode btnode, TreeNode btnode1)
    {  
    	if(btnode == null)
    		return ;
    	TreeNode current = btnode;
    	while(current !=null){
    	if(current.left ==null){
    		current.left =btnode1;
    		break;
    	}
    	else if(current.right ==null){
    		current.right=btnode1;
    	    break;
    	}
    	else{
    		Random r= new Random();
    		if(r.nextBoolean())
    			current=current.left;
    		else
    			current=current.right ;
    	}
    	}
    	
    }
    
   
    
    public static void printTreeVetically(List<TreeNode> currentLevel, List<TreeNode> nextLevel){
    	if(currentLevel == null || currentLevel.size()==0)
    		return;
    	
    	if(nextLevel==null)
    		nextLevel = new ArrayList<TreeNode>();
    	else if( nextLevel.size()>0)
    		System.out.println("Somethig wrong !");
    	//	nextLevel.clear();
    	while(currentLevel.size()>0){
    		TreeNode n= currentLevel.remove(0);
    		System.out.print(n.val);
    		if(n.left !=null)
    		   nextLevel.add(n.left);
    		if(n.right!=null)
    		  nextLevel.add(n.right);
    		System.out.print(",");
    	}
    	System.out.println(); //read for next level
    	currentLevel.clear();
    	printTreeVetically(nextLevel,currentLevel);
    }
    
    public static void printTreeZigZag(Stack<TreeNode> stack, Stack<TreeNode> nextStack,boolean rightfirst){
         if(stack==null ||stack.isEmpty()){
        	 return;
         }
         if(nextStack==null)
        	 nextStack= new Stack<TreeNode>();
         while(!stack.isEmpty()){
        	 TreeNode n=stack.pop();
        	 System.out.print(n.val + ",");
        	 if(stack.isEmpty())
        		 System.out.println();
        	 if(rightfirst){//next level is opposite
        		 if(n.left !=null)
        			 nextStack.push(n.left);
        		 if(n.right !=null)
        			 nextStack.push(n.right );
        	 }else{
        		 if(n.right !=null)
        			 nextStack.push(n.right);
        		 if(n.left !=null)
        			 nextStack.push(n.left);
        	 }		 	 
         }
         
         printTreeZigZag(nextStack,stack, rightfirst?false:true) ;
    }
    
    
    //print tree's right view: 
    //right view is looking from right size and all the visible nodes.
    public static void printRightView(TreeNode root,int currentLevel,List<TreeNode> view){
    	if(root==null)
    		return;
    	if(currentLevel > view.size()){
    		view.add(root);
    		currentLevel++;
    	}
    	printRightView(root.right,currentLevel, view);
    	printRightView(root.left ,currentLevel, view);
    	
    }
   
    public static int size(TreeNode root){
    	if(root==null)
    		return 0;
    		
    	return (size(root.left )+ size(root.right)+ 1);
    	
    }
    
    //following are for BST:
  
    
    public static TreeNode insert(TreeNode root, int a){
    	if( root == null){
    		return new TreeNode(a);
    	}
    	if( a < root.val){
    		root.left = insert(root.left, a);
    	}
    	if( a > root.val){
    		root.right = insert(root.right, a);
    	}
    	return root;
    	
    }
       
    public static TreeNode delete(TreeNode root, int a){
    	if(root ==null )  //check if the tree is empty tree
    		return root;
    	
    	if(a < root.val){
    		
    		root.left =delete(root.left ,a);		
    	}
       else if(a > root.val){
       
    	    root.right =delete(root.right ,a);
       }else{ //this is node to be deleted 
           if(root.right ==null)
    	         return root.left ;
    	if(root.left ==null)
    		return root.right;		
    	 
    	// case: x has both children
    	//set the right min of its right subtree node's val to this node's val and delete min node.
    		 
    	    TreeNode t= min(root.right);
    	    root.val =t.val;
    	    root.right =delete(root.right,t.val);//delete right subtree's min node ;
       }
    	return root;
    }
    
    /*
     * floor the largest node <= key in BST
     */
    public static TreeNode floor(TreeNode root, int key){
    	if( root == null || root.val == key){
    		return root;
    	}
    	if( key < root.val){
    		return floor(root.left , key);
    	}
    	//else key > root.val, need to check if any node on the right subtree 
    	//is bigger the the root,
        TreeNode f = floor (root.right , key);
         if( f != null)
        	  return f;
         else
        	 return root;
    	
    }
    /*
     * ceiling the smallest node >= key in BST
     * 
     */
    
    public static TreeNode ceiling(TreeNode root, int key){
    	if( root == null || root.val == key)
    		return root;
    	
    	 if ( root.val < key){
        	 return ceiling( root.right, key);	
        }
    	TreeNode c = ceiling(root.left ,key);
     	if( c != null )
     		return c;
     	else
     		return root;  		
     	
    }
    /*
     * how many nodes < key
     */
    
    public static int rank(TreeNode root, int key){
    	if( root == null)
    		return 0;
    	if( root.val > key)
    		return rank(root.left,key);
    	else if( root.val < key){
    		return 1+ size(root.left) + rank(root.right,key);
    	}else{
    		return size(root.left);
    	}
    }
    
    /*
     * get the kth node in a binary search tree
     *  in an incremental order of values
     *  solution with golbal variable
     */
    public static TreeNode getKthNode(TreeNode root, int k){
    	if(root==null || k==0){
    		return null;
    	}
	   TreeNode kNode= null;
	  if( root.left !=null)
	     kNode=getKthNode(root.left ,k);
	   if(counter==k)
	    	return kNode;
	   counter++;
	  if(kNode!=null && root.right !=null)
	    kNode=getKthNode(root.right ,k);
	  return kNode;
    }
    
    /*
     * no global variable not work yet
     */
    public static TreeNode getKthNode2(TreeNode root, Integer k){
    	if(root==null ){
    		return root;
    	}
       
	   // TreeNode knote =null;
        if(root.left != null)
             getKthNode2(root.left,k);
	    k--;
	    if( k == 0)
	        return root;
        if( root.right != null)
	        getKthNode2(root.right ,k);
	    return null;
    }


public static void printKthNode(TreeNode root, int k){
	if (root == null)
		return ;	
	
	printKthNode(root.left ,k);
	if(++counter==k){ //counter is global variable
		System.out.println( k +"th node is: "+ root.val);
		return;
	}
	printKthNode(root.right ,k);
}
		
	 
   
    public  static TreeNode min(TreeNode root){
    	if(root == null)
    		return null;
    	/*BTNode current = root;
    	while(current.left !=null){
    		current=current.left;
    	}
    	return current;	*/
    	if(root.left ==null) return root;
    	return min(root.left );
    }
    
    public static TreeNode deleteMin(TreeNode root){
    	if(root.left ==null) return root.right;
    	root.left = deleteMin(root.left);
    	return root;
    }
    
    public static TreeNode createBST(int[] a , int l, int r){
    	if(r-l<0)
    		return null;
    	int mid= l+(r-l)/2;
    	TreeNode node = new TreeNode(a[mid]);
    	node.left = createBST(a, l, mid-1);
    	node.right=createBST(a,mid+1,r);
    	return node;
    }
   
    
   
    //following is the best solution for it. 
   // BST to double linked list
    public static void treeToList(TreeNode root, TreeNode last, TreeNode head){
    	if(root == null)
    		return ;
    	if(root.left!=null)
    		treeToList(root.left,last,head );
    	
    	if(last != null){
    		last.right= root; //root is left most of subtree
    	}else{
    		head = root; //root is left most of whole tree
    	}
        root.left = last;
    	last = root;
    	
    	if(root.right!=null)
    	  treeToList(root.right,last, head);
    }
    
    /*
     * preorder;
     */
    public static void flatten(TreeNode root, List<TreeNode> list){
    	 if( root == null)
             return;
         list.add(root);
         flatten(root.left,list);
         flatten(root.right,list);
    }
    
    
    
    
    //always find the previous one in the ordered list
    //and set its right point to this points
    public static TreeNode convert2List(TreeNode root){
    	if(root==null)
    		return root;
    	if(root.left!=null){
    		TreeNode leftTreeNode = convert2List(root.left);
    		//leftTreeNOde is the left most node;
    		while(leftTreeNode.right !=null){//get rightest node of the subtree leftTreeNode
    			leftTreeNode= leftTreeNode.right;
    		}
    		leftTreeNode.right =root;
    		root.left=leftTreeNode;	
    	}
    	if(root.right !=null){
    		TreeNode rightTreeNode = convert2List(root.right);
    		while(rightTreeNode.left !=null){
    			rightTreeNode =rightTreeNode.left;
    		}
    		rightTreeNode.left =root;
    		root.right =rightTreeNode;
    	}
    	return root;
    }
    
    public static TreeNode convert2ListWrapper(TreeNode root){
    	TreeNode head = convert2List(root);
    	while(head!=null && head.left !=null){
    		head=head.left;
    	}
    	return head;
    }
    
   
    
}
