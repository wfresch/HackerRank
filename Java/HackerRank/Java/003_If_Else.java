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
        boolean isWeird = IsWeird(N);
        System.out.println(isWeird ? "Weird" : "Not Weird");

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
    }

    private static boolean IsWeird(int input) {
        if (input % 2 == 1) {
            return true;
        }
        else if (input >= 2 && input <= 5) {
            return false;
        }
        else if (input >= 6 && input <= 20) {
            return true;
        }
        return false;
    }
}
