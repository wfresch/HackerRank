import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int lineNumber = 0;
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            lineNumber ++;
            String line = scan.nextLine();
            System.out.println(lineNumber + " " + line);
        }
    }
}