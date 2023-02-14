import java.util.Scanner;

public class NB4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String expression;
        while(true){
            System.out.println("Enter an expression");
            expression = scan.nextLine();

            if(expression.equals(""))
                break;

            if(ParenChecker.isBalanced(expression))
                System.out.println("Expression is balanced.");
            else
                System.out.println("Expression is not balanced");
        }
    }
}
