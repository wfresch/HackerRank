import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] _arr = new int[6][6];
    
    public static void main(String[] args) {
        // int[][] arr = new int[6][6];
        int[] hourglassSums = new int[16];
        int maxSum = -64;

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                _arr[i][j] = arrItem;
            }
        }
        scanner.close();

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                int sum = getHourglassSum(r, c);
                int index = (r*4) + c;
                hourglassSums[index] = sum;
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println(maxSum);
    }

    private static int getHourglassSum(int row, int column) {
        int sum = 0;
        sum += getHourglassEdgeSum(row, column);
        sum += _arr[row+1][column+1];
        sum += getHourglassEdgeSum(row+2, column);
        
        return sum;
    }

    private static int getHourglassEdgeSum(int row, int column) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += (_arr[row][column+i]);
        }

        return sum;
    }
}
