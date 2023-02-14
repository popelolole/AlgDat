public class NB23 {
    public static void main(String[] args){
        BinarySearchTreeNB23<String> tree = new BinarySearchTreeNB23<>();
        tree.add("H");
        tree.add("B");
        tree.add("N");
        tree.add("A");
        tree.add("F");
        tree.add("C");
        tree.add("G");
        tree.add("D");
        tree.add("E");
        tree.printTree();
        System.out.println(tree.numberOfLeaves());
        System.out.println(tree.numberOfNodes());
        System.out.println(tree.height());
    }
}
