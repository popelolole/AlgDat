public class NB3 {
    public static void main(String[] args) {
        Node head = new Node();
        Node node = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        head.data = "Gilgamesh";
        node.data = "löper";
        node1.data = "på";
        node2.data = "stäppen";
        head.next = node;
        node.next = node1;
        node1.next = node2;

        Node p = head;
        if (p != null){
            while (p.next != null) {
                System.out.print(p.data + "->");
                p = p.next;
            }
            System.out.println(p.data);
        }

        node.next = node2;

        p = head;
        if (p != null){
            while (p.next != null) {
                System.out.print(p.data + "->");
                p = p.next;
            }
            System.out.println(p.data);
        }

        Node[] list = new Node[5];
        for(int i = 0;i < 5;i++){
            list[i] = new Node();
            if(i > 0)
                list[i-1].next = list[i];
        }

        list[0].data = "Jormungandr";
        list[1].data = "biter";
        list[2].data = "sig";
        list[3].data = "i";
        list[4].data = "svansen";

        p = list[0];
        if (p != null){
            while (p.next != null) {
                System.out.print(p.data + "->");
                p = p.next;
            }
            System.out.println(p.data);
        }

        node2.next = list[0];

        p = head;
        if (p != null){
            while (p.next != null) {
                System.out.print(p.data + "->");
                p = p.next;
            }
            System.out.println(p.data);
        }

        list[1].next = null;

        p = head;
        if (p != null){
            while (p.next != null) {
                System.out.print(p.data + "->");
                p = p.next;
            }
            System.out.println(p.data);
        }
    }
}
