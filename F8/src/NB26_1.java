import java.util.HashMap;
import java.util.Map;

public class NB26_1 {
    public static void main(String[] args){
        String[] array = {"Pelle", "Kaktus", "Människa", "Tandpetare", "Michelle", "Pelle",
        "Michelle", "Michelle", "Dator", "Dator", "Skärm", "Pelle", "Michelle"};
        System.out.println(mostCommonString(array));
    }

    public static int mostCommonString(String[] array){
        HashMap<String, Integer> map = new HashMap<>(37);
        for(int i = 0;i < array.length;i++){
            int value = 0;
            if(map.get(array[i]) != null)
                value = map.get(array[i]);
            map.put(array[i], value + 1);
        }
        int max = 0;
        for(int value : map.values()){
            if(value > max)
                max = value;
        }
        return max;
    }
}
