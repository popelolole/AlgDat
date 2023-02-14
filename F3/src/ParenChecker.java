import java.util.EmptyStackException;
import java.util.Stack;

public class ParenChecker {
    private static final String OPEN = "([{";
    private static final String CLOSE = ")]}";

    public static boolean isBalanced(String expression){
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        try{
            int index = 0;
            while(balanced && index < expression.length()){
                char paren = expression.charAt(index);
                if(isOpen(paren)){
                    stack.push(paren);
                }
                else if(isClose(paren)){
                    char top = stack.pop();
                    balanced = (OPEN.indexOf(top) == CLOSE.indexOf(paren));
                }
                index++;
            }
        } catch(EmptyStackException ex){
            balanced = false;
        }
        return balanced;
    }

    private static boolean isOpen(char ch){
        return OPEN.indexOf(ch) > -1;
    }

    private static boolean isClose(char ch){
        return CLOSE.indexOf(ch) > -1;
    }
}
