import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int mostCommonBird = 1;
        int maxSightings = 0;

        for (int i = 1; i <= 5; i ++) {
            counts.put(i, 0);
        }

        for (Integer bird : arr) {
            counts.put(bird, counts.get(bird) + 1);
        }

        for (int i = 1; i <= 5; i ++) {
            int sightings = counts.get(i);
            if (sightings > maxSightings) {
                maxSightings = sightings;
                mostCommonBird = i;
            }
        }

        return mostCommonBird;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
