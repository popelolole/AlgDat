import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class U6 {
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
        Queue<Tillstand> q = new LinkedList<>();
        Tillstand t = new Tillstand(letters, "");

        while(!Arrays.equals(t.letters, new char[]{'A', 'B', 'C', 'D', 'E'})){
            q.offer(new Tillstand(b(t.letters.clone()), t.solution + 'b'));
            q.offer(new Tillstand(s(t.letters.clone()), t.solution + 's'));

            t = q.poll();
        }

        return t.solution;
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

    private static class Tillstand{
        public char[] letters;
        public String solution;

        public Tillstand(char[] letters, String solution){
            this.letters = letters;
            this.solution = solution;
        }
    }
}
