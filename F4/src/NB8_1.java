public class NB8_1 {
    public static void main(String[] args){
        ArrayQueue8_1<String> queue = new ArrayQueue8_1<>(5);

        for(int i = 0;i < 15;i++){
            queue.offer("x" + (i + 1));
        }

        System.out.println(queue.toString());
        while(queue.peek() != null){
            System.out.println(queue.poll());
            System.out.println(queue.toString());
        }

        for(int i = 0;i < 6;i++){
            queue.offer("g" + (i + 1));
            System.out.println(queue.toString());
        }
    }
}
