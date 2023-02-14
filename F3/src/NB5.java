public class NB5 {
    public static void main(String[] args){
        PStack<Integer> stack = new PStack<>();

        stack.push(6);
        stack.push(4);
        stack.push(21);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
