import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Locale indiaLocale = new Locale("en", "IN");

        System.out.println(GetFormattedString("US", payment, Locale.US));
        System.out.println(GetFormattedString("India", payment, indiaLocale));
        System.out.println(GetFormattedString("China", payment, Locale.CHINA));
        System.out.println(GetFormattedString("France", payment, Locale.FRANCE));
    }

    private static String GetFormattedString(String description, double input, Locale locale) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String output = numberFormat.format(input);
        String response = description + ": " + output;

        return response;
    }
}