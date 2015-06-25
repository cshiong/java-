

public class MyLinkedList {

	
	public static class Node{
		int data;
		Node next;
		public Node (int a){
			data=a;
			next=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = createList2(9);
		printList(head);
		Node prev=null;
		//Node newHead=reverserListR(head,prev);
		//Node newHead=kAltReverse(head,prev,2,false);
		//Node newHead = altReverseAddend(head);
		Node newHead = pairSwap(head);
		System.out.println("after call reverserList()");
		printList(newHead);
		

	}
    public static void printList(Node head){
    	Node current = head;
		while (current != null){
			System.out.print(current.data +",");
			current = current.next;
		}
		System.out.println();
    }
	
	//practice recursive function.
	public static Node createList(int length){
		if(length==0){
			return null;
		}
		Node node= new Node(97 % length);
		length--;
		node.next = createList(length);
		return node;
	}
	public static Node createList2(int length){
		
		Node head = new Node(2);
		Node current=head;
		
		for (int i=2;i<length; i++){
			current.next= new Node(i+1);
			current=current.next ;	
		}
		return head;
	}
	
	public static Node reverserList(Node head){
		Node current= head;
		Node prev=null;
		Node temp=null;
		while(current !=null){
			temp = current.next;
			current.next = prev;
			prev=current;
			current=temp;	
		}
		return prev;
	}
	
	//good one for recursive solution
	public static Node reverserListR(Node head,Node prev){
		if(head==null)
			return head;
		if(head.next==null){
			head.next = prev;
			 return head;	
		}
		//always returns the newHead, other part will recursive.
		Node newHead = reverserListR(head.next,head);
		head.next = prev;
		return newHead;		
	}
	//not good sloution, since the newHead not set need use global variable for newhead
	public static void reverserListR(Node head,Node prev,Node newHead){
		if(head.next==null){
			head.next = prev;
			newHead=head;
			return;
			
		}
		Node temp = head.next;
		head.next = prev;
		prev=head;
		head=temp;	
		reverserListR(head,prev,newHead);
			
	}
	
	/*
	 * Example:
Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL. 
	 */
	public static Node kAltReverse(Node head, Node prev,int k,boolean reverse){
		if(head ==null || head.next ==null)
			return head;
		int index=0;
		Node current= head,subHead=head,subTail=null;
		if(reverse){
			while(index < k && current!=null){
				Node temp = current.next;
				current.next = prev;
				prev=current;
				current = temp;
				index++;
			}
			subHead = prev;
			subTail = head;			
		}else{
			while(index<k && current!=null){
				prev=current;
				current = current.next;
				index++;
			}
			subTail = prev;
			subHead= head;
		}
		reverse = reverse?false:true;
		subTail.next=kAltReverse(current,subTail,k,reverse);
		return subHead;
	}
	
	/*
	 * reverse altnative node and put them on the end
	 * e.g input 1-2-3-4-5-6-7
	 * output   1-3-5-7-6-4-2
	 */
	public static Node altReverseAddend(Node head){
		if(head == null || head.next ==null)
			return head;
		Node current=head,Cr=null,Pr=null;
		while(current.next != null){
			Cr=current.next;
			current.next = current.next.next ;
			Cr.next = Pr;
			Pr=Cr;
			current = current.next;
		}
		current.next=Cr;
		return head;
	}
	/*
	 * pairwise swap
	 * e.g input: 1-2-3-4-5-6-7-8-9
	 * output: 2-1-4-3-6-5-8-7-9
	 */
	public static Node pairSwap(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node front= head.next;
		Node temp = head.next.next;
		front.next = head;
		head.next = pairSwap(temp);
		return front;
	}
	
	/*Given a linked list of co-ordinates where adjacent points either form a vertical line or a horizontal line. Delete points from the linked list which are in the middle of a horizontal or vertical line.

	Examples:

	Input:  (0,10)->(1,10)->(5,10)->(7,10)
	                                  |
	                                (7,5)->(20,5)->(40,5)
	Output: Linked List should be changed to following
	        (0,10)->(7,10)
	                  |
	                (7,5)->(40,5) */
}
