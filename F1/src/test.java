import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        PArrayList<String> list = new PArrayList<>();

        list.add("Hej");
        list.add("jag");
        list.add("heter");
        list.add("Pelle");
        list.add("...");
        list.add("blablabla");
        list.add("Programmering");
        list.add("är");
        list.add("kul");
        list.add("ibland");

        System.out.println(list.toString());

        list.add(5, "gbgbgbgbg");

        System.out.println(list.toString());

        System.out.println(list.get(7));
        list.set(10, "då och då");
        System.out.println(list.toString());

        System.out.println(list.remove(10));
        System.out.println(list.toString());

        System.out.println(list.indexOf("blablabla"));
    }
}
