import java.util.EmptyStackException;
import java.util.Stack;

public class InfixToPostfixEvaluator {

    public static class SyntaxErrorException extends Exception{
        SyntaxErrorException(String message){
            super(message);
        }
    }
    private Stack<Integer> operandStack;
    private Stack<Character> operatorStack;
    private static final String OPERATORS = "+-*/";
    private static final int[] PRECEDENCE =  {1, 1, 2, 2};
    private StringBuilder postfix;

    public int evaluate(String infix)  throws SyntaxErrorException {
        operandStack = new Stack<>();
        convert(infix);
        String[] tokens = postfix.toString().split(" +");
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    evalOp(nextToken.charAt(0));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered.");
                }
            }
            int result = operandStack.pop();
            if (!operandStack.empty()) {
                throw new SyntaxErrorException("Stack not empty after result returned.");
            }
            return result;
        } catch(EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: The stack is empty.");
        }
    }

    public String convert(String infix) throws SyntaxErrorException {
        operatorStack = new Stack<>();
        postfix = new StringBuilder();

        String[] tokens = infix.split("\\s+");
        try{
            for(String nextToken : tokens){
                char firstChar = nextToken.charAt(0);
                if(Character.isJavaIdentifierPart(firstChar) || Character.isDigit(firstChar)){
                    postfix.append(nextToken);
                    postfix.append(' ');
                }
                else if(isOperator(firstChar)) {
                    processOperator(firstChar);
                }
                else{
                    throw new SyntaxErrorException("Unexpected Character Encountered: "
                            + firstChar);
                }
            }

            while(!operatorStack.empty()){
                char op = operatorStack.pop();
                postfix.append(op);
                postfix.append(' ');
            }

            return postfix.toString();
        } catch(EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    private void processOperator(char op){
        if(operatorStack.empty()){
            operatorStack.push(op);
        }
        else{
            char topOp = operatorStack.peek();
            if(precedence(op) > precedence(topOp)){
                operatorStack.push(op);
            }
            else{
                while(!operatorStack.empty() && precedence(op) <= precedence(topOp)){
                    operatorStack.pop();
                    postfix.append(topOp);
                    postfix.append(' ');
                    if(!operatorStack.empty()){
                        topOp = operatorStack.peek();
                    }
                }
                operatorStack.push(op);
            }
        }
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

    private int precedence(char op){
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }
}
