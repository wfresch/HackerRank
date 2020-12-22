import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numberOfItems = scan.nextInt();
        int[] masterArray = new int[numberOfItems];

        int negativeSumCount = 0;
        
        for (int i = 0; i < numberOfItems; i++) {
            int x = scan.nextInt();
            masterArray[i] = x;
        }
        scan.close();

        for (int i = 0; i < numberOfItems; i ++) {
            for (int j = numberOfItems; j > i; j --) {
                int[] subarray = Arrays.copyOfRange(masterArray, i, j);
                int arraySum = 0;

                for (int s = 0; s < subarray.length; s++) {
                    //System.out.print(subarray[s] + " ");
                    arraySum += subarray[s];
                }
                //System.out.println("Sum for subarray (" + i + ", " + j + ") is: " + arraySum);

                if (arraySum < 0) {
                    // int subarrayCount = subarray.length;
                    // int firstItem = subarray[0];
                    // int lastItem = subarray[subarrayCount-1];

                    //System.out.println("Number of items: " + subarrayCount + ", First item: " + firstItem + ", Last item: " + lastItem);
                    negativeSumCount++;
                }
            }
        }

        System.out.println(negativeSumCount);

    }
}