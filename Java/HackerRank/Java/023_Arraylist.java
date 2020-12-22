import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numberOfArrays = scan.nextInt();
        ArrayList<Integer>[] arrays = new ArrayList[numberOfArrays];

        for (int a = 0; a < numberOfArrays; a ++) {
            int numberOfItemsInArray = scan.nextInt();
            ArrayList<Integer> lineList = new ArrayList<Integer>();

            //System.out.print("lineList " + a + " contains: ");
            for (int j = 0; j < numberOfItemsInArray; j++) {
                int input = scan.nextInt();
                //System.out.print(input + " ");
                lineList.add(input);
            }
            //System.out.println();

            arrays[a] = lineList;
        }

        int numberOfQueries = scan.nextInt();
        
        for (int q = 0; q < numberOfQueries; q++) {
            int arrayNumber = scan.nextInt();
            int arrayIndex = scan.nextInt();

            if (arrayNumber <= arrays.length && arrayIndex <= arrays[arrayNumber-1].size()) {
                int output = arrays[arrayNumber-1].get(arrayIndex-1);
                System.out.println(output);
            }
            else {
                System.out.println("ERROR!");
            }
        }
    }
}