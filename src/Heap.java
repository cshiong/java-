import java.util.Arrays;
import java.util.Random;

/*
 * heap property:
 * root put in a[1] then left child will be 2k and right =2K+1
 * always add in the end and pupUp() to keep the heap
 * always remove from the root and swap the last into the root position and 
 * do sink() to keep the heap , when sink always replace with the larger one if is Max heap
 * 
 */
public class Heap {

	int[] heap ;  //index start from 1 intead of 0
	int size;
	
	public Heap(int length){
		if(heap==null){
			heap = new int[length+1];
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Random randomGenerator = new Random();
		int length=11;
		int arg[] =  new int[length];
		for(int i=0; i<length; i++){
			arg[i] =randomGenerator.nextInt(50);
		}
		
		System.out.println(Arrays.toString(arg));
		Heap myHeap = new Heap(length);
		for (int x:arg){
			myHeap.push(x);
			for(int i=1;i<=myHeap.size; i++)
			  System.out.print(myHeap.heap[i]+",");
			System.out.println();
		}
		while(myHeap.size>0){
			myHeap.pub();
			for(int i=1;i<=myHeap.size; i++)
				  System.out.print(myHeap.heap[i]+",");
				System.out.println();
		}
        
	}

	
	/*
	 * sink() find the larger child and replace with it till the leaf for maxHeap
	 * for minHeap find the smaller one and swap it till it's bigger than both children.
	 */
	public int sink(int i){
		while(2*i<=size){
			int bigger=0;
			if((2*i+1)<=size)
			  bigger= heap[2*i]>=heap[2*i+1]? 2*i:(2*i+1);
			else
			  bigger = 2*i;
			heap[i]=heap[bigger];
			i=bigger;
		}
		return i;
	}
	
	/*
	 * compare with the parent (length/2) and swap if it is smaller than parent for maxHeap
	 * if bigger for minHeap.
	 */
	private void pubUp(int i){
	    int parent = i/2;
		while(parent>0){
			if(heap[parent]<heap[i]){
				swap(i, parent);
				i=parent;
				parent=parent/2;
			}else{
			 break;	
			}
		}
		
	}
	
	public void push(int x){
		
		int i=++size;
		if(size > heap.length)
			return;
		heap[i]=x;
		pubUp(i);
		
	}
	
	//notice: if pubup the leaf child of the node, need to shift one node left for the rest nodes
	public int pub(){
		if(size==0)
			return -1;
		int max = heap[1];
		int i = 1;
		int end=sink(i);
		
		//shift the rest nodes to left 
		if(end<size){
			for(int j =end+1;j<=size;j++){
			   heap[j-1]=heap[j];
			   pubUp(j-1);
			}
		}
		size--;
		return max;	
	}
	
	private void swap(int i, int j){
		int x = heap[i];
		heap[i]=heap[j];
		heap[j]=x;
	}
}
