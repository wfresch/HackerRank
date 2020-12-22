import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        sc.close();

        int inputLength = A.length();
        StringBuilder reversed = new StringBuilder(A);

        for (int i = 0; i < inputLength; i++) {
            int position = (inputLength - 1 - i);
            reversed.setCharAt(position, A.charAt(i));
        }

        String output = A.equals(reversed.toString()) ? "Yes" : "No";
        System.out.println(output);
    }
}



