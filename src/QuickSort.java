import java.util.Arrays;
import java.util.Random;


public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//initialize array:
		 /*Datatype[] variable = new Datatype[] { value1,value2.... }
		 Datatype variable[]  = new Datatype[] { value1,value2.... }*/
		int arg[] =  new int[10];
		Random randomGenerator = new Random();
		for(int i=0; i<9; i++){
			arg[i] =randomGenerator.nextInt(50);
		}
		//	{6,2,5,8,4,5,7,3,9};
		System.out.println(Arrays.toString(arg));
		doQuickSort(arg,0, arg.length-1);
		
		System.out.println(Arrays.toString(arg));
		
		

	}
	//following quickSort sort duplicate keys. using 3 way partition.
	//using two points to separate the less than and greater than
		public static void quickSort(int[] src, int lo, int high){
			if(high <= lo)
				return;
			int lt = lo;
			int gt = high;
		    int pi = src[lo];
		    int i=lo;
		    while(i<=gt){
		    	if(src[i] < pi){
		    		swap(src,i++,lt++);
		    	}
		    	else if(src[i] >pi){
		    		swap(src,i,gt--);
		    	}
		    	else
		    		i++;
		    }
		    quickSort(src,lo,lt-1);
		    quickSort(src,gt+1,high);
		    
		}

	public static void doQuickSort(int[] src,int lo,int high){
		if(src == null || lo >= high)
			return ;
		
		int mid = partion2(src,lo,high );
		
		doQuickSort(src,lo,mid);
		doQuickSort(src,mid+1,high);
		
	}
	/*
	 * keep i as the divide point of the array which already checked elements are portioned,
	 * all a[l] .. a[i-1] are < a[pi] and all a[i] .. a[j] are > a[pi] , and all a[j+1]..a[length-1] unchecked yet
	 * move j and if
	 * pi=a[0]
	 * i = divided point of the partition.
	 * swap the a[i-1]with a[pi]. pi in the final right place.
	 */
	
public static int partion3(int[] src, int start, int length){
		
		if (length - start==0)
			return start;
		
		int pi = start;
		int i=start+1; //i is the boundry where left <a[pi] and right >a[pi]
		
		for(int j= start+1;j<length;j++){
			if(src[j]<src[pi]){
				swap(src,i, j); 
				i++;
			}
		}
      //swap the boundry with the pivot 
        swap(src,pi,i-1);
		return i-1;
	}
	
	//the easiest to understand and but NOT handle the duplicate number
	public static int partion2(int[] src, int start, int high){
		
		if (high - start==0)
			return start;
		
		int pivot = src[start];
		int i=start;
		int j= high;
		while(i<j){
			while(i<j && (src[i] < pivot))
				i++;
			while(i<j && (src[j] > pivot))
				j--;
			swap(src,i++,j--);
		}
		return i-1; //very important: the last one may bigger than the a[pi]
	}
	public static int partion(int[] src, int start, int length){
		if(src==null || src.length==0)
			return -1;
			
		int pi=length-1;
		while(start <length){
			if(start<pi && src[start]>src[pi]){
				swap(src, start,pi);
				pi=start;
			}
			else if(start>pi && src[start]<src[pi]){
				swap(src,start,pi);
			    pi = start;
			}
			start++;
		}
		return pi;
	}
	
	public static void swap(int[] src, int i, int j){
		int temp = src[i];
		src[i]=src[j];
		src[j]=temp;
	}
	
	
}
