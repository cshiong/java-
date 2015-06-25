

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
 * 
 * this class verified on LeetCode Online Judge
 */
public class LRUCache {
    
	//double linkedList node
    public class Node{
    	Integer key;
    	Integer value;
    	Node pre=null;
    	Node next=null;
    	public Node(Integer k, Integer v){
    		this.key=k;
    		this.value=v;
    	}	
    }
    
    
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    
    public LRUCache(int c){
    	capacity=c;
    	map = new HashMap<Integer, Node>(c);
    	head = new Node(null,null);
    	tail= new Node(null,null);
    	head.next=tail;
    	tail.pre=head;
    }
    
    public int get(int key){
    	Node entry = map.get(key);
    	if( entry !=null){
    	    removeNode(entry);
    	    insert2Head(entry);
    		return entry.value;
    	}
    	return -1;
    }
    
    public void set(int key, int value){
    	//check if map has it
    	Node entry = map.get(key);
    	if(entry != null){ //reuse it
    		entry.value=value;
    	
    		removeNode(entry);
    		insert2Head(entry);
    		return ;
    	}
    		//check the size of the list to see if need remove last one
        	//or won't have space to hold the new Node. very important.
        if(map.size() == capacity){
        		//remove the last one
        	    map.remove(tail.pre.key);
        	   //set tail attach to the pre one.
        	   tail.pre = tail.pre.pre;
        	   tail.pre.next=tail; 
        	   
        	    
        }
		entry = new Node(key,value);
		map.put(key,entry);
    
    	//always put the recently used after the head.
		insert2Head(entry);	
    	
    }
    
    private void insert2Head(Node node){
        Node temp= head.next;
    	head.next = node;
    	node.pre= head;
        node.next = temp;
        temp.pre = node;
    }
    
    private void removeNode(Node node){
        if( node == null)
            return;
        //since head and tail will never be null so node.pre and next won't be null
        node.pre.next = node.next;
        node.next.pre = node.pre; 
    }
      
	
}
