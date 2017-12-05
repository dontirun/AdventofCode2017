package Day4;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day4Part2 {

    public static void main(String[] args){
        File spreadsheet = new File("passphrases.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(spreadsheet))) {
            String line;
            int correctphrases =0;
            while ((line = br.readLine()) != null) {
                // use the no duplicate property of sets to compare size at end to number of phrases parsed
                Set<String> phrases = new HashSet<String>();
                boolean valid =true;
                for (String phrase : line.split(" ")) {
                    // sort the Strings before adding to the Set
                    char[] sortedphrase= phrase.toCharArray();
                    Arrays.sort(sortedphrase);
                    String temp = new String(sortedphrase);
                    // if adding to the set returns false, we know its an anagram
                    if(!phrases.add(temp)){
                        valid = false;
                        break;
                    }

                }
                if(valid){
                    correctphrases++;
                }
            }
            //print number of correct phrases
            System.out.println(correctphrases);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
