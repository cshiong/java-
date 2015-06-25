class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
    	
    	int sum=0;
    	for(int i = 0; i<A.length;i++){
    		sum +=A[0];
    	}
    	int N = A.length-1;
    	int min =Math.abs(sum- A[N]);
    	
    	int sub=0;
    	for(int i=N;i>0;i--){
    		sub += A[i];
    		int dif = Math.abs(sum -2*sub);
    		if( dif < min){
    			min = dif;	
    		}
    	}
    	return min;
    }
}
