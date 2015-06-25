import com.sun.tools.javac.code.Attribute;

import java.util.Arrays;

/**
 * Created by cboyd002c on 6/18/15.
 *
 *
 Given an array of size N, which contains number ranging from 1 to N
 has one missing and one repeating number. Find repeated and missing number in array.
 time O(n)
 space O(n)
 */

public class FindMissRepeatNumber {

    public static void main(String[] arg) {
        //size 8,
        int[] input = {2, 4, 6, 6, 8, 7, 1, 3};
        System.out.println(Arrays.toString(input));
        findRepeatNmissingNumber(input);

    }


    /*
     time O(n)
     space O(n)
     */
    public static void findRepeatNmissingNumber2(int[] num) {

        if (num == null || num.length == 0)
            return;

        boolean [] out= new boolean[num.length];

        for (int i = 0; i < num.length; i++) {
            int index = num[i] - 1;
            boolean val = out[index];
            if ( !val  ) {
                out[index] = true;
            }
            else
                System.out.println("Repeating num: " + (index+1));
        }
        for (int j = 0; j < num.length; j++) {
            if ( !out[j] ) {
                System.out.println("Missing num is: " + (j + 1));
                return;
            }
        }
    }


    /*
     time O(n)
     space O(1)
     */
    public static void findRepeatNmissingNumber(int[] num) {

        if (num == null || num.length == 0)
            return;

        for (int i = 0; i < num.length; i++) {
            int index = num[i]>0? num[i] - 1:Math.abs(num[i]); //very important check the condition
            int val = num[index];
            if ( val > 0 ) {
                num[index] = - (val -1);
            }
            else
                System.out.println("Repeating num: " + (index+1));
        }
        for (int j = 0; j < num.length; j++) {
            if ( num[j]>0 ) {
                System.out.println("Missing num is: " + (j + 1));
                return;
            }
        }
    }
}