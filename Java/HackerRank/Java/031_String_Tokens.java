import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();

        //String[] tokens = s.split("[A-Za-z !,?._'@]");
        String[] tokens = s.split("[ ']");

        //!,?._'
        int tokenCount = tokens.length;
        
        System.out.println(tokenCount);

        for (int i=0; i < tokenCount; i++) {
            String token = tokens[i].replaceAll("[!,?._]", "");
            System.out.println(token);
            //System.out.println(tokens[i]);
        }

    }
}

