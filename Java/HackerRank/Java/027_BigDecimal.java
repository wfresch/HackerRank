import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        //Write your code here
        BigDecimal[] decimals = new BigDecimal[n];
        for (int i = 0; i < n; i++) {
            BigDecimal decimal = new BigDecimal(s[i]);
            decimals[i] = decimal; 
        }
        Arrays.sort(decimals, Collections.reverseOrder()); 

        // for each item in sorted BigDecimal array
        for (int i = 0; i < decimals.length; i ++) {

            // start looking through the Strings array for a match
            for (int j = 0; j < decimals.length; j ++) {
                BigDecimal decimal = new BigDecimal(s[j]);

                // if you find a match, swap Strings[decimalIndex] with Strings[stringIndex]
                if (decimals[i].equals(decimal)) {
                    String currentOccupant = s[i];
                    s[i] = s[j];
                    s[j] = currentOccupant;
                    break;
                }
            }
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }



}