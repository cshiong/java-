import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class StringPlayer {
	
	public enum NUMBER {
		ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),
		SIX(6),SEVEN(7),EIGHT(8),NINE(9);
        private int value;
        private NUMBER(int v){
        	this.value =v;
        }
        public int getValue(){
        	return value;
        }
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String str1="My House is small";//"axy";//turtle";
		String str2="My car is small";//"boo";//"tletur";
		
		System.out.println("Isomorphic? "+ isIsomorphic(str1,str2));
		System.out.println(strStr(str1,"House"));
		System.out.println(justify(str2,25));*/

        /*String s="123002410242";
		try {
            System.out.println(s);
            moveZero2End(s.toCharArray());//lookAndSay(s,7);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String str="helloworl";

		System.out.println(reverserString(str));

	}
/*check if a string is a number
 * cases: 
 * -3.3046770
 * -0000150??
 * 0.33
 * 10.
 * 0000
 * overflow??
 * 444404040444444444444444
 * 3.e+4.5
 * 
 */
	
	public static boolean isNumber(String str){
		char[] chars=str.toCharArray();
		
		return false;
		
	}
	/*
	 * string of numbers, 
	 * input:123413
	 * out: one 2,three 4's, one 3
	 */
	
	public static void lookAndSay(String number, int n) {
		String work= number.substring(number.length()-n);
		System.out.println(work);
		char array[] = work.toCharArray();
		boolean evenNumber = n % 2 == 0 ? true : false;
		for(int i = 0; i <  n ; i++){
		  int value = array[i]-'0';
		  if( value < 1 || value > 9){
			  System.out.print("not valid number!");
			  return;
		  }
		  NUMBER nInstance = NUMBER.values()[value-1];	//order start from 0
		  if(evenNumber){
			  System.out.print(nInstance);
		  }else{
			 System.out.print(value) ;
			 if((i-1)>0 && array[i-1] > 1)
				 System.out.print("'s");
			 System.out.print(",");
		  } 
		  System.out.print(" ");
		  evenNumber = evenNumber? false:true;
		}
		
		
	}
	
	public static boolean isIsomorphic(String str1,String str2){
		if(str1==null && str2!=null || str2==null && str2!=null)
		    return false;
		if(str1.length() != str2.length())
			return false;
		
		Map<Character,Character> map = new HashMap<Character,Character>();
		
		for(int i=0;i<str1.length();i++){
			
			if(map.get(str2.charAt(i)) ==null){
				map.put(str2.charAt(i),str1.charAt(i));
			}else{
				if(map.get(str2.charAt(i))!=str1.charAt(i))
					return false;
			}
		}
		return true;
	}
	
	public static String strStr(String str1, String str2){
		int l1=str1.length();
		int l2=str2.length();
		int start =0;
		boolean found=false;
		for(int i=0;i<l1; i++){
			start=i;
			int j=0;
			while(j<l2 && i<l1 && str1.charAt(i++)==str2.charAt(j++));
		    if(j==l2){
		    	found=true;
		    	break;
		    }else{
		    	i=start;
		    }	    	
		}
		if(found==true){
			return str1.substring(start);
		}
		else
			return null;
	}
	/*Given a single-line text string and a maximum width value, 
	 * write the function 'string justify(string text, int maxWidth)' 
	 * that formats the input text using full-justification, 
	 * i.e., extra spaces on each line are equally distributed between 
	 * the words; the first word on each line is flushed left and 
	 * the last word on each line is flushed right.
	 */
	
	public static String justify(String text, int maxWidth){
		if(text.length()>=maxWidth)
			return text;
		String[] words=text.split("\\s+");
		System.out.println(Arrays.toString(words));
		String purewords=text.replace(" ", "");
		int spaces=(maxWidth-purewords.length())/(words.length -1);
		StringBuilder out=new StringBuilder();
		int k=0;
		for(;k<words.length-1;k++){
			out.append(words[k]);
			int i=0;
			while(i<spaces){
				out.append(" ");
				i++;
			}
		}
        out.append(words[k]);
		return out.toString();
		
	}

	//swap two variables without third variable.
	public static void swap(char a, char b){
		//char a='a',b='b';
		System.out.println("a:" + a + " b:" + b);
		
		a = (char) (a+b);
		b= (char) (a-b);
		a=(char) (a-b);
		System.out.println("a:" + a + " b:" + b);
		
	}

    //move all the 0 to the end of the string and keep the rest of array on the original order.
   //O(n) complexity  apple phone screen question.

    public static void moveZero2End(char[] str){
        if( str == null || str.length ==  0) {
            return;
        }
        int zeroIndex = 0;

       for(int i=0; i < str.length; i++) {
           if (str[i] != '0') {
               str[zeroIndex++] = str[i];
           }
       }

        while( zeroIndex < str.length ){
            str[zeroIndex++]='0';
        }
       System.out.println(Arrays.toString(str));
    }

	public static String reverserString(String str){
		if(str == null || str.length() <=1){
			return str;
		}
		int left = 0;
		int right = str.length()-1;
		char[] strArray = str.toCharArray();
		while( left <= right){
			swap(strArray,left++,right--);
		}
		return String.valueOf(strArray);
	}
    public static void swap(char[] src, int i, int j){
        char temp = src[i];
        src[i]=src[j];
        src[j]=temp;
    }

   /* 4. csv file column are named as “A” to “Z” then “AA AB AC…AZ” “BA BB BC —BZ” — “AAA AAB AAC
                                                       27            53               703
    define a method to get the name of the column based on the column index;
    */
    public static String getName(int colIndex) {
        int row = colIndex / 26;
        int col = colIndex % 26;

        if( row == 0){
            return getCharlaber(col);
        }else{
            return getName(row)+getCharlaber(col);
        }
    }

    public static String getCharlaber(int v){
        if( v>26 || v < 1)
            System.out.print("invalid data!");
        int ch = Character.valueOf('A') + (v-1);
        return String.valueOf((char)ch);


    }
}
