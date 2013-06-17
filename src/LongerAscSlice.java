import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/17/13
 * Time: 3:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongerAscSlice {

    public static void main(String[] args){

        int[] A ={ 2,2,2,2,1,2,-1,2,1,3 };
        int[] B = {1,0,1,0};
        int[] C = {9,8,7,6,5,4,3,2,1,0};
        LongerAscSlice las = new LongerAscSlice();
        las.solution(A);


    }


    public int solution(int[] A){

        //index, counter
        Map<Integer,Integer> indexes = new HashMap<Integer, Integer>();

        int index = 0;

        loop(A, indexes,index);



        System.out.println(indexes);
        return 1;
    }

    private void loop(int[] A, Map<Integer, Integer> indexes,int index) {
        // index = 0;

        for(int i = 0; i < A.length; i++ ){

            Integer previousNumber = A[i];
            Integer currentNumber;
            if(A.length >= 2 && (i != A.length-1 ) ){  //prevent ArrayOutOfBoundException
              currentNumber = A[i+1];
            }else
              currentNumber = -100;




            Integer count = indexes.get(index);
            if(count == null)
                count = 0;
            indexes.put(index,++count);

            if(previousNumber >= currentNumber){
                break;
            }



        }
        index++;

        if(A.length != 1)
            loop(Arrays.copyOfRange(A, 1, A.length),indexes,index);

    }
}
