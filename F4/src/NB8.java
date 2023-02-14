public class NB8 {
    public static void main(String[] args){
        ArrayQueue<String> queue = new ArrayQueue<>(10);

        for(int i = 0;i < 10;i++)
            queue.offer("x" + (i + 1));

        while(queue.peek() != null) {
            System.out.println(queue.poll());
            System.out.println(queue.space());
        }
    }
}
