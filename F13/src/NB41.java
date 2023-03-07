import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.max;

public class NB41 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int[] a;
        while(true){
            System.out.println("Ange n: ");
            int n = scan.nextInt();
            if(n == 0)
                break;
            a = new int[n];
            System.out.print("[");
            for(int i = 0;i < n;i++){
                a[i] = rand.nextInt(2001) - 1000;
                System.out.print(a[i]);
                if(i != n - 1)
                    System.out.print(",");
            }
            System.out.println("]");
            int[] sum = maxSum(a);
            System.out.println("Maximala delsekvensen är: " + sum[0]);
            System.out.println("Antal anrop: " + sum[1]);
        }
    }

    public static int[] maxSum(int[] a){
        return maxSum(a, 0, a.length - 1, 1);
    }

    private static int[] maxSum(int[] a, int left, int right, int calls){
        if(left == right)
            return new int[]{max(0, a[left]), calls};
        int center = (left + right) / 2, sum = 0, maxLeft = 0;
        for(int i = center;i >= left;i--){
            sum += a[i];
            maxLeft = max(maxLeft, sum);
        }
        sum = 0;
        int maxRight = 0;
        for(int i = center + 1;i <= right;i++){
            sum += a[i];
            maxRight = max(maxRight, sum);
        }
        int maxOverMiddle = maxLeft + maxRight;
        int[] dataLeft = maxSum(a, left, center, calls + 1);
        int[] dataRight = maxSum(a, center + 1, right, calls + 1);
        return new int[]{max(maxOverMiddle, max(dataLeft[0], dataRight[0])), dataLeft[1] + dataRight[1]};
    }
}
