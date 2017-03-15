import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by evanpthompson on 2/21/2017.
 */
public class StringTransformation {

    public static void main(String[] args) {

        /*
            Write a program that takes the input string "Donald Robbins" and...
            - converts the letters to lowercase
            - removes all spaces
            - removes duplicate letters
            - sorts them into alphabetical order
            - output a string with the letters with commas between

            output: a,b,d,i,l,n,o,r,s

         */

        String s = "Donald Robbins";

        s = s.toLowerCase();  // make all letters lower case

        s = s.replace(" ", "");  // remove all spaces

        // removes duplicates
        HashMap<Character, Integer> c = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            c.put(s.charAt(i), (int) s.charAt(i));
        }


        Character[] sorted = new Character[c.size()];

        int i = 0;

        // assign the letters to character array
        for (int cha : c.values()) {
            sorted[i] = (char) cha;
            i++;
        }

        // sort the letters
        Arrays.sort(sorted);

        String outString = "";

        // assign to output string with commas
        for (Character ch : sorted) {
            outString += ch + ",";
        }

        outString = outString.substring(0, outString.length()-1);  // remove the hanging comma from string

        System.out.println(outString);

    }
}
