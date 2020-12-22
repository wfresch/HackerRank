import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();

        for (int i=1; i <= 10; i++) {
            String output = GetSingleMultiple(N, i);
            System.out.println(output);
        }

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
    }

    private static String GetSingleMultiple(int input, int multiple) {
        int product = input * multiple;
        String output = "" + input + " x " + multiple + " = " + product + "";
        return output;
    }

    
}
