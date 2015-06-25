import java.util.*;
/*
 * input Format
The first line contains an Integer N, which is the number of terms which will be provided as input.
This is followed by N consecutive Integers, with a space between each pair of integers. All of these are on one line, and they are in AP (other than the point where an integer is missing).

 */

public class faceBookSample {

	
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        Scanner in = new Scanner(System.in);
	        
	        int N = in.nextInt();
	        in.nextLine(); // this return
	        int i=0;
	        int[]input = new int[N];
	        while(in.hasNextInt()){
	            input[i++]=in.nextInt();
	        }
	        
	        int c1=input[1]-input[0];
	        int c2=input[2]-input[1];
	        int c3=0;
	        if(c1!=c2)
	             c3=input[N-1]-input[N-2];
	        
	        int c=c1==c3?c1:c2;
	         i=0;
	        int j=i+1;
	        do{
	            if(j<N-1){
	            c1=input[j++]-input[i++];
	           
	            }else{
	                System.out.println("no term missing!");
	                return;
	            }
	        }
	        while(c1==c);
	        
	        c=input[j-1]-c;
	        
	        System.out.println(c);
	    
	}
}
