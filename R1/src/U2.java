public class U2 {
    public static void main(String[] args){
        LinkedList2<String> list = new LinkedList2<>();

        list.add("Hej");
        list.add("Detta");
        list.add("Är");
        list.add("En");
        list.add("Lista.");

        System.out.println(list.toString());

        System.out.println(list.size());

        list.remove(4);

        System.out.println(list.toString());

        list.remove(0);

        System.out.println(list.toString());

        list.add(3, "Jormungandr");

        System.out.println(list.toString());

        list.add(0, "Hejsan");

        System.out.println(list.toString());
    }
}
