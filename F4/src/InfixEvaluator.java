import java.util.EmptyStackException;
import java.util.Stack;

public class InfixEvaluator {
    public static class SyntaxErrorException extends Exception{
        SyntaxErrorException(String message){
            super(message);
        }
    }
    private Stack<Character> parenStack;
    private Stack<Integer> operandStack;
    private Stack<Character> operatorStack;
    private static final String OPERATORS = "+-*/";


    public int evaluate(String infix) throws SyntaxErrorException {
        parenStack = new Stack<>();
        operandStack = new Stack<>();
        operatorStack = new Stack<>();

        String[] tokens = infix.split(" +");
        try{
            for(String nextToken : tokens){
                if(Character.isDigit(nextToken.charAt(0))){
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    if(parenStack.empty()) {
                        //evalOp(nextToken.charAt(0));
                    }
                    else{
                        operatorStack.push(nextToken.charAt(0));
                    }
                } else if (nextToken.charAt(0) == '('){
                    parenStack.push(nextToken.charAt(0));
                } else if (nextToken.charAt(0) == ')'){
                    if(parenStack.peek() == '('){
                        parenStack.pop();

                    }
                }
            }
        } catch(EmptyStackException ex){
            throw new SyntaxErrorException("");
        }
        return 0;
    }

    private boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }
}
