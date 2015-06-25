import java.util.*;


public class arrayPlayer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arg = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8};//{1, 2, 4, 8, 16, 32, 64, 128};//{2, -8, 3, -2, 4, -10};
        System.out.println(Arrays.toString(arg));
        int t= findNotRepeatingNumber1(arg);
       // findRepeatNmissingNumber2(arg);
        //rotate1(arg, 11);
        //System.out.println(Arrays.toString(arg));
        /*List<Integer> output = getMaxofeachWindow(arg, 2);
        //System.out.println("maxsum: "+ getMaxSum(arg));
        System.out.println(output);
        int sum = threeSumClosest(arg, 82);
        System.out.println(sum);*/


       /* String[] as={"l", "like" ,"to","eat", "a", "lot",",", "but", "not", "like", "work","lot"};
		System.out.println(Arrays.toString(as));
		List<String> input = new ArrayList<String>(Arrays.asList(as));
		int dis=smallestDistance(input,"like","lot");
		System.out.println("Distance between like and lot is : " + dis);
        int[] arg1={0, 2, 3, 3, 3, 10, 10};
        Range rg=findRange(arg1,3);
        System.out.println("("+rg.start +","+rg.end +")");

        int[] arg2={3, 1, 4, 2};
        System.out.println(Arrays.toString(arg2));
        int[] output=selfExcludingProduct(arg2);
        System.out.println(Arrays.toString(output));

        System.out.println("is 7 a Happy Number? "+ isHappyNumber(7,10));

        String in="{{1,1},2,{1,1}}";
        System.out.println(getSum(in));*/
    }


    /*You are given an array of integers (both positive and negative)
	 * Find the continuous sequence with the largest sum Return the sum
	SOLUTION
	EXAMPLE
	Input: {2, -8, 3, -2, 4, -10} 
	Output: 5 (i e , {3, -2, 4} )
	*/
    public static int getMaxSum(int[] a) {
        int maxsum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (maxsum < sum) {
                maxsum = sum;
            } else if (sum < 0)
                sum = 0;
        }

        return maxsum;
    }

    /*
	 * find the smallest distance between two string in a string list
	 */
    public static int smallestDistance(List<String> input, String str1, String str2) {
        int min_Dist = 0;
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < input.size(); i++) {
            if (str1.equalsIgnoreCase(input.get(i))) {
                index1 = i;
            } else if (str2.equalsIgnoreCase(input.get(i))) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                int dist = Math.abs(index1 - index2); //order doesn't matter
                if (min_Dist == 0 || (min_Dist > dist && min_Dist != 0)) {
                    min_Dist = dist;
                }
            }
        }
        return min_Dist;
    }

    //Given a sorted array with duplicates and a number, find the range in the
    //form of (startIndex, endIndex) of that number.
    public static int findNumber(int[] input, int num, int start, int end) {
        if (end - start < 0)
            return -1;
        int mid = start + (end - start) / 2;
        if (num > input[mid]) {
            return findNumber(input, num, start, mid - 1);
        } else if (num < input[mid]) {
            return findNumber(input, num, mid + 1, end);
        } else {
            return mid;
        }
    }

    public static Range findRange(int[] input, int num) {
        int index = findNumber(input, num, 0, input.length - 1);
        Range range = new Range();
        int i = index + 1;
        while (i < input.length) {
            if (num == input[i])
                i++;
            else
                break;
        }
        range.end = i - 1;
        i = index - 1;
        while (i > -1) {
            if (num == input[i])
                --i;
            else
                break;
        }
        range.start = i + 1;
        return range;
    }

    public static class Range {
        int start;
        int end;
    }

    /**
     * Implement a method which takes an integer array and returns an integer array (of equal size) in
     * which each element is the product of every number in the input array with the exception of the
     * number at that index.
     * <p/>
     * Example:
     * [3, 1, 4, 2] => [8, 24, 6, 12]
     */
    public static int[] selfExcludingProduct(int[] input) {

        int product = 1;
        for (int i = 0; i < input.length; i++) {
            product *= input[i];
        }
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = product / input[i];
        }
        return output;
    }

    /*  find if a number is a happy number after N loop
	 */
    public static boolean isHappyNumber(int x, int n) {
        int squares = x * x;
        int count = 0;
        while (count < n) {
            int[] digit = int2Digit(squares);
            squares = 0;
            for (int i = 0; i < digit.length; i++) {
                squares += digit[i] * digit[i];
            }
            if (squares == 1)
                return true;
            count++;
        }
        return false;
    }

    public static int[] int2Digit(int x) {
        String str = Integer.toString(x);
        int[] digit = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digit[i] = Character.digit(str.charAt(i), 10);
        }
        return digit;
    }

    /*
	 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
	* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
    * following solution only works for single digit int. the general one in nestedInteger class
    */
    public static int getSum(String input) {
        int sum = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{') {
                stack.push('{');
            } else if (c == '}') {
                stack.pop();
            } else if (c == ',')
                continue;
            else {

                sum += (c - '0') * stack.size();
            }
        }
        return sum;
    }
	
	/*Remove Duplicates from Sorted Array
	 * findFirst() and findLast() using BS
	 */


    public static int findKthNumber(int[] a, int l, int r, int k) {
        //check if k is in the ranger
        if (k < 0 && k <= (r - l + 1)) {
            int pi = partion(a, l, r);
            if (pi == k)
                return a[pi];
            if (pi < k)
                return findKthNumber(a, pi, r, k);
            return findKthNumber(a, l, pi, k);

        }
        // If k is more than number of elements in array
        return Integer.MIN_VALUE;
    }

    public static int partion(int[] src, int start, int length) {
        if (src == null || src.length == 0)
            return -1;

        int pi = length - 1;
        while (start < length) {
            if (start < pi && src[start] > src[pi]) {
                swap(src, start, pi);
                pi = start;
            } else if (start > pi && src[start] < src[pi]) {
                swap(src, start, pi);
                pi = start;
            }
            start++;
        }
        return pi;
    }

    public static void swap(int[] src, int i, int j) {
        int temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }

    /*
    find max in each window of size n and slide the window by 1
     */

    public static List<Integer> getMaxofeachWindow(int[] input, int windowSize) {
        List<Integer> output = new ArrayList<Integer>();
        if (input == null || input.length == 0 || windowSize == 0 || windowSize > input.length)
            return null;
        //save the index of the bigger one in the window so know when to remove it.
        ArrayDeque<Integer> windon = new ArrayDeque<Integer>();
        //initialize the heap;
        for (int i = 0; i < windowSize; i++) {
            while (!windon.isEmpty() && input[i] >= input[windon.peekLast()]) {
                windon.removeLast();
            }
            windon.addLast(i);
        }
        output.add(input[windon.peekFirst()]);
        for (int i = windowSize; i < input.length; i++) {
            while (!windon.isEmpty() && input[i] >= input[windon.peekLast()]) {
                windon.removeLast();
            }
            windon.addLast(i);

            //check the first one(biggest one is inside the window or not
            int index = windon.peekFirst();
            if (index <= (i - windowSize))
                windon.removeFirst();

            output.add(input[windon.peekFirst()]);
        }
        return output;
    }
    /*
     Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
     target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     For example, given array S = {-1 2 1 -4}, and target = 1.
     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */

    public static int threeSumClosest(int[] num, int target) {
        int minDiff = Integer.MAX_VALUE;
        int threeSum = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(sum - target);
                if (diff == 0)
                    return sum;
                if (minDiff > diff) {
                    minDiff = diff;
                    threeSum = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }

            }

        }
        return threeSum;
    }
    /*
    Given an array of sorted number of size N and contains numbers in range 1 to N-1. Find the smallest missing number.
    * */

    /* different question?
    Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n.
     Find the smallest number that is missing from the array.
    * Examples
   Input: {0, 1, 2, 6, 9}, n = 5, m = 10
    Output: 3
    * */
    public static int findSmallestMissingNumber(int[] num, int start, int end) {
        if (num == null || end == start)
            return -1;

        int pivot = start + (end - start) / 2;
        int rightNum =num.length/2;
         return rightNum;

    }

    /*
    Given an array of size N, which contains number ranging from 1 to N-1
    has one missing and one repeating number. Find repeated and missing number in array.
    time O(n)
    space O(n)
     */
    public static void findRepeatNmissingNumber(int[] num) {
        if (num == null || num.length == 0)
            return;
        int N = num.length;
        int[] temp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int val = temp[num[i]];
            if (val == -1)
                System.out.println("Repeating number is: " + num[i]);
            else
                temp[num[i]] = -1;
        }
        for (int i = 1; i <= N; i++) {
            if (temp[i] != -1)
                System.out.println("Missing number is: " + i);
        }
    }
/*
 time O(n)
 space O(1)
* */
    public static void findRepeatNmissingNumber2(int[] num) {
        if (num == null || num.length == 0)
            return;

        for ( int i = 0; i < num.length; i++){

            int index = num[i]>0? num[i] - 1:Math.abs(num[i]);
            int val = num[index];
            if( val > 0 )
                num[index] = -(val-1);
            else
                System.out.println("Repeating num: " + Math.abs(val));
        }
        for (int j = 0; j < num.length; j++) {
            if (num[j] > 0) {
                System.out.println("Missing num is: " + (j + 1));
                return;
            }
        }
    }

    /*
    Q: Given an array of strings return a binary tree containing those strings that follows this pattern: The root of the binary tree contains the first element in the array, the left child of the root contains the second element in the array, the right child of the root contains the third element in the array, and the next four elements are the values of the next layer of the binary tree.

            0
            1                2
            3      4          5     -

* left to right , balance tree */
    class Node {
        Node left;
        Node right;
        String value;
        public Node(String val){
            value = val;
        }
    }


    public Node createBinaryTree(String[] values){
        if( values == null)
            return null;
        Node root = new Node(values[0]);
        Queue<Node> treeNodes = new LinkedList<Node>();
        treeNodes.add(root);
        int level =  values.length/2;
        for( int i = 0; i <level; i++ ){

            Node parent = treeNodes.remove();
            int left = 2*i + 1;
            int right = 2*i + 2;

            if(left < values.length){
                parent.left= new Node(values[left]);
                treeNodes.add(parent.left);
            }
            if(right< values.length){

                parent.right = new Node(values[right]);
                treeNodes.add(parent.right);
            }

        }

        return root;

    }

    /*
    Rotate an array of n elements to the right by k steps. k > n is possible.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     */
//not good soluation if the nums is very long.
    public static void rotate1(int[] nums, int k) {

        int size = nums.length;
        int count = 0;
        if(k > size)
            k = k % size;
        while(count < k){
            count++;
            int i = size-1;
            int temp = nums[i];
            while(i-1 >-1){
                nums[i] = nums[i-1];
                i--;
            }
            nums[0]=temp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int size = nums.length;
        if(k > size)
            k = k % size;
        int[] temp = new int[k];
        int j = size-1;
        int i =k-1;
        while(i > -1){
            temp[i--] = nums[j--];
        }
        i = size-1;
        while(j>-1){
            nums[i--] = nums[j--];
        }
        for(int l= 0; l< k; l++){
            nums[l] = temp[l];
        }
    }

    /* find  kth smallest element from two sorted arrays.*/

    /*public int getKthSmallestOfTwoSortedArrays(int[] A, int[] B, int k,int aLeft,int aRight, int bLeft, int bRight){

        int aSize = aRight - aLeft;
        int bSize = bRight - bLeft;
        if( (aSize + bSize) < k)
            return -1;
        *//*we will assume that size_a is smaller than size_b
        else we will swap array in call :) *//*
        if(aSize > bSize)
            return getKthSmallestOfTwoSortedArrays(B,A,k,bLeft,bRight,aLeft,aRight);

        if( aSize == 0 && bSize > 0 )
            return B[k-1];
        if( k == 1)
            return Math.min(A[0],B[0]);

        int i = Math.min(aSize,k/2);
        int j = Math.min(bSize,k/2);

        if( A[i-1] > B[i-1]){
            
        }

    }*/

    public static int findNotRepeatingNumber(int[] A){

            int sum =0;
            Set<Integer> map = new HashSet<Integer> ();
            for( int i = 0; i< A.length; i++){
                sum += A[i];
                if( !map.contains(A[i])){
                    map.add(A[i]);
                }
            }
            int sum2 = 0;
            for(Integer t: map){
                sum2 += 2 * t;
            }
            return sum2 - sum;
        }

    public static int findNotRepeatingNumber1(int[] A){
        int res=0;
        for(int i=0;i<A.length;i++){
            res=res^A[i];
        }
        return res;
    }
}