


public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  if(args == null){
		  System.out.print("No Input string ");
	  }
		String input = args[0];
	  
	  int length = input.length();
	  if(input ==null || length==0){
		 System.out.println("Empty string");
	  }
	  String longestString = input.substring(0,1); //single char is a palindrome.


		System.out.println("Input strign is: " + input);
	  int j=0, k=0;
	  for (int i=0; i<length; i++){
		  j=i+1;
		  k=i;
		 
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
			  k++;
			  sub=input.substring(k,j);
			  if(longestString.length()< sub.length()){
				  longestString = sub;
			  }
		  }
	  }
	 

      System.out.println("The longest Palindrome substring is: " +longestString);
  }
}
