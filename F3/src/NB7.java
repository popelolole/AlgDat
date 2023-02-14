import java.util.Random;

public class NB7 {
    public static void main(String[] args){
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(21);
        stack.push(29);
        stack.push(3);

        Random rand = new Random();
        for(int i = 0;i < 100;i++)
            stack.push(rand.nextInt(100));
        System.out.println(stack.size());
        System.out.println(stack.peek(100));
        System.out.println(stack.flush());
        System.out.println(stack.size());
    }
}
