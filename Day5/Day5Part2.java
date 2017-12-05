package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("JumpOffsets"));
        ArrayList<Integer> jumps = new ArrayList<>();
        while (scan.hasNextInt()) {
            jumps.add(scan.nextInt());
        }

        //System.out.println(jumps);
        int totalSteps = 0;
        int index = 0;
        int prevIndex = 0;
        // keep going until you get an index out of array bounds
        while(index < jumps.size()){
            prevIndex= index;
            index += jumps.get(index);
            boolean increase = jumps.get(prevIndex)<3;
            if(increase){
                jumps.set(prevIndex, jumps.get(prevIndex)+1);
            }
            else{
                jumps.set(prevIndex, jumps.get(prevIndex)-1);
            }
            totalSteps++;
        }

        System.out.println(totalSteps);
    }
}
