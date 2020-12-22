import java.util.*;
interface AdvancedArithmetic{
  int divisor_sum(int n);
}

//Write your code here
class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        divisors.add(1);
        int total = 1;

        if (n != 1) {
            divisors.add(n);
            total += n;
        }

        for (int i = 2; i <= n / 2; i++) {
            int quotient = n / i;
            int remainder = n % i;

            if (remainder == 0) {
                if (!divisors.contains(i)) {
                    total += i;
                    divisors.add(i);
                }
                if (!divisors.contains(quotient)) {
                    total += quotient;
                    divisors.add(quotient);
                }
            }
        }

        return total;
    }
}

class Solution{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

