import java.util.Arrays;

import static java.lang.Math.min;

public class NB43 {
    public static void main(String[] args){
        int[] currency = new int[]{1,5,10,20,50,100,1000};
        int exchanges = change(currency, 49);
        System.out.println("Currency: " + Arrays.toString(currency));
        System.out.println("Exchanges done: " + exchanges);
    }

    public static int change(int[] currency, int amount){
        for(int i = 0;i < currency.length;i++){
            if(currency[i] == amount){
                return 1;
            }
        }
        int best = 100000;
        for(int i = 0;i < currency.length;i++){
            if(currency[i] < amount){
                best = min(best, 1 + change(currency, amount - currency[i]));
            }
        }
        return best;
    }
}
