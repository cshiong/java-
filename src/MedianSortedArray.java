

/*
 * There are two sorted arrays A and B of size m and n respectively.
 *  Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianSortedArray {
	
	 public double findMedianSortedArrays(int A[], int B[]) {
		 int aLen = A.length;
		 int bLen = B.length;
		 int k = (aLen + bLen) / 2;
		 if((aLen + bLen) % 2 != 0) {  //odd number elements
			   return findKthElement(A,B,0,aLen-1,0,bLen-1,k+1);
		 }else{  //even
	        return (findKthElement(A,B,0,aLen-1,0,bLen-1,k)
	        		+ findKthElement(A,B,0,aLen-1,0,bLen-1,k+1)) / 2  ;
	    }
	 }
	 
	 private int findKthElement(int A[], int B[],int aStart, int aEnd,
			 int bStart, int bEnd,int k){
		 int aMed = aStart;
		 int bMed = bStart;
		 if((aEnd - aStart) > 1){
			 aMed += (aEnd - aStart) / 2;
		 }
		 if((bEnd - bStart) > 1){
			 bMed += (bEnd - bStart) / 2;
		 }
		return A[1] ;
	 }
}
