public class U8 {
    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        BinarySearchTree.buildTree(tree, new int[]{30, 20, 40, 15, 25, 35, 45, 10, 17,
                22, 27, 32,37, 42, 47, 16, 23, 28, 39, 49, 29, 51});

        for(int i = 0;i < 52;i++)
            System.out.println("" + i + ":" + tree.getNextLarger(i));
    }
}
