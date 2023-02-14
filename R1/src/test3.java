import java.util.Iterator;

public class test3 {
    public static void main(String[] args){
        LinkedList3<String> l = new LinkedList3<>();
        for(int i=0; i<4; i++){ l.add("e" + i);}
        Iterator<String> iter = l.iterator();
        iter.remove();
        System.out.println(l);
    }
}
