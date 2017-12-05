package Day4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Day4Part1 {

    public static void main(String[] args){
        File spreadsheet = new File("C:\\Users\\donti\\Documents\\GitHub\\AdventOfCode\\src\\Day4\\passphrases.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(spreadsheet))) {
            String line;
            int correctphrases =0;
            while ((line = br.readLine()) != null) {
                // use the no duplicate property of sets to compare size at end to number of phrases parsed
                Set<String> phrases = new HashSet<String>();
                int numberof =0;
                for (String phrase : line.split(" ")) {
                    phrases.add(phrase);
                    numberof++;
                }
                if(numberof == phrases.size()){
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
