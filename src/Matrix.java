import java.util.Arrays;


public class Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N=5;
		int num=1;
		int[][] a= new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0;j<N; j++){
				a[i][j]=num++;
			}
			System.out.println(Arrays.toString(a[i]));
		}
       
		a=rotate90Degree(a);
		System.out.println("After rotation:");
		for(int i=0; i<N; i++)
			System.out.println(Arrays.toString(a[i]));
	}
	
	
	/*
	 * rotate the matrix 90 degree clockwise
	 */
	
	public static int[][] rotate90Degree(int[][] a){
		if(a==null)
			return null;
		int M=a.length;
		int N=a[0].length ;
		if(M != N){
			return null;
		}
		for( int i=0; i<M/2;i++){
			int layer=i;
			int last = M-1-layer;
			for(int j=layer; j<last;j++){
				int temp=a[layer][j];
				a[i][j]=a[N-1-j][layer];  //left col to upper row.
				a[N-1-j][layer]=a[last][N-1-j];//bottom to left
				//right col to bottom row
				a[last][N-1-j]=a[j][last];
				//upper row to right col;
				a[j][last]=temp; 
				
				
			}
		}
		return a;
	}

}
