import java.util.Stack;



/**
 * 
 */

/**
 * @author cboyd
 *
 */
public class LinkedlistPlayer {
	public static int carryOn=0;
	public static LNode HEAD;

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arg = {1,2,3,4,5,6,7,8,9};//,24,64,34,7};
		LNode head = new LNode(1);
		System.out.print(head.value +",");
		LNode tail = head;
	    for (int i=1;i<arg.length ;i++){
	    	LNode node = new LNode(arg[i]);
	    	System.out.print(node.value +",");
	    	tail.next = node;
	    	tail =node;
	    }
	    System.out.println();
	 //   printListBackwards(head);
	    
	    System.out.println();
	  /*  int[]arg2={9,3,7,9};
	    LNode head2=new LNode(9);
	    System.out.print(head2.value +",");
	    tail=head2;
	    for (int i=1;i<arg2.length ;i++){
	    	LNode node = new LNode(arg2[i]);
	    	System.out.print(node.value +",");
	    	tail.next = node;
	    	tail =node;
	    }
	    //set loop from 6
	  //  tail.next =head.next.next.next;
	    System.out.println();
	  // tail =reverseListRecursively(head,null);
       // LNode newHead = reverseList(head);
      LNode newHead= reverseNnodes(head, 3);
	   // LNode newHead=mergeZigZagTwoList(head,head2);
	   // LNode newHead=add_twoListWrapper(head,head2);
	   LNode tail1=newHead;
	   System.out.println("ReverseKNode:");*/
	  //  alternateReverse(head);
	  
	   //LNode newHead= pairSwap(head); //swapKthNodeAtEnd(head,1);//
	   //LNode newHead=swapKthNodeAtEnd(head,3);

		LNode newHead=spiltListToHalf(head);
	  // reorderList(head);
	  // LNode newHead = reverseMtoNNode(head,2,2);
	   while(newHead != null){
  		
      	System.out.print(newHead.value +",");
      	newHead = newHead.next;
      }
		System.out.println();
		while(head != null){

			System.out.print(head.value +",");
			head = head.next;
		}
      System.out.println(); 
	/*    
      LNode tail2 = skipThenReverseKNode(tail1, 2, false);
      System.out.println("skipThenReverseKNode:");
      while(tail2!=null){
    	  System.out.print(tail2.value+",");
    	  tail2=tail2.next ;
      }
      System.out.println();*/
	  // tail = mergeHalfSortedList(head);
      
     // tail=sortList(tail);
    
   /*  LNode reHead= revRecursive(tail1);
      while(reHead != null){
        		
        	System.out.print(reHead.value +",");
        	reHead = reHead.next;
        }*/
            
	  //  System.out.println("circle list size: " + listSize(head));
	}
	
	
	
	/*
	 * COOLESET SOLUTION
	 */
	  public static LNode revRecursive(LNode head) {
	        if (head == null)
	            return null;
	 
	        if (head.next == null)
	            return head;
	 
	        LNode newHead = revRecursive(head.next);
	        head.next.next = head;  //set the current.next to current previous one.
	        head.next = null;
	        
	        return newHead;
	    }
	
	public static LNode reverseList(LNode head){
		if (head == null){
			return null;
		}
		
		LNode current = head;
		LNode prev = null;
		LNode temp = null;
		
		while(current != null){
			temp = prev;
			prev =current;
			current = current.next;
			prev.next=temp;
		}
		
		return prev;
	}
	
	/*
	 * print the singly linked list from the tail to head
	 * can't modify the list 
	 */
	public static void printListBackwards(LNode head){
		if(head == null)
			return;
		if(head.next != null)
			printListBackwards(head.next);
		System.out.print(head.value+",");
	}
	
	/*
	 * sort a single linkedlist using insert sorting
	 * O(n^2)
	 */
public static LNode sortList(LNode head){
	if(head==null || head.next ==null)
		return head;
	boolean swaped =true;
	while(swaped){
		LNode prev=head;
		LNode current=head;
		swaped = false;
		while(current !=null){
			if(current.value >prev.value ){
				int temp=current.value ;
				current.value =prev.value ;
				prev.value =temp;
				swaped=true;
			}
			prev=current;
			current=current.next ;
		}
	}
	return head;
}
	/*
	 * 1,2,3,6,8,4,5,7,
       3,2,1,4,8,6,7,5,
	 */
	
	public static LNode reverseNnodes(LNode head, int size){
		if(head ==null||head.next == null)
			return head;
		LNode current = head;
		LNode prev = null;
		LNode temp = null;
		int count=0;
	
		while(current !=null && count<size){
			temp= prev;
			prev= current;
			current = current.next;
			//reverse
			prev.next = temp;
			count++;
		}
		
		//head now is the tail of the current loop
		 head.next=reverseNnodes(current,size);
		
	    return prev; //prev now is the last of the  loop but the head of the reversed list
		
		
	}
	
	public static LNode skipThenReverseKNode(LNode head, int size, boolean reverse){
		if(head == null||head.next ==null)
			return head;
		LNode current = head;
		LNode tail=null;
		LNode prev=null;
		int count = 0;
		if(!reverse){
			while(current != null && count <size){
			prev=current;
			current = current.next;
			count++;
			}
			tail = prev;
		}else{//reverse
			while(current!=null && count <size){
				LNode temp = prev;
				prev = current;
				current = current.next;
				prev.next= temp;  //reserve.
				count++;
			}
			tail=head;
		}
		
		tail.next= skipThenReverseKNode(current,size, reverse==true?false:true);
		
		if(reverse){
				return prev;					
		}else
			return head;
		
	}
	
	/*
	 * a list with two part of sorted node; merger to one sorted node;
	 * 
	 *  1-3-5-7-8-4-6-9-10
	 */
	
	public static LNode mergeHalfSortedList(LNode head){
		if(head==null || head.next == null)
			return head;
		LNode prev= head;
		LNode current= head.next;
		while(current!=null){
			if(current.value >=prev.value){
				prev= current;
				current = current.next;	
			}else{
			break;
			}
		}
		
		LNode breakPoint = current; //the start of the 2nd half
		LNode c1 = head;
		LNode c2 = current;
		if(c2.value>=c1.value){
			head= c1;
			c1=c1.next;
		}else{
			head = c2;
			c2 = c2.next;
		}	
		LNode tail = head;
		while(c1 != breakPoint && c2!=null){
			if(c1.value <= c2.value){
				tail.next = c1;
				tail = c1;
				c1 = c1.next;
			}else{
				tail.next = c2;
				tail =c2;
				c2 = c2.next;
			}	
		}
		
		if(c1 == breakPoint)
			tail.next = c2;//add the rest of the c2 part
		if(c2 == null){
			tail.next = c1;
			prev.next=null;//here is the key point need to set last.next of 1st halt to null
			
		}
		return head;
	}
	
	/*
	 * first: 1 2 3 4 NULL
       second: 5 6 7 NULL
       result: return the first list head with values like: 1 5 2 6 3 7 4 NULL
	 * 
	 */
	
	public static LNode mergeZigZagTwoList(LNode root1, LNode root2){
		   if( root1==null)
		     return root2;
		   if(root2==null)
		     return root1;
		   
		   LNode current1 = root1; 
		   LNode current2 = root2;  
		   LNode temp1=null;
		   LNode temp2=null;
		   while(current1 !=null && current2 !=null){
		       temp1=current1.next;
		        current1.next = current2; 
		         temp2=current2.next;
		         current2.next = temp1;
		         current1=temp1;
		         current2= temp2;
		        }
		     
		     return root1;
		          
		    }    
		   
	
	/* Given a singly linked list which may or may not contain loop 
	 * and loop may or may not start from the head node.
	 *  Count the number of elements in the linked list.
	 *  
	 *  1-4-5-7-3-6-8-0-7
	 * 
	 */
	
	public static int listSize(LNode head){
		int size=0;
		LNode fast=head;
		LNode slow=head;
		
		do{
			slow=slow.next;
			if(fast.next == null)//important to check this
				break;
			fast = fast.next.next;
		}while(slow!=null && fast!=null && fast!=slow);
		//the above will break either has loop or no loop, no loop will hit null,loop will hit slow==fast
		
		//check if has loop or not.
		if(fast == null||fast.next ==null||slow==null){ // no loop
			slow = head;
			while(slow!=null){
				size++;
				slow = slow.next ;
			}
			return size;
		}
		
		//loop exists.
		slow=head;
		//keep fast in the same place where it meet the slow at the first time;
		
		while(slow !=fast){
			slow=slow.next;
			fast=fast.next;
		}
		LNode nonCircleNode = head;
		LNode circleNode=slow.next;
		while(nonCircleNode !=slow){
			size++;
			nonCircleNode=nonCircleNode.next ;
		}
		while(circleNode != slow){
			size++;
			circleNode = circleNode.next;
		}
		return size+1; //this 1 is the slow point element since both loop not count it.
	}
	
	public static class LNode{
		int value;
		LNode next;
		
		public LNode(int v){
			value=v;
		}
		
	}

	/* two list of digit and add them and return the new list:
	 * e.g list1: 1,2,3,6,8
	 *     list2: 9,3,7,9
	 *      return:  2,1,7,5,7
	 * follwoing 3 funtions togehter achieve it.
	 */
	public static LNode add_twoListWrapper(LNode l1, LNode l2){
		if(l1==null)
			return l2;
		
		if(l2==null)
			return l1;
		int length1=length(l1);
		int length2=length(l2);
		int diff=0;
		LNode current=null;
		if(length1>length2){
			current=l1;
			diff=length1-length2;	
		}else if(length1<length2){
			current=l2;
			diff=length2-length1;
		}
		while(diff>0){
			current=current.next;
			diff--;
		}
		LNode shortListHead=length1>length2?l2:l1;
		LNode longerListHead=length1>length2?l1:l2;
		//use global variable to hold the changing carryOn
		LNode result=add_two_list(current,shortListHead);
		result= addRemainNodes(longerListHead,Math.abs(length1-length2)-1, result);
		return result;
		
		
}
	/* two list of digit and add them and return the new list:
	 * e.g list1: 1,2,3,6,8
	 *     list2: 9,3,7,9
	 *      return:  2,1,7,5,7
	 */

	public static LNode add_two_list(LNode c1, LNode c2){
		if(c1==null ||c2==null)
			return null;
		LNode result=null;
		if(c1.next !=null){  //move to the last node
			result=add_two_list(c1.next, c2.next );
		}
		int num=c1.value +c2.value +carryOn;//.flag;
		if(num>10)
			carryOn=1;
		
		else
			carryOn=0;
		LNode newHead = new LNode(num%10);
		newHead.next =result;
		result=newHead;
		return result;
	}
	public static int length(LNode l){
		int length=0;
		LNode current=l;
		
		while(current !=null){
			current=current.next ;
			length++;
	    }
		return length;
	}
	
	public static LNode addRemainNodes(LNode h, int size, LNode result){
		if(h==null)
			return result;
		if(size>0)
			result=addRemainNodes(h.next,--size, result);
		
	    int num = h.value + carryOn;//.flag;
	    if(num>10)
	    	//carryOn.flag =1;
	    	carryOn=1;
	    else
	    	//carryOn.flag=0;
	    	carryOn=0;
		LNode temp=new LNode(num%10);
		temp.next=result;
		result=temp;
		return result;
		
	}
	
	
	/*Given a linked list, reverse alternate nodes and append them to end of list. Extra allowed space is O(1) 
Examples
Input List:  1->2->3->4->5->6
Output List: 1->3->5->6->4->2
	 * 
	 */
	
	public static void alternateReverse(LNode head){
		if(head==null || head.next ==null || head.next.next==null)
			return;
		//initialize
		LNode tailHead=head.next;
		LNode current=tailHead.next;
		head.next=current;
		tailHead.next=null;
		LNode temp=null;
		while(current != null&& current.next !=null){
			
			if(current.next.next ==null){
				current=current.next;//move the current to the tail
				break;
			}
			temp=current.next;
			current.next=current.next.next;
			current=current.next;
			temp.next=tailHead;
			tailHead=temp;
		}
		current.next=tailHead;
	}
	
	/*
	 * Given a singly linked list, write a function to swap elements pairwise. For example, if 
	 * the linked list is 1->2->3->4->5->6->7 then the function should 
	 * change it to 2->1->4->3->6->5->7, 
	 */
	public static LNode pairSwap(LNode head){
		if(head==null || head.next==null)
			return null;
		//set the new head to the head.next
		LNode newHead=head.next;
		

		LNode prev=null;
		LNode current=head;
			
		while(current!=null && current.next!=null){
			LNode temp=current.next.next;
			current.next.next=current;
			if(prev != null)
				  prev.next=current.next;
			current.next=null;
			prev=current;
			current=temp;
			
		}
		//for odd number of list 
		if(current != null)
			prev.next =current;
		return newHead;
	}
	/*
	 * Swap Kth node from beginning with Kth node from end in a Linked List
	 * 1-3-5-6-2-9-7-4-10
	 * 1-3-7-6-2-9-5-4-10
	 * k=3
	 */
	
	/*
	 * use cases: 1: empty or 1 node list. 2, k==lenght/2 + 1 , 3, k > length, 4,k=0 k=1 , 5, other
	 */
	public static LNode swapKthNodeAtEnd(LNode head,int k){
		if(head ==null || head.next == null || k == 0){
			return head;
		}
		int count=0;
		LNode current=head,endK=null, endPrev=null;
	    while(current!= null) {
            count++;
            current = current.next;
            if (endK != null){
                endPrev = endK;
                endK = endK.next;
            }
            //this has to follow the above code otherwise wont get the right point
            if (count == k) { //start to get the kth node from the end point
                endK = head;
            }


	    }
	    //out of range or the k is the median 
	    if( (count < k) || (k == count/2 + 1))
	    	return head;
	    
	    LNode frontPrev=null,frontK=head,temp=null;    
	    count =0;
	    if( k == 1) {
            head = endK;
            endPrev.next = frontK;
            endK.next = frontK.next;
            frontK.next = null; //last one so set the next to null
            return head;
        }
	    	frontK =head.next;
	    	frontPrev=head;
	    	count=2;
	    	while(count < k){
	    	 count++;
	    	 frontK = frontK.next;
	    	 frontPrev = frontPrev.next;
	    	}
	    	//swap
	    	frontPrev.next=endK;
	    	endPrev.next=frontK;
	    	temp = endK.next;
	    	endK.next = frontK.next;
	    	frontK.next =temp;

	    return head;
	}
	
	
	public static LNode swapKthNodeAtEnd2(LNode head,int k){
		if(head == null || head.next ==null) 
			return head;
		
		int length=0;
		LNode current=head;
		while(current!=null){
			length++;
			current=current.next ;
		}
		if(length<k){
			return head;
		}
		int index=0;
		LNode front=head;
		LNode kend=head;
		LNode kendF=null;
		LNode kbegin=head;
		LNode kbeginF=null;
		//move the pointer in right position
		while(front!=null && front.next!=null){
			index++;
			if(index<k){
				kbeginF=kbegin;
				kbegin=kbegin.next;	 //move kfront pointer to kth node		
			}else{
				kendF=kend;
				kend=kend.next;  //start kend point
			}
			front=front.next;
		}
		//
		LNode temp=null;
		if(kbegin == head && kend !=head){//case k=1
			temp=kbegin.next;
			if (kendF!=null){
				kendF.next=kbegin;
			    kbegin.next =kend.next;
			}
			kend.next=temp;
			return kend;
			
		}
		 //if(kend == kbegin) do nothing
			
		if(kbeginF==kend){
			kendF.next=kbegin;
			temp=kbegin.next;
			kbegin.next=kend;
			kend.next=temp;
			
		}
		else if(kendF==kbegin){
			kbeginF.next=kend;
			temp=kend.next;
			kend.next=kbegin;
			kbegin.next=temp;
			
		}else{  //normal case
			temp=kend.next;
			kbeginF.next=kend;
			kend.next=kbegin.next;
			kendF.next=kbegin;
			kbegin.next=temp;
		}
		return head;
	}
	
	/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 */
	 public static void reorderList(LNode head) {
	        if ( head == null || head.next == null )
	            return;
	        Stack<LNode> tails = new Stack<LNode>() ;
	        
	        LNode tail = head;
	        while( tail != null){
	        	tails.add(tail);
	        	tail = tail.next;
	        }
	      
	        LNode current = head;
	        tail = tails.pop();
	         while( current !=null){
	        	 if( current == tail || current.next == tail)
	        		 break;
	        	 
	        	  LNode next = current.next;
	        	  current.next = tail;
	        	  tail.next = next;
	              current = next; 
	              if( tails.isEmpty())
	            	  break;
	              tail = tails.pop();
	        }
	         if( current == tail)
		           current.next= null;  
		        if( current.next == tail)
		          current.next.next = null;
	    }
	    
	/*
	  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1 -> 2 -> 3 -> 4 -> 5 -> |, m = 2 and n = 4, return 1 -> 4 -> 3 -> 2 -> 5 -> |.

Note: m and n are both 1-based and assume 1 <= m <= n <= list length.
	   */

    public static LNode reverseMtoNNode(LNode node, int m, int n){
        if( m == n) //no need to do anything.
            return node;
     LNode head = node;
        LNode tail = null;
        LNode current = node;
        m--;n--;
        while(current != null && m>0){
            tail = current;
            current = current.next;
            n--;
            m--;
        }
        LNode pre = current;
        current = current.next;
        n--;
        while(n>=0 && current != null){
            LNode temp = current.next;
            current.next = pre;
            pre =current;
            current = temp;
            n--;
        }
        if( tail != null) {
            LNode next = tail.next;
            tail.next = pre;
            next.next = current;
            return head;
        }else{
            head.next = current;
            return pre;
        }
    }

    /*
    Given a linked list, determine if it has a cycle in it.
     */

    public boolean hasCicrle(LNode head){
        return false;
    }

    public static LNode recursiveReveser(LNode head){
        if( head == null || head.next == null)
            return head;


        LNode newHead = recursiveReveser(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
	}

	public static  LNode  spiltListToHalf(LNode head){
		if(head == null || head.next == null)
			  return head;
		int size=0;
		LNode current = head;
		while(current!= null){
			size++;
			current = current.next;
		}
		 boolean even = size % 2==0 ? true:false;

		int start = even ==true? size/2:(size/2+1);
		size = 1;
		current = head;
		while(size < start ){
			size ++;
			current = current.next;
		}

		LNode  second = current.next;
		current.next = null;
		return second;



	}
}