import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NB46_1 {
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
                System.out.println("Anrop: " + calls);
            } else {
                System.out.println("Invalid input.");
                break;
            }
        }
    }

    static String sort(char[] letters){
        calls = 0;
        tab = new HashMap<>();
        return sortRec(letters, 0);
    }

    private static final String MAX_SOLUTION_LENGTH = "AAAAAAAAAAAAAAA";
    static HashMap<String, String> tab;
    static int calls = 0;

    private static String sortRec(char[] letters, int count){
        calls++;
        if (isSorted(letters)) {
            return "";
        }
        else if(tab.containsKey(new String(letters))){
            return tab.get(new String(letters));
        }
        else if(count >= 15){
            return "X";
        }
        else {
            char[] arrB = b(letters);
            String resultB = tab.containsKey(new String(arrB)) ?
                    tab.get(new String(arrB)) : sortRec(arrB, count + 1);
            int numMovesB = resultB.replaceAll("X", "").length();

            char[] arrS = s(letters);
            String resultS = tab.containsKey(new String(arrS)) ?
                    tab.get(new String(arrS)) : sortRec(arrS, count + 1);
            int numMovesS = resultS.replaceAll("X", "").length();

            if (!resultB.contains("X") && (resultS.contains("X") || numMovesB < numMovesS)) {
                tab.put(new String(letters), "b" + resultB);
                return "b" + resultB;
            } else if (!resultS.contains("X")) {
                tab.put(new String(letters), "s" + resultS);
                return "s" + resultS;
            } else {
                return "X";
            }
        }
    }

    private static char[] b(char[] arr) {
        char[] newArr = new char[5];
        newArr[0] = arr[1];
        newArr[1] = arr[0];
        newArr[2] = arr[2];
        newArr[3] = arr[3];
        newArr[4] = arr[4];
        return newArr;
    }

    private static char[] s(char[] arr) {
        char[] newArr = new char[5];
        newArr[0] = arr[4];
        for (int i = 1; i < 5; i++) {
            newArr[i] = arr[i - 1];
        }
        return newArr;
    }

    private static boolean isSorted(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}

