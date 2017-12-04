package Day3;

import javafx.util.Pair;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Day3Part2 {
    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);

        Map<Pair<Integer,Integer>,Integer> map = new HashMap<Pair<Integer, Integer>, Integer>();

        int current =1;
        int previousCornerX = 0;
        int previousCornerY = 0;
        int pairX = 0;
        int pairY = 0;

        map.put(new Pair<>(pairX,pairY),current);
        int corner = 1;
        int ring = 0;

        int sidelength = 1;
        Point location;

        // finding which ring you are one
        boolean first = true;
        finder:
        while(true){
            sidelength +=2;
            ring++;
            int ringSize = 8*ring;
            for(int i = 0;i <ringSize;i++){
                //right side
                if(i < sidelength -1){
                    if(first) {
                        pairX = previousCornerX + 1;
                        pairY = previousCornerY;
                        first = false;
                    }
                    else{
                        pairY++;
                    }
                }
                //top side
                else if(i < 2*(sidelength-1)) {
                    pairX--;
                }
                else if(i < 3*(sidelength-1)) {
                    pairY--;
                }
                else{
                    pairX++;
                }
                // calculating values based on values around
                int temp = (Optional.ofNullable(map.get(new Pair<>(pairX+1,pairY))).orElse(0));

                temp += (Optional.ofNullable(map.get(new Pair<>(pairX+1,pairY+1))).orElse(0));

                temp += (Optional.ofNullable(map.get(new Pair<>(pairX,pairY+1))).orElse(0));

                temp += (Optional.ofNullable(map.get(new Pair<>(pairX-1,pairY+1))).orElse(0));

                temp += (Optional.ofNullable(map.get(new Pair<>(pairX-1,pairY))).orElse(0));

                temp += (Optional.ofNullable(map.get(new Pair<>(pairX-1,pairY-1))).orElse(0));

                temp += (Optional.ofNullable(map.get(new Pair<>(pairX,pairY-1))).orElse(0));

                temp += (Optional.ofNullable(map.get(new Pair<>(pairX+1,pairY-1))).orElse(0));


                current = temp;
                //System.out.println(current);
                if (current > target){
                    System.out.print(current);
                    break finder;
                }
                else{
                    map.put(new Pair<>(pairX,pairY),current);
                }
            }
            previousCornerX = pairX;
            previousCornerY = pairY;
            first =true;
        }



    }
}
