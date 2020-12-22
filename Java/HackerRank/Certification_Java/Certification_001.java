import java.util.*;
import java.util.regex.*;


// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser {
    public String isBalanced(String input) {
        //int length = input.length();
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i < input.length(); i++) {
            Character character = input.charAt(i);

            if (character.equals('{') || character.equals('(')) {
                stack.push(character);
            }
            
            if (character.equals('}')) {
                if (stack.size()>0 && stack.peek().equals('{')) {
                    stack.pop();
                }
                else {
                    stack.push(character);
                }
            }
            
            if (character.equals(')')) {
                if (stack.size()>0 && stack.peek().equals('(')) {
                    stack.pop();
                }
                else {
                    stack.push(character);
                }
            }
        }

        return (stack.size() == 0) ? "true" : "false";
    }
}

class Solution {
	
	public static void main(String[] args) {
		Parser parser = new Parser();
        
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			System.out.println(parser.isBalanced(in.next()));
		}
        
		in.close();
	}
}

/*
Your Output (stdout)
true
true
true (should be false)
false
false
true    (should be false)
false

Expected Output
true
true
false
false
false
false
false
*/