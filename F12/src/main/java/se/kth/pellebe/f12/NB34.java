package se.kth.pellebe.f12;

import java.util.Arrays;

public class NB34 {
    public static void main(String[] args){
        System.out.println(
                Arrays.toString(change(789, new int[]{1000, 500, 100, 50, 20, 10, 5, 1})));
    }

    public static int[] change(int amount, int[] currency){
        int i = 0;
        int[] change = new int[currency.length];
        while(amount > 0){
            if(currency[i] <= amount){
                change[i]++;
                amount -= currency[i];
            }
            else{
                i++;
            }
        }

        return change;
    }
}
