import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                
                String paddedS1 = String.format("%-15s", s1);
                String paddedX = String.format("%3s", x).replace(' ', '0');
                
                System.out.println(paddedS1 + paddedX);
            }
            System.out.println("================================");

    }
}



