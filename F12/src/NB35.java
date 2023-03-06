import java.util.Scanner;

import static java.lang.Math.pow;

public class NB35 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Ange vikt på kappsäcken (kg): ");
        int knapsack = scan.nextInt();
        System.out.println("Hur många varor ska användas? ");
        int length = scan.nextInt();
        Item[] items = new Item[length];
        for(int i = 0;i < items.length;i++){
            System.out.println("Ange pris på vara (kr): ");
            int value = scan.nextInt();
            System.out.println("Ange vikt på vara (kg): ");
            int weight = scan.nextInt();
            items[i] = new Item(value, weight);
        }
        System.out.println("Value of knapsack: " + knapsack(knapsack, items));
        System.out.println("Times each item was used: ");
        for (Item item : items) {
            System.out.println(item.toString() + ": " + item.used + " times.");
        }
    }

    public static int knapsack(int weight, Item[] items){
        radixSort(items);

        int i = items.length - 1, filled = 0;
        int finalValue = 0;
        while(filled <= weight){
            if(items[i].weight + filled <= weight){
                filled += items[i].weight;
                finalValue += items[i].value;
                items[i].used++;
            }
            else{
                i--;
                if(i < 0)
                    break;
            }
        }

        return finalValue;
    }

    private static class Item{
        int value;
        int weight;
        float valuePerWeight;
        int used;

        public Item(int value, int weight){
            this.value = value;
            this.weight = weight;
            valuePerWeight = (float) Math.round(((float) value / (float) weight) * 100) / (float) 100;
            used = 0;
        }

        @Override
        public String toString() {
            return "[ " + value + "kr, " + weight + "kg, " + valuePerWeight + "kr/kg ]";
        }
    }

    private static void radixSort(Item[] v){
        int[] count = new int[10];
        Item[] output = new Item[v.length];
        for(int d = -2;d <= 1;d++) {
            for (int i = 0; i < v.length; i++) {
                count[(int) (v[i].valuePerWeight%pow(10,d)/pow(10,d-1))]++;
            }
            for(int i = 0;i < count.length - 1;i++){
                count[i+1] = count[i] + count[i+1];
            }
            for(int i = v.length - 1;i >= 0;i--){
                output[--count[(int) (v[i].valuePerWeight%pow(10,d)/pow(10,d-1))]] = v[i];
            }
            System.arraycopy(output, 0, v, 0, v.length);
            count = new int[10];
        }
    }
}
