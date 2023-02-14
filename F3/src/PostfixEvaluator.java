import java.util.EmptyStackException;
import java.util.Stack;

public class PostfixEvaluator {
    public static class SyntaxErrorException extends Exception{
        SyntaxErrorException(String message){
            super(message);
        }
    }
    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;

    public PostfixEvaluator(){
        operandStack = new Stack<>();
    }

    private int evalOp(char op){
        int opRight = operandStack.pop();
        int opLeft = operandStack.pop();
        int result;
        switch(op){
            case '+':
                result = opLeft + opRight;
                operandStack.push(result);
                break;
            case '-':
                result = opLeft - opRight;
                operandStack.push(result);
                break;
            case '*':
                result = opLeft * opRight;
                operandStack.push(result);
                break;
            case '/':
                result = opLeft / opRight;
                operandStack.push(result);
                break;
            default:
                result = -1;
        }
        return result;
    }

    private boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException{
        String[] tokens = expression.split(" +");
        try{
            for(String nextToken : tokens){
                if(Character.isDigit(nextToken.charAt(0))){
                    operandStack.push(Integer.parseInt(nextToken));
                }
                else if(isOperator(nextToken.charAt(0))){
                    evalOp(nextToken.charAt(0));
                } else{
                    throw new SyntaxErrorException("Invalid character encountered.");
                }
            }
            int result = operandStack.pop();
            if(!operandStack.empty()){
                throw new SyntaxErrorException("PStack not empty after result returned.");
            }
            return result;
        } catch(EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: The stack is empty.");
        }
    }
}
