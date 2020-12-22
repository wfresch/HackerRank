import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static Map<Integer, Integer> _monthDays = new HashMap<Integer, Integer>();

    static void InitializeMonthDays() {
        for (int i = 1; i <= 12; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    _monthDays.put(i, 31);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    _monthDays.put(i, 30);
                    break;
                case 2:
                    _monthDays.put(i, 28);
                    break;
            }
        }
    }
    
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        InitializeMonthDays();
        int firstEightMonths = FirstEightMonths(year);
        int remainingDays = 256 - firstEightMonths;

        String result = String.valueOf(remainingDays) + ".09." + String.valueOf(year);
        return result;
    }

    // private static int FirstEightMonths(boolean isLeapYear, boolean is1918) {
    private static int FirstEightMonths(int year) {
        int sum = 0;
        boolean isLeapYear = (year < 1918 && year % 4 == 0) || 
            (year > 1918 && (year % 400 == 0 || 
                (year % 4 == 0 && year % 100 != 0)));
        
        for (int i = 1; i <= 8; i++) {
            int currentMonthDays = _monthDays.get(i);
            
            if (i == 2) {
                if (year == 1918) {
                    currentMonthDays = 15;
                }
                else if (isLeapYear) {
                    currentMonthDays = 29;
                }
            }

            sum += currentMonthDays;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
