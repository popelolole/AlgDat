public class NB23_1 {
    public static void main(String[] args){
        BinarySearchTree23_1<String> tree = new BinarySearchTree23_1<>();
        tree.add("H");
        tree.add("B");
        tree.add("N");
        tree.add("A");
        tree.add("F");
        tree.add("C");
        tree.add("G");
        tree.add("D");
        tree.add("E");
        System.out.println(tree.find("G"));
        System.out.println(tree.maxRec());
        System.out.println(tree.maxIt());
    }
}
