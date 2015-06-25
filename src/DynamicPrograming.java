import java.util.Arrays;


public class DynamicPrograming {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		
		System.out.println(Arrays.toString(a));
		int[] out = longestIncreasingSubsequence(a);
		System.out.println(Arrays.toString(out));
		

	}

	
	/*
	 * Printing Longest Common Subsequence
	 * Given two sequences, print the longest subsequence present in both of them.
Examples:
LCS for input Sequences "ABCDGH" and "AEDFHR" is "ADH" of length 3.
LCS for input Sequences "AGGTAB" and "GXTXAYB" is "GTAB" of length 4.
	 */
	
	public static char[] longestCommonSub(char[] str1, char[] str2){
	   char[] output = new char[str1.length ];
		
		return output;
		
	}
	
	/*
	 * The longest Increasing Subsequence (LIS) problem is to find the length
	 *  of the longest subsequence of a given sequence 
	 * such that all elements of the subsequence are sorted in increasing order. 
	 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 
	 * and LIS is {10, 22, 33, 50, 60, 80}.
	 */
	public static int [] longestIncreasingSubsequence(int[] input){
		int length= input.length ;
		int maxStartpoint=0;
		int maxlength=0;
		int[][] table = new int[length][length];
		for(int i=0; i<length;i++){
		    int k=0;
		    table[i][k++]=input[i];
			for(int j=i+1; j<length; j++){
				if(input[j]> table[i][k-1])
				 table[i][k++]=input[j];
			}
			if(maxlength <k){
				maxlength = k;
				maxStartpoint = i;
			}
			
		}
	    int[] out= new int[maxlength];
		for(int i=0;i<maxlength;i++){
			out[i]=table[maxStartpoint][i];
		}
		return out;
	}
	
	
}
