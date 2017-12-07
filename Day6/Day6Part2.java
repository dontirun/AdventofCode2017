package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6Part2 {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("memoryBanks.txt"));
        // populate the arraylist with bank values
        ArrayList<Integer> jumps = new ArrayList<>();

        while (scan.hasNextInt()) {
            jumps.add(scan.nextInt());
        }
        int length = jumps.size();


        // use this to find the first duplicate configuration we find
        Set<Double> checkDuplicates = new LinkedHashSet<>();
        // keep going until we get a duplicate
        int loops = 0;
        for(;;){
            // create a hash for current configuration and find current highest value index
            Double hash = 0d;
            int highestValueIndex = 0;
            int highestValue = 0;
            for(int i=0; i<length;i++){
                int temp = jumps.get(i);
                if(temp > highestValue) {
                    highestValueIndex =i;
                    highestValue = temp;
                }
                hash += temp * Math.pow(10,i);
            }
          //  System.out.println(hash);
            // if we reach a duplicate
            if(!checkDuplicates.add(hash)){
                //System.out.println(hash);
                List<Double> list = new ArrayList<Double>(checkDuplicates);
                for(int i = 0; i<list.size();i++){
                    if(list.get(i).equals(hash)){
                        System.out.println(loops - i);
                        break;
                    }
                    else{
                        //System.out.println(list.get(i));
                    }
                }
                //System.out.println(loops);
                break;


            }
            // move the bank values
            jumps.set(highestValueIndex,0);
            int indexHolder = highestValueIndex;
            for(int i =0 ;i<highestValue;i++){
                int addIndex;
                if(indexHolder+i+1 >length-1){
                    indexHolder -= length;
                }
                addIndex = indexHolder+i+1;
                jumps.set(addIndex,jumps.get(addIndex)+1);
            }
          //System.out.println(jumps);
            loops++;


        }

    }

//
//    public int getLowestValueIndex(ArrayList<Integer> list){
//
//    }
}
