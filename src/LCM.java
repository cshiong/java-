import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;



public class LCM
{

  

    public static void main(String args[])
    {
        int a[]={3,4,5,6,7,8,9,10,11,12,13};
        //int b[]={13,12,11,10,9,8,7,6,5,4,3};
        
        System.out.println(Arrays.toString(a));
        int mid=a.length/2;
        TreeNode root = new TreeNode(a[mid]);
        root.left =TreeUtil.createBST(a, 0, mid-1);
        root.right =TreeUtil.createBST(a, mid+1, a.length -1);
      
        List<TreeNode> currentL= new ArrayList<TreeNode>();
        currentL.add(root);
       /* System.out.println(Arrays.toString(b));
        int mid2=b.length/2;
        BTNode root2 = new BTNode(b[mid2]);
        root2.left =TreeUtil.createBST(b, 0, mid2-1);
        root2.right =TreeUtil.createBST(b, mid2+1, b.length -1);     
        List<BTNode> currentL2= new ArrayList<BTNode>();
        currentL2.add(root2);*/
        TreeUtil.printTreeVetically(currentL, null);
        TreeUtil.delete(root, 9);
        System.out.println("AFter delete");
        currentL.clear();
        currentL.add(root);
        TreeUtil.printTreeVetically(currentL, null);
       
        Stack<TreeNode> stack= new Stack<TreeNode>();
        stack.push(root);
        TreeUtil.printTreeZigZag(stack, null, true);
       // TreeUtil.printPostOrder(root);
        System.out.println();
        TreeNode prev=null;
      //  BTNode head=TreeUtil.BST2DoubleLinkedListWrapper(root);
        List<TreeNode> view = new ArrayList<TreeNode>();
       TreeUtil.printRightView(root, 1, view);
        if (view!=null ){
        	Iterator<TreeNode> it=view.iterator();
        	while(it.hasNext())
    	   System.out.print(it.next().val+",");
       }
        System.out.println();
        TreeNode head=TreeUtil.convert2ListWrapper(root);
       
        while(head !=null ){
        	System.out.print(head.val +",");
        	head = head.right ;
        }
        
      
        
       // TreeUtil.printTreeVetically(currentL2, null);
       // TreeUtil.printInOrder(root);
       // TreeUtil.printInOrder(root2);
        //System.out.println("mirror tress:" + mirrorTrees(root,root2));
    	//TreeUtil.delete(root, 5);
    	/*currentL.add(root);
    	TreeUtil.printTreeVetically(currentL, null);*/
        /*int arr[] = {
            16, 12, 18, 19, 13, 8, 6, 4
        };
        BTNode root = TreeUtil.createBinaryTree(arr);
        TreeUtil.printPreOrder(root);
        BTNode lcm= findLCM(root, 6, 4);
        System.out.println("LCM is: "+ lcm.value );
        int deepth = deepth(root);
        System.out.println("Deepth: " + deepth);
        int size = size(root);
        System.out.println("Size :"  + size);
        */
    }


   public static TreeNode findLCM(TreeNode root,int l, int r){
	if( root ==null || root.val  == l || root.val == r)
		  return root;
	
	TreeNode l_lcm = findLCM(root.left,l,r);
	TreeNode r_lcm = findLCM(root.right ,l, r);
	
	if(l_lcm !=null && r_lcm!= null)
		return root;
	return l_lcm!=null? l_lcm:r_lcm;
}
   
   //BST lcm
   public static TreeNode findLCM4BST(TreeNode root, int a, int b){
	   if(root == null)
		   return null;
	   if(a > root.val && b > root.val){
		  return findLCM4BST(root.right, a, b);
	   }
	   if ( a < root.val && b < root.val ){
		   return findLCM4BST(root.left, a, b);
	   }
	   return root;
   }
   
   public static int deepth(TreeNode root){
	   if(root == null)
		   return 0;
	   
	   int left = deepth(root.left);
	   int right = deepth(root.right);
	   
	   return Math.max(left, right)+1;
			   
   }
   
   public static int size(TreeNode root){
   	if(root==null)
   		return 0;
   		
   	return (size(root.left )+ size(root.right)+ 1);
   	
   }
   
   public static boolean mirrorTrees(TreeNode root1, TreeNode root2){
	  if(root1==null&& root2==null)
		  return true;
	  if(root1==null ||root2==null)
		  return false;
	   
	   if(root1.val !=root2.val)
		   return false;
	   //mirror is opposite nodes
	   return (mirrorTrees(root1.left , root2.right ) && 
			   mirrorTrees(root1.right ,root2.left ));
   }
}