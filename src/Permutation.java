


public class Permutation
{

  

    public static void main(String args[])
    {
    	
        char[] input ="ABCD".toCharArray();
        
        int[] used= new int[4];
        
        char[] output = new char[4];
        
        
        doPermute(input,output,used,0);
        
        
    }
    
    
    public static void doPermute(char[]in, char[] out, int[] used,  int index){
    	//all the chars are in out array
    	
    	if(index == in.length){
    		System.out.println(out);
    		return ;
    	}
    	//go from the beginning of the input 
    	for(int i = 0; i<in.length; i++){
    		if(used[i]==1) //this char is already in the out array
    			continue;
    		used[i] = 1;
    		out[index] = in[i];
    		doPermute(in,out,used,++index);
    		--index;
    		used[i]=0;
    	}
    }
}
