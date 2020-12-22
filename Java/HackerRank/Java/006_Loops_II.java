import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            String result = GetResponses(a, b, n);
            System.out.println(result);
        }
        in.close();
    }

    private static String GetResponses(int argA, int argB, int argN) {
        int total = argA;
        String result = "";

        for (int i=0; i<argN; i++) {
            total += Math.pow(2, i) * argB;
            result += "" + total + " ";
        }
        result = result.trim();
        return result;
    }
}