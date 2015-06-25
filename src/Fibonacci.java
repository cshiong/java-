/**
 * Created by cb on 3/20/15.
 * f(n) = f(n-1) + f(n-2)
 * f(0) = 0;
 * f(1) = 1;
 */
public class Fibonacci {

    public static void main(String args[] ) throws Exception {
         Fibonacci f = new Fibonacci();
         for( int i= 0; i< 5; i++){
             System.out.println(f.fib2(i));
         }
    }

    public int fib1(int index){
        if( index == 0)
            return 0;
        if(index ==1 )
            return 1;

        return fib1(index-1)+fib1(index-2);

    }

    public int fib2(int index){
        int num1= 0;
        int num2 = 1;

        if( index == 0) return num1;
        if(index == 1) return num2;

        int sum = 0;
        for(int i= 2; i< index+1; i++){
            sum = num1+ num2;
            num1= num2;
            num2= sum;
        }
        return sum;
    }

}
