import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/16/13
 * Time: 4:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Intersection {

    public static void main(String[] args){


        int[] A ={1,5,2,1,4,0};

        Intersection i = new Intersection();
        System.out.println(i.solution(A));
        Pair p1 = new Pair(-1,1);
        Pair p2 = new Pair(-4,6);
        System.out.println(p2.intersect(p1));
        System.out.println(p1.intersect(p2));


    }


    public int solution ( int[] A ) {
        System.out.println("input: ");
        for(Integer i : A){
            System.out.println(i);
        }

        //point,radius
        NavigableMap<Integer,Pair> rounds = new TreeMap<Integer, Pair>();
        int index = 0;
        for(Integer i : A){

            rounds.put(index, new Pair(index - i, index + i));
            index++;
        }

        System.out.println(rounds);

        int result = 0;
        Set<ResultPairs> results = new HashSet<ResultPairs>();

        int nrOfChecked = 0;
        int iterationNr = 0;
        for(Pair p : rounds.tailMap(nrOfChecked).values()){
           // if(iterationNr >= nrOfChecked){
                for(Pair p2 : rounds.tailMap(nrOfChecked).values()){
                    if(!p2.equals(p)){
                        if(p.intersect(p2)) {
                            results.add(new ResultPairs(p,p2));
                            result++;
                        }
                    }
                }
            //}
         nrOfChecked++;


        }
        System.out.println("true counter : " + Pair.TRUE_COUNTER);
        //Set<ResultPairs> sorted = Collections.sort(results);
        System.out.println(result);
        System.out.println("size:" +  results.size());
        return result;
    }



}

class ResultPairs {
    final Pair p1;
    final Pair p2;

    public ResultPairs(Pair p, Pair p2) {
       // if( p.getRight() < p2.getRight() ){
        this.p1 = p;
        this.p2 = p2;
       // }
      //  else{
         //   this.p1 = p2;
       //     this.p2 = p;
        //}
    }

    @Override
    public boolean equals(Object obj) {
        ResultPairs that = (ResultPairs) obj;
        return this.p1.equals(that.p1) && this.p2.equals(that.p2);
    }

    @Override
    public int hashCode() {
        return p1.hashCode() * p2.hashCode();
    }

    @Override
    public String toString() {
        return p1.toString() + " " + p2.toString();
    }

    /*@Override
    public int compareTo(Object o) {
        ResultPairs that = (ResultPairs) o;
        return this.p1.getRight() - that.p2.getRight();
    }  */
}

class Pair{
    private final int left;
    private final int right;
    public static int TRUE_COUNTER = 0;

    Pair(int leftBoundry, int rightBoundry) {
        if(leftBoundry  < 0)
        this.left = 0;
        else
        this.left = leftBoundry;
        this.right = rightBoundry;
    }

    int getLeft() {
        return left;
    }

    int getRight() {
        return right;
    }

    boolean intersect(Pair that){
        System.out.println("this : " +  this + "that : " + that);
        if(this.right >= that.left

          ){
            TRUE_COUNTER++;
            return true;


      }//else if(this.left >= that.left && this.right <= that.right){
     //       TRUE_COUNTER++;
     //       return true;

     //  }
         else{
            System.out.println("false");
            return false;

        }
    }


    @Override
    public String toString() {
        return "[" + left + "," + right + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Pair that = (Pair) obj ;
        return this.left == that.left && this.right == that.right;
    }

    @Override
    public int hashCode() {
        return this.getLeft() + this.getRight();
    }
}
