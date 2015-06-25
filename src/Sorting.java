import java.util.Arrays;




public class Sorting
{

    public Sorting()
    {
    }

    public static void main(String args[])
    {
//        String src = "435267981";
//        System.out.println(src);
//     /*   String des = merge_sort(src);
//        System.out.println(des); */
//        char[] srcChar=src.toCharArray();
//        char[] meged = meger_sort(srcChar,0,src.length()-1);
//        System.out.println(Arrays.toString(meged));
    	char[] a={'r','b','b','y','y','r','r','r','y','b' };
    	System.out.println(Arrays.toString(a));
    	a=threeColors(a);
    	System.out.println(Arrays.toString(a));
    }

    public static String merge_sort(String src)
    {
        int length = src.length();
        if(length <= 1)
            return src;
        int mid = length / 2;
        String leftSrc = merge_sort(src.substring(0, mid));
        String rightSrc = merge_sort(src.substring(mid + 1, length - 1));
        char dest[] = new char[length];
        int lptr = 0;
        int rptr = 0;
        int dptr = 0;
        while(lptr < mid && rptr < length) 
            if(leftSrc.charAt(lptr) < rightSrc.charAt(rptr))
                dest[dptr++] = leftSrc.charAt(lptr++);
            else
                dest[dptr++] = rightSrc.charAt(rptr++);
        if(lptr == mid)
            while(rptr < length) 
                dest[dptr++] = rightSrc.charAt(rptr++);
        else
            while(lptr < mid) 
                dest[dptr++] = leftSrc.charAt(lptr++);
        return dest.toString();
    }
    
    public static char[] meger_sort(char[] src,int start, int end){
    	if(end== start ){  //base case
    		char[] s = new char[1];
    		s[0]=src[start];
    		return s;
    	}
    	int mid = start + (end-start)/2;
    
    	char[] left= meger_sort(src, start, mid);
    	char[] right=meger_sort(src,mid+1,end);
    	
    	if(left != null && right !=null){
    		char[] merged= new char[left.length + right.length];
    		int i=0,j=0,k=0;
    		while(i<left.length && j<right.length){
    			if( left[i]<right[j]){
    				merged[k++]=left[i++];
    			}else{
    				merged[k++]=right[j++];
    		    }
    	    }
    		while(i<left.length )
    			merged[k++]=left[i++];
    		while(j<right.length )
    			merged[k++]=right[j++];
    		
    		return merged;
    }else{
    	return left !=null ? left: right;
    }
   }
    
    public static char[] threeColors(char[] input){
    	int r=-1,y=-1,b=-1;
    	
    	for(int i=0; i<input.length ;i++){
    		
    		if(r==-1 && input[i]=='r'){
    			r=i;
    			continue;
    		}
    		
    		if(y==-1 && input[i]=='y'){
    			y=i;
    			continue;
    		}
    		if(b==-1 && input[i]=='b'){
    			b=i;
    			continue;
    		}
    		
    		while(input[i]!=input[i-1]){
    		char a=input[i];
    		switch (a){
    		case 'r': {
    			if(r == i-1){
    				r++;
    			}
    			else{
    				++r;
    				swap(input,r,i);
    			}
    			break;
    		}
    		case 'y':{
    			if(y == i-1){
    				y++;
    			}
    			else{
    				++y;
    				swap(input,y,i);
    			}
    			break;
    			
    		}
    		default:
    			if(b == i-1){
    				b++;
    			}
    			else{
    				++b;
    				swap(input,b,i);
    			}
    			break;
    		}
    		}
    	}
    	return input;
    }
    public static void swap (char[]a, int i , int j){
    	 char t= a[i];
    	 a[i]=a[j];
    	 a[j]=t;
    	
    }
}
