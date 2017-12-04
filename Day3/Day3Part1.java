package Day3;

import java.awt.*;

public class Day3Part1 {

    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);

        int sidelength =1;
        int corner = 1;
        int ring = 0;
        Point location;

        // finding which ring you are one
        while(target > corner){
            sidelength += 2;
            corner = sidelength * sidelength;
            ring++;
        }

        location = new Point(ring,-ring);
        int difference = corner - target;

        // bottom side
        if(difference <= sidelength -1){
            location.x -= difference;
        }
        //left side
        else if (difference <= 2*(sidelength -1)){
            location.x -= (sidelength-1);
            location.y += (difference - sidelength -1);
        }
        //top side
        else if (difference <= 3*(sidelength -1)){
            location.x -= (sidelength-1 -(difference -2*sidelength));
            location.y += (sidelength-1);
        }
        //right side
        else{
            location.y += (sidelength-1 - (difference - 3*sidelength));
        }

        int steps = Math.abs(location.x) + Math.abs(location.y);

        System.out.println(steps);


    }
}