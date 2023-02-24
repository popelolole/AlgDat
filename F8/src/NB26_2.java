import java.util.HashSet;

public class NB26_2 {
    public static void main(String[] args){
        String[] array = {"Kaktus", "Vattenkokare", "Minecraft", "Pelle", "Minecraft",
        "Battlefield", "Vattenkokare", "Ris", "Michelle"};
        System.out.println(unique(array));
    }

    public static int unique(String[] array){
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i < array.length;i++){
            if(set.add(array[i]))
                count++;
            else
                count--;
        }
        return count;
    }
}
