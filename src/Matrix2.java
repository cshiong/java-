

import java.util.Arrays;

public class Matrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		char[][] matrix= {{'a', 'b', 'c', 'e'},
			{'s', 'f', 'c', 's'},
			{'a','d','e', 'e'}};
		printMatrix(matrix,3);
        char[] str={'b','c','c','e','d'};
        boolean match = hasPath(matrix,str,3,4);
        System.out.println(" path: " + Arrays.toString(str) + "  is in matrix: " + match);
	}

	
	public static void printMatrix(char[][] m,int rows){
		
		for(int i=0; i< rows; i++){
			System.out.println(Arrays.toString(m[i]));
		}
		
	}
	
	/*backtracking 
	 * check whether there is a path for a string in a matrix of characters? 
	 * char already in the path can't count again
	 */
	
	public static boolean hasPath(char[][] matrix, char[] str, int rows,int cols){
		
		if(matrix==null || cols<1 || rows<1 || str==null || str.length<1)
			return false;
		boolean visited[][] = new boolean[rows][cols];
		int index=0;
		
		for(int row = 0; row<=rows;row++){
			for(int col = 0; col <= cols; col++){
				if(hasPathCore(matrix,str, row,col, index,cols,rows, visited))
					return true;
			}
		}
		return false;
	}
	
	public static boolean hasPathCore(char[][] matrix,char[] str, int row, int col,int index,
			int cols, int rows,boolean[][] visited){
		if(index==str.length)
		   return true;
		
		if(col <0 || col>=cols || row <0 || row>=rows ||visited[row][col] ==true)
		    return false;
		System.out.println("row:" + row + " col: " + col + " str[" + index +"]:" +  str[index]);
		boolean match=false;
		if(matrix[row][col]==str[index]){
			match = true;
			visited[row][col]=true;
			index++;
	
		    match=hasPathCore(matrix,str,row,col+1,index,cols,rows,visited) //move to right col
			  || hasPathCore(matrix,str,row,col-1,index,cols,rows,visited) //move to left col
		      || hasPathCore(matrix,str,row+1,col,index,cols,rows,visited) //move down one row
		      || hasPathCore(matrix,str,row-1,col,index,cols,rows,visited); //move up one row.
       
		 if(!match){
			 --index;
			 visited[row][col]=false;
		 }
		}
		return match;
	}

}
