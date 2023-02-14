import java.util.ArrayList;

public class P1 {

    /** Replaces each occurrence of oldItem in aList with newItem. **/
    public static void replace(ArrayList<String> aList, String oldItem, String newItem){
        for(int i = 0;i < aList.size();i++){
            if(aList.get(i).equals(oldItem))
                aList.set(i, newItem);
        }
    }

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();

        list.add("Hej");
        list.add("Hej");
        list.add("test");
        list.add("blabla");
        list.add("grrrg");
        list.add("Hej");
        list.add("Hej");
        list.add("Snö");

        System.out.println(list.toString());
        replace(list, "Hej", "Hejsan");
        System.out.println(list.toString());
    }
}
