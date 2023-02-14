import java.util.Random;

public class NB2 {
    public static void main(String[] args){
        IntList list = new IntList(10);

        Random rand = new Random();
        for(int i = 0;i < 100;i++)
            list.add(rand.nextInt(10));
        System.out.println(list.toString());
        System.out.println("size: " + list.size());
        System.out.println("space: " + list.space());
        for(int i = 0;i < 90;i++)
            list.remove(0);

        System.out.println(list.toString());
        System.out.println("size: " + list.size());
        System.out.println("space: " + list.space());

        System.out.println("4: " + list.get(4));
        list.add(4, 22);
        list.set(3, 0);
        System.out.println(list.toString());
        System.out.println("index(22): " + list.indexOf(22));
    }
}
