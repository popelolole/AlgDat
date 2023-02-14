public class NB17 {
    public static void main(String[] args){
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for(int i = 0;i < 20;i++){
            list.add("i" + (i + 1));
        }
        System.out.println(list.toString());

        System.out.println(list.get(10));
        System.out.println(list.size());
    }
}
