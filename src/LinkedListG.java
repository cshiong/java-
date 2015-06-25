

public class LinkedListG {
	
	public static class Node<T extends Number>{
		T data;
		Node<T> next;
		
		public Node (T t){
			data =t;
			next=null;
		}
	}


	public static  <T> Node createList(int length){
		if(length==0)
			return null;
		return null;// new Node<T>(3);
		
	}
}
