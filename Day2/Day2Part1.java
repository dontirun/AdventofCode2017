package Day2;

import java.io.*;
import java.util.Scanner;

public class Day2Part1 {

    public static void main(String[] args) {
        File spreadsheet = new File("C:\\Users\\donti\\Documents\\GitHub\\AdventOfCode\\src\\spreadsheet.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(spreadsheet))) {
            String line;
            int checksum = 0;
            while ((line = br.readLine()) != null) {
                String [] numbers = line.split("\\s+");
                System.out.println(numbers);
                outerloop:
                for(int i = 0; i < numbers.length-1;i++){
                    for (int j = i+1 ; j< numbers.length;j++ ){
                        int first = Integer.parseInt(numbers[i]);
                        int second = Integer.parseInt(numbers[j]);
                        if(first > second){
                            if(first%second == 0){
                                checksum += first/second;
                                break outerloop;
                            }
                        }
                        if(second > first){
                            if(second%first == 0){
                                checksum += second/first;
                                break outerloop;
                            }
                        }
                    }
                }

            }
            System.out.println(checksum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
