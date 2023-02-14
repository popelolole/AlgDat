import java.util.Scanner;

public class P7 {
    public static void main(String[] args){
        InfixToPostfixEvaluator evaluator = new InfixToPostfixEvaluator();
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Enter an infix expression");
            String expression = scan.nextLine();

            if(!expression.equals("")){
                try{
                    int result = evaluator.evaluate(expression);
                    System.out.println("Value is " + result);
                }catch(InfixToPostfixEvaluator.SyntaxErrorException ex){
                    System.out.println("Syntax error " + ex.getMessage());
                }
            } else{
                break;
            }
        }
    }
}
