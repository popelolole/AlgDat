import java.util.Arrays;
import java.util.Scanner;

public class U5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Skriv valfri ordning av bokstäverna A, B, C, D och E");
            String input = scan.nextLine();
            char[] letters = input.toUpperCase().toCharArray();
            Arrays.sort(letters);
            if (Arrays.equals(letters, new char[]{'A', 'B', 'C', 'D', 'E'})) {
                letters = input.toUpperCase().toCharArray();
                String solution = sort(letters);
                System.out.println("Snabbaste lösningen: " + solution + " - " + solution.length() + " drag.");
            } else {
                System.out.println("Invalid input.");
                break;
            }
        }
    }

    static String sort(char[] letters){
        return sort(letters, 0, "");
    }

    private static final String MAX_SOLUTION_LENGTH = "AAAAAAAAAAAAAAA";

    private static String sort(char[] letters, int count, String solution){
        if (Arrays.equals(letters, new char[]{'A', 'B', 'C', 'D', 'E'})) {
            return solution;
        }
        else{
            String b = MAX_SOLUTION_LENGTH;
            String s = MAX_SOLUTION_LENGTH;
            if(count < 15) {
                b = sort(b(letters.clone()), count + 1, solution + 'b');

                s = sort(s(letters.clone()), count + 1, solution + 's');
            }
            return b.length() < s.length() ? b : s;
        }
    }

    private static char[] b(char[] letters){
        char tmp;
        tmp = letters[0];
        letters[0] = letters[1];
        letters[1] = tmp;
        return letters;
    }

    private static char[] s(char[] letters){
        char tmp;
        tmp = letters[4];
        for(int i = 4;i > 0;i--)
            letters[i] = letters[i - 1];
        letters[0] = tmp;
        return letters;
    }
}
