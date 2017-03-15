import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by evanpthompson on 2/26/2017.
 */
public class IntegerFunctions {

    public static void main(String[] args) {
        int[] intArr1 = {0,1,2,3,4,5,6,7,8,9};
        int[] intArr2 = {10,11,12,13,14,15,16,17,18,19};
        int[] intArr3 = {156,151,33,14,84,16,354,156,8,0};
        int[] intArr4 = {9,8,7,6,5,4,3,2,1,0};
        int[] intArr5 = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5};

        int[] outIntArr1 = mostFrequentInt(intArr3);



    }

    public static int[] mostFrequentInt(int[] intArr) {
        int[] outArr = null;

        // pre sort
        /*
        for (int i = 0; i < intArr.length;i++) {
            System.out.println(intArr[i]);
        }
        */

        //Arrays.sort(intArr);

        // verify sort works
        /*
        for (int i = 0; i < intArr.length;i++) {
            System.out.println(intArr[i]);
        }
        */

        HashMap<Integer, Integer> intMap = findCounts(intArr);

        intMap.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));  // foreach lambda function

        return outArr;
    }



    public static HashMap<Integer, Integer> findCounts(int[] intArr) {
        HashMap<Integer, Integer> intMap = new HashMap<>();

        for (int i : intArr) {
            // if key already in map, add to occurrence count
            if (intMap.containsKey(i)) {


                int curVal = intMap.get(i);

                intMap.replace(i, curVal, curVal+1);
            }
            else {

                // if key not already in map add and set occurrence count to 1
                intMap.put(i, 1);

            }
        }

        return intMap;
    }

    private HashMap<Integer, Integer> orderMap(HashMap<Integer, Integer> intMap) {
        HashMap<Integer, Integer> outMap = new HashMap<>();
        Set<Integer> keys = intMap.keySet();
        Collection<Integer> values = intMap.values();



        return outMap;
    }


    private int returnMax(int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }

    private int returnMin(int a, int b) {
        if (a < b) {
            return a;
        }
        else {
            return b;
        }
    }


}
