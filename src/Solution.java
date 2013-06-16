import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/16/13
 * Time: 1:42 AM
 * To change this template use File | Settings | File Templates.
 */
class Solution {

    public static void main ( String[] args ) {
        int[] A = {2,2,1,0,1};

        System.out.println(solution(A));

    }

    public static int solution(int[] A){
        //List<Integer> list = new LinkedList<Integer>();
        //nr, indexOfNr
        Map<Integer,List<Integer> > map =
                new HashMap<Integer,List<Integer>>();

        int i = 0;
        for(Integer nr : A){
            List<Integer> indexes =  map.get(nr);
            if(indexes == null)
               indexes=new LinkedList<Integer>();

            indexes.add(i);
            map.put(nr, indexes);

            i++;
        }

        int result = 0;
        for(List<Integer> indexes : map.values()){
             if(result < indexes.get(0))
                 result = indexes.get(0);
        }
        System.out.println(map);
        return result;
    }

}
