import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static BitSet bitSet1;
    static BitSet bitSet2;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int setLength = sc.nextInt();
        int lines = sc.nextInt();
        bitSet1 = new BitSet(setLength);
        bitSet2 = new BitSet(setLength);

        for(int i = 0;i<lines;i++) {
            String command = sc.next();
            int arg1 = sc.nextInt();
            int arg2 = sc.nextInt();

            switch (command) {
                case "AND":
                    AndOperation(arg1, arg2);
                    break;
                case "SET":
                    SetOperation(arg1, arg2);
                    break;
                case "FLIP":
                    FlipOperation(arg1, arg2);
                    break;
                case "OR":
                    OrOperation(arg1, arg2);
                    break;
                case "XOR":
                    XorOperation(arg1, arg2);
                    break;
            }
            System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
        }
    }

    private static void AndOperation(int arg1, int arg2) {
        if (arg1 == 1) {
            if (arg2 == 1) {
                bitSet1.and(bitSet1);
            } 
            else {
                bitSet1.and(bitSet2);
            }
        }
        else {
            if (arg2 == 1) {
                bitSet2.and(bitSet1);
            } 
            else {
                bitSet2.and(bitSet2);
            }
        }
    }

    private static void SetOperation(int arg1, int arg2) {
        if (arg1 == 1) {
            bitSet1.set(arg2);
        }
        else {
            bitSet2.set(arg2);
        }
    }

    private static void FlipOperation(int arg1, int arg2) {
        if (arg1 == 1) {
            bitSet1.flip(arg2);
        }
        else {
            bitSet2.flip(arg2);
        }
    }

    private static void OrOperation(int arg1, int arg2) {
        if (arg1 == 1) {
            if (arg2 == 1) {
                bitSet1.or(bitSet1);
            } 
            else {
                bitSet1.or(bitSet2);
            }
        }
        else {
            if (arg2 == 1) {
                bitSet2.or(bitSet1);
            } 
            else {
                bitSet2.or(bitSet2);
            }
        }
    }

    private static void XorOperation(int arg1, int arg2) {
        if (arg1 == 1) {
            if (arg2 == 1) {
                bitSet1.xor(bitSet1);
            } 
            else {
                bitSet1.xor(bitSet2);
            }
        }
        else {
            if (arg2 == 1) {
                bitSet2.xor(bitSet1);
            } 
            else {
                bitSet2.xor(bitSet2);
            }
        }
    }
}