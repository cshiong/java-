import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Arrays;




public class PalindromeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="BBBCCCCBBBABCBAABA";
		System.out.println(str);
	/*	char[] longP= longestPalindrome(str.toCharArray());
		System.out.println(Arrays.toString(longP)); */
     List<String> list = new ArrayList<String>();
	  /*String pStr = logestPalindromRecusive(str,0,"");
			  //longestPalindromeSimple(str);
		System.out.println(pStr);*/
     allPalindromRecusive(str,list);
     System.out.println(Arrays.toString(list.toArray(new String[0])));
	}

	
	public static char[] longestPalindrome(char[]src){
		int maxLength=0;
		int currentLength=0;
		
		int longestStart=0,longestEnd =0;
		int current = 1;
		int start = 0;
		while(start<src.length){
			while(current < src.length){
				while(src[start] !=src[current++]&& current<src.length);
				if(isPalindrome(src,start,--current)){
					currentLength = current - start;
					if (maxLength < currentLength){
						maxLength = currentLength;
						longestStart=start;
						longestEnd=current;						
					}	
				}
				current++;	//continue to see have same char as the start one
		}
		//move to next one and start the checking again
		start++;
		current=start+1;
						
		}
		int i=0;
		char[] longestP= new char[longestEnd-longestStart+1];
		do
		{
			longestP[i++]=src[longestStart++];				
		}while(longestStart <longestEnd);
		longestP[i]=src[longestEnd];
		return longestP;
	}
	
	public static boolean isPalindrome(char[] src, int start, int end){
		while(start <end && src[start++]==src[end--]);
	     if(start==end)	
	    	 return true;
	     return false;
	
	}
	
	/*
	 * approch 2:  based on center and expand the checking
	 */
	
	public static String palindoreString(String input){
		  int length = input.length();
		  if(input ==null || length==0){
			 System.out.println("Empty string");
		  }
		  String longestString = input.substring(0,1); //single char is a palindrome.
		 // System.out.println("Input strign is: " + input);
		  int j=0, k=0;
		  for (int i=0; i<length; i++){
			  j=i+1;
			  k=i;
			 //some problem here if have repeated char over 3 length.
			  if((j<length &&input.charAt(k)==input.charAt(j))|| (++j < length && input.charAt(k)==input.charAt(j))){
				  String sub="";
				  if(k==0) {//since the first char no need to go back to check.but is palindrome of two chars
					  sub=input.substring(k,j);
					  if(longestString.length()< sub.length()){
						  longestString = sub;
					  } 
					  continue;  
				  }
				  while(--k>0 && ++j<length){
					  if(input.charAt(k)!=input.charAt(j)){
						  break;
					  }
				  }
				  k++; //back to the start point of the palindrome
				  sub=input.substring(k,j);  //since the j is exclusive so no need to go back 1
				  if(longestString.length()< sub.length()){
					  longestString = sub;
				  }
			  }
		  }
		 return longestString;
	}
	
	
	public static String oanlindromString(String s, int c1, int c2) {
		  if( s==null || s.length() == 0)
			  return s;
		  int l = c1, r = c2;
		  int n = s.length();
		  while (l > -1 && r < n && s.charAt(l--) == s.charAt(r++)) ;
		  return s.substring(l+1, r);  //move back point to one equal on l+1(inclusive) r no need since it is exclusive
		}
		 
	public static String longestPalindromeSimple(String s) {
		  int n = s.length();
		  if (n == 0) return "";
		  String longest = s.substring(0, 1);  //odd also a single char itself is a palindrome
		  for (int i = 0; i < n-1; i++) {
		    String p1 = oanlindromString(s, i, i);  //odd case: aba i point to b
		    if (p1.length() > longest.length())
		      longest = p1;
		 
		    String p2 = oanlindromString(s, i, i+1);//even case: aa. i point to a
		    if (p2.length() > longest.length())
		      longest = p2;
		  }
		  return longest;
		}
	
	/*
	 * recursive solution
	 */
	public static String logestPalindromRecusive(String s,int k, String longest){
		if(s.length() == 0 || k == s.length())
			return longest;
		String pOdd=oanlindromString(s,k,k);  //odd palindrome
		if(pOdd != null && pOdd.length() > longest.length())
			longest = pOdd;
		String pEven=oanlindromString(s,k,k+1); //even palindrome
		if(pEven != null && pEven.length() > longest.length())
			longest = pEven;
		return logestPalindromRecusive(s,k+1,longest);
		
	}
	//not for odd void
	public static void allPalindromRecusive(String s, List<String> pStrs){
		if(s ==null ||s.length() == 0 )
			return ;
		for(int k = 0; k < s.length(); k++){
			//allPStrings(s,k,k,pStrs);
			allPStrings(s,k,k+1,pStrs);	
		}
	}
	public static void allPStrings(String s, int l, int r,List<String> pStrs){
		
		 int n = s.length();
		  while (l > -1 && r < n && s.charAt(l) == s.charAt(r++)) {
			  pStrs.add(s.substring(l,r));
			  l--;
		  }
		
	}
}
