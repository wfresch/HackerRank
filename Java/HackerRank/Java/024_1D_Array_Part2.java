import java.util.*;

public class Solution {

    //static int[] game;

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int gameLength = game.length;
        int cursor = 0;
        boolean[] steppedOn = new boolean[gameLength];

        while (cursor < gameLength) {
            steppedOn[cursor]=true;

            int move = cursor+1;
            if (move >= gameLength) {
                return true;
            }
            else if (game[move] == 0 && !steppedOn[move]) {
                //System.out.println("I can step forward to " + move);
                cursor = move;
                continue;
            }
            
            if (leap > 0) {
                move = cursor+leap;
                if (move >= gameLength) {
                    return true;
                }
                else if (game[move] == 0 && !steppedOn[move]) {
                    //System.out.println("I can leap forward to " + move);
                    cursor = move;
                    continue;
                }
            }

            move = cursor-1;
            if (move < 0) {
                return false;
            }
            else if (game[move] == 0 && !steppedOn[move]) {
                //System.out.println("I can step backward to " + move);
                cursor = move;
                continue;
            }
            //System.out.println("Returning false within WHILE-loop.");
            //return false;
            break;
        }
        //System.out.println("Returning false by default.");
        return false;
    }

    private static boolean canMove(int destination, int[] game) {
        if (destination >= game.length) {
            return true;
        }
        else {
            return (game[destination] == 0);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}