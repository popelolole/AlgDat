import java.util.Random;

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
    }

    static int simple = 0;

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
            return triangle[index] + Math.max(left, right);
        }
    }

    /*static int maxSumDyn(int[] triangle){
        return maxSumDyn(triangle, 0, 1);
    }

    private static int maxSumDyn(int[] triangle, int index, int level){
        if(index + level + 1 > triangle.length){
            return triangle[index];
        }
        else{
            int left = maxSum(triangle, index + level, level + 1);
            int right = maxSum(triangle, index + level + 1, level + 1);
            return triangle[index] + Math.max(left, right);
        }
    }

    static long[] tab = new long[100000];*/
}
