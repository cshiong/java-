import java.util.HashMap;
import java.util.Map;

/**
 * Created by cb on 3/9/15.
 */
public class ArrayPlayer2 {

    public int getMaxRandomNum(int[] input) throws Exception{

        if( input == null || input.length == 0 )
            throw new Exception("empty array!");


        Map<Integer,Integer> randomNum = new HashMap<Integer,Integer>();

        for(int i = 0; i < input.length; i++){

                randomNum.put(input[i],randomNum.get(input[i])+1);

        }
        int max = 0;
        for (Map.Entry<Integer,Integer> e: randomNum.entrySet()){
            int cout = e.getValue();
            if( cout > max)
                max = cout;
        }
       return max;
    }
}
