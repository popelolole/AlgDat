import java.util.Scanner;

public class NB21 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        String input;
        while(true) {
            System.out.println("Enter string: ");
            input = scan.nextLine();
            if(input.equals(""))
                break;
            tree.add(input);
        }
        System.out.println(tree.toString());
    }
}
