import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        //Date date = new Date(year, month, day);
        Calendar calendar = Calendar.getInstance();
        
        //Date date = 
        calendar.set(year, month-1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String dayName = "";
        
        switch (dayOfWeek) {
            case 1: 
                dayName = "SUNDAY";
                break;
            case 2: 
                dayName = "MONDAY";
                break;
            case 3: 
                dayName = "TUESDAY";
                break;
            case 4: 
                dayName = "WEDNESDAY";
                break;
            case 5: 
                dayName = "THURSDAY";
                break;
            case 6: 
                dayName = "FRIDAY";
                break;
            case 7: 
                dayName = "SATURDAY";
                break;
        }

        return dayName;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
