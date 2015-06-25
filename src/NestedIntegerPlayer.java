import java.util.ArrayList;
import java.util.List;


public class NestedIntegerPlayer {

	/*
	 * **
	 * @param args
	 */
	public static void main(String[] args) {
		//{{1,1},2,{1,1}}
		
		List<NestedInteger> input= new ArrayList<NestedInteger>();
		NestedInteger t1= new NestedInteger(1);
		NestedInteger t2= new NestedInteger(1);
		NestedInteger t3= new NestedInteger(2);
		NestedInteger t4= new NestedInteger(1);
		NestedInteger t5= new NestedInteger(1);
		// TODO Auto-generated method stub
		List<NestedInteger> l1= new ArrayList<NestedInteger>();
		l1.add(t1);
		l1.add(t2);
		NestedInteger T1= new NestedInteger(l1);
		List<NestedInteger> l2= new ArrayList<NestedInteger>();
		l2.add(t4);
		l2.add(t5);
		NestedInteger T2= new NestedInteger(l2);
		input.add(T1);
		input.add(t3);
		input.add(T2);
		
		int sum = getSum(input);
		System.out.println(sum);
	}
	public static int getSum(List<NestedInteger> input){
		int sum=0;
		int deepth=1;
		for(NestedInteger o:input){
			if(!o.isList){
				sum +=o.getValue()*deepth;
			}else{
				sum =getSum(o.getList(),sum,deepth);
			}
		}
		return sum;
	}

	private static int getSum(List<NestedInteger> list, int sum, int deepth){
		deepth++;
		for(NestedInteger o:list){
			if(!o.isList){
				sum +=o.getValue()*deepth;
			}else{
				sum =getSum(o.getList(),sum,deepth);
			}
		}
		return sum;
		
	}

}
