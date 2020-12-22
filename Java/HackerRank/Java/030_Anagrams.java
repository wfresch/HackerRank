import java.util.Scanner;

public class Solution {

    // Complete the function
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        
        a = a.toUpperCase();
        b = b.toUpperCase();

        java.util.Hashtable<Character, Integer> aCharacterCounts = GetCharacterCounts(a);
        java.util.Hashtable<Character, Integer> bCharacterCounts = GetCharacterCounts(b);

        if (aCharacterCounts.size() != bCharacterCounts.size()) {
            return false;
        }

        for ( Character c : aCharacterCounts.keySet() ) {
            if (!bCharacterCounts.containsKey(c)) {
                return false;
            }
            
            if (aCharacterCounts.get(c) != bCharacterCounts.get(c)) {
                return false;
            }
        }

        return true;
    }

    private static java.util.Hashtable<Character, Integer> GetCharacterCounts(String input) {
        java.util.Hashtable<Character, Integer> characterCounts = new java.util.Hashtable<Character, Integer>();

        for (int i=0; i < input.length(); i++) {
            Character c = input.charAt(i);

            if (characterCounts.containsKey(c)) {
                characterCounts.put(c, characterCounts.get(c) + 1);
            }
            else {
                characterCounts.put(c, 1);
            }
        }

        return characterCounts;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}