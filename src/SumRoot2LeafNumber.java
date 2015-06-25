import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * 
 */

public class SumRoot2LeafNumber {
	
public int sumNumbers(TreeNode root) {
	  
	  List<Integer> r2l = new LinkedList<Integer>();
	  List<List<Integer>> list = new LinkedList<List<Integer>>();
	  getAllRoot2LeafTree(root, r2l, list);
	  return getSum(list);
    }
    
    
    private void getAllRoot2LeafTree(TreeNode root, List<Integer> r2l, List<List<Integer>> list){
        if(root == null)
            return ;
            
        r2l.add(root.val);
        if( root.left == null && root.right == null){ //leaf
            List<Integer> r2lcopy = new LinkedList<Integer>(r2l);
           // ((LinkedList<Integer>) r2l).removeLast(); should not remove here if need back multiple level
            list.add(r2lcopy);
            return;
        }
        
        if(root.left != null){
        	getAllRoot2LeafTree(root.left, r2l,list);
        	  ((LinkedList<Integer>) r2l).removeLast();
        }
        if(root.right != null)   {
        	getAllRoot2LeafTree(root.right,r2l,list);
           ((LinkedList<Integer>) r2l).removeLast();
        }
        return;
    }

    private int getSum(List<List<Integer>> list){
    	int sum = 0;
    	for(List l: list){
    		sum += list2Integer(l);
    	}
    	return sum;
    }
    
    private int list2Integer(List<Integer> number){
    	int value = 0;
    	for(Integer v: number){
    		if( v<0 || v>9){
    			System.out.println("invalid value");
    		}
    		value = value*10 + v;
    	}
    	return value;
    }
}
