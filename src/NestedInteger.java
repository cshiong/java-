import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NestedInteger {
  
	int value=Integer.MIN_VALUE;
    List<NestedInteger> nlist;
    boolean isList=false;
    
    public NestedInteger(List<NestedInteger>l ){
      nlist=l;
      isList=true;	
    }
    public NestedInteger(int i){
    	value=i;
    }
    
    public int getValue(){
    	if(isList)
          // throw new Exception("not a int");
    		System.out.println("not a integer");
    	return value;
    }
    
    public List<NestedInteger> getList(){
    	if(isList)
    		return nlist;
    
    	System.out.println("wrong data format");
    	return null;
    	
    }
	
}
