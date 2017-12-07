package Day7;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day7Part1 {

    public static void main(String[] args){
        File spreadsheet = new File("C:\\Users\\Arun\\Documents\\Git\\AdventOfCode\\src\\Day7\\list.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(spreadsheet))) {
            String line;

            Set<String> programs = new HashSet<String>();
            Set<String> holding = new HashSet<String>();
            while ((line = br.readLine()) != null) {
                // use the no duplicate property of sets, the one on the bottom won't be mentioned in the holding ones


                int iterator = 0;
                // add parts to appropriate sets
                for (String phrase : line.split(" ")) {
                    // sort the Strings before adding to the Set
                    if(iterator == 0){
                        programs.add(phrase);
                    }
                    else if(iterator >=3){
                        holding.add(phrase.replaceAll(",",""));
                    }
                    iterator++;

                }

            }
           // System.out.println(programs);
           // System.out.println(holding);
            // find the program that wasn't mentioned
            for(String check: programs){
                if(holding.add(check)){
                    System.out.println(check);
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
