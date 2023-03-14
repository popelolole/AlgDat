import java.util.Random;

import static java.lang.Math.max;

public class NB46 {
    public static void main(String[] args){
        int n = 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1;
        int[] triangle = new int[n];
        Random rand = new Random();
        int l = 1, d = 1;
        for(int i = 0;i < n;i++){
            if(i == d){
                System.out.println();
                l++;
                d += l;
            }
            triangle[i] = rand.nextInt(10);
            System.out.print(triangle[i]);
        }
        System.out.println("\n\nMax sum: " + maxSum(triangle));
        System.out.println("Calls: " + simple);
        System.out.println("\n\nMax sum: " + maxSumDyn(triangle));
        System.out.println("Calls: " + dynamic);
        System.out.println("\n\nMax sum: " + maxSumBotUp(triangle));
        System.out.println("Calls: " + iterative);
    }

    static int simple = 0;
    static int dynamic = 0;
    static int iterative = 0;

    static int maxSum(int[] triangle){
        return maxSum(triangle, 0, 1);
    }

    private static int maxSum(int[] triangle, int index, int level){
        simple++;
        if(index + level + 1 > triangle.length){
            return triangle[index];
        }
        else{
            int left = maxSum(triangle, index + level, level + 1);
            int right = maxSum(triangle, index + level + 1, level + 1);
            return triangle[index] + max(left, right);
        }
    }

    static int maxSumDyn(int[] triangle){
        return maxSumDyn(triangle, 0, 1);
    }

    private static int maxSumDyn(int[] triangle, int index, int level){
        dynamic++;
        if(tab[index] != 0)
            return (int) tab[index];
        if(index + level + 1 > triangle.length){
            return triangle[index];
        }
        else{
            int left = maxSumDyn(triangle, index + level, level + 1);
            int right = maxSumDyn(triangle, index + level + 1, level + 1);
            return (int) (tab[index] = triangle[index] + max(left, right));
        }
    }

    static int maxSumBotUp(int[] triangle){
        int level = 1, d = 1;
        for(int i = 0;i < triangle.length;i++) {
            if (i == d) {
                level++;
                d += level;
            }
        }
        d = 0;
        for(int i = triangle.length - 1;i >= triangle.length - level - 1;i--){
            tab2[i] = triangle[i];
        }
        for(int i = triangle.length - 1;i >= 0;i--){
            iterative++;
            d++;
            if(d == level){
                level--;
                d = 1;
                i--;
            }
            if(i > 0) {
                int index = i - level;
                tab2[index] = triangle[index] + max(tab2[i], tab2[i - 1]);
            }
        }
        return (int) tab2[0];
    }

    static long[] tab = new long[1000];
    static long[] tab2 = new long[1000];
}
