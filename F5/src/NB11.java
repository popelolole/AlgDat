import java.util.Random;

public class NB11 {
    public static void main(String[] args){
        int[] array = new int[30];
        Random rand = new Random();
        for(int i = 0;i < 30;i++) {
            array[i] = rand.nextInt(100) + 1;
            System.out.println(array[i]);
        }
        System.out.println("max: " + max(array));
    }

    static int max(int[] array){
        return max(array, 0, 0);
    }

    private static int max(int[] array, int position, int max){
        if(position == array.length)
            return max;
        if(array[position] > max)
            max = array[position];
        return max(array, position + 1, max);
    }
}
