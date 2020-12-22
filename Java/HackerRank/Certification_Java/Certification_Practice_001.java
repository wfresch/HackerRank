import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
    // Write your code here
        for (int i = 1; i <= n; i++) {
            System.out.println(fizzBuzzIndividual(n));
        }

    }

    private static String fizzBuzzIndividual(int n) {
        boolean divisibleByThree = (n % 3) == 0; 
        boolean divisibleByFive = (n % 5) == 0; 
        
        if (divisibleByThree) {
            if (divisibleByFive) {
                return "FizzBuzz";
            }
            else {
                return "Fizz";
            }
        }
        else {
            if (divisibleByFive) {
                return "Buzz";
            }
            else {
                return ((Integer) n).toString();
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}
