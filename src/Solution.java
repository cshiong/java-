import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int sum1=0;
		int sum2=0;
		for(int i=0; i<N;i++){
			for(int j=0;j<N;j++){
				int c=sc.nextInt();
				if(i==j){
					sum1 +=c;
				}
				if( j== (N-i)){
					sum2 +=c;
				}
			}
		}

		int diff = sum1-sum2;
		System.out.println(Math.abs(diff));


	}
}