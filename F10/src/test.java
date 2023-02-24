public class test {
    public static void main(String[] args){
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(21);
        heap.insert(29);
        heap.insert(13);
        heap.insert(19);
        heap.insert(36);
        heap.insert(4);
        heap.insert(40);
        heap.insert(56);

        System.out.println(heap.toString());

        System.out.println(heap.extract());
        System.out.println(heap.toString());
        System.out.println(heap.extract());
        System.out.println(heap.toString());
    }
}
