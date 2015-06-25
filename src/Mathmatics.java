import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Mathmatics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b=3;
		int a=-2;
		System.out.println(a+ " 's pow " +b +" is: "+ pow(a,b));
       System.out.println(Math.pow(a, b));
       List<String> str=Arrays.asList("5","1", "2", "+", "4", "*", "+", "3", "-");
       System.out.println("RPN:" +rpn(str));
	}

	/*
	 * Interviewer looking for log(n) solution, right on first attempt
	 */
	
	public static double pow(double a, int b) {
//		if(b==0 && a==0)
//			return 1;
		if(b==0)
			return 1;
	
		
		double result=pow(a,b/2);
		if(b%2==0)
		   result *=result;
		else
		   result *=a*result;
		
		if(b>0)
			return result;
		else
			return 1/result;
	} 

	public static boolean isNumber(String str){
		char[] chars=str.toCharArray();
		
		return false;
		
	}
	public static double rpn(List<String> ops){
		Stack<Double> opStack=new Stack<Double>();
		
		Set<String> sign= new HashSet();
		sign.add("+");
		sign.add("-");
		sign.add("*");
		sign.add("/");
		for(String st:ops){
			if(!sign.contains(st)){
			
				opStack.push(Double.valueOf(st));
				//catch NumberFormatException if st isn't number
				
			}else{
				double n2=opStack.pop();
				double n1=opStack.pop();
				//EmptyStackException
				if("+".equalsIgnoreCase(st)){
					opStack.push(n1+n2);
				}else if("-".equalsIgnoreCase(st)){
					opStack.push(n1-n2);
				}else if("*".equalsIgnoreCase(st)){
					opStack.push(n1*n2);
				}else if("/".equalsIgnoreCase(st)){
					opStack.push(n1/n2);
				}
				
			}
		}
		//need error checking;
		double result =opStack.pop();
		if(!opStack.isEmpty())
			System.out.println("RPN isnt valid");
			//throw new Exception("RPN isnt valid");
		return result;
		
	}
}
