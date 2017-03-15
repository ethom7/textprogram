import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class SentenceReader {


    //  Write a program that will parse sentences and count the number of occurrences of the top 'k' words in each file.

    public static void main(String[] args) {

        String textFileName = "C:\\Users\\evanpthompson\\Desktop\\adminTool\\textprogram\\wrnpc11.txt";


        String delimiter = "(?<=[.!?])\\s*";  // regex for sentence identification
        String punctuation = "\\p{Punct}";  // regex for punctuation identification





        try {

            String record;


            // setup scanner to read in by sentence
            Scanner reader = new Scanner(new File(textFileName)).useDelimiter(delimiter);

            HashMap<Integer, HashMap<String, Integer>> masterMap = new HashMap<>();   // Key = sentence index, value = hashmap of sentence word count


            // define and initialize hashmap for the sentence word count
            HashMap<String, Integer> sentenceMap = new HashMap<>();

            // read in text document
            while ((reader.hasNext())) { // read lines in

                record = reader.next();  // read in next sentence

                // cleaning the input
                record = record.replace("\r\n"," ");  // remove formatting
                record = record.replaceAll(punctuation, "");  // remove punctuation from words

                // splitting the input
                String[] parts = record.split(" ");  // split string into individual words based on spaces

                // hash each word in each sentence
                for (String word : parts) {


                    // if word already in map, add to word count
                    if (sentenceMap.containsKey(word.toLowerCase())) {


                        int curVal = sentenceMap.get(word.toLowerCase());

                        sentenceMap.replace(word.toLowerCase(), curVal, curVal+1);
                    }
                    else {

                        // if word not already in map add and set word count to 1
                        sentenceMap.put(word.toLowerCase(), 1);

                    }

                }
            }  // finished reading text document





            // print size of sentence list, for testing

            //System.out.println(sentenceMap.size());

            /*
            for (String s : sentenceMap.keySet()) {
                System.out.println(s + "  " + sentenceMap.get(s));
            }
            */







            /*  output list to text file, for testing  */

            FileWriter writer = new FileWriter("wrnpc11_wordcount.txt");  // specified name of output file

            // print sentence list to textfile
            for (String s : sentenceMap.keySet()) {
                writer.append(s + "  " + sentenceMap.get(s) + "\r\n");
            }

            writer.close();

            /*  end of section output list to text file, for testing  */

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }



    }


}
