import java.util.Iterator;

public class U3 {
    public static void main(String[] args){
        LinkedList3<String> list = new LinkedList3<>();

        list.add("Hejsan");
        list.add("Detta");
        list.add("Är");
        list.add("Ett");
        list.add("Test");

        System.out.println(list.toString());

        Iterator<String> iter = list.iterator();
        /*while(iter.hasNext()){
            iter.next();
            iter.remove();
            System.out.println(list.toString());
        }*/

        System.out.println(iter.next());
        iter.remove();
        System.out.println(list.toString());
        System.out.println(iter.next());
        System.out.println(list.toString());
        System.out.println(iter.next());
        iter.remove();
        System.out.println(list.toString());
        System.out.println(iter.next());
        System.out.println(list.toString());
        iter.remove();
        list.add("testesttest");
        System.out.println(iter.next());
        System.out.println(list.toString());
        System.out.println(iter.next());
        iter.remove();
        System.out.println(list.toString());

        //System.out.println(list.toString());
    }
}
