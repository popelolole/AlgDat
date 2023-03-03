import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.pow;

public class U9 {
    public static void main(String[] args){
        Random rand = new Random();
        int n = 1000000;
        int[] v = new int[n];
        for(int i = 0;i < n;i++){
            v[i] = rand.nextInt(MAX_VALUE);
        }

        long startTime = System.currentTimeMillis();
        radixSort(v);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        checkSorted(v);
        System.out.println("Time elapsed: " + elapsedTime + " ms");
    }

    public static void radixSort(int[] v){
        int digits = noOfDigits(v);
        int[] count = new int[10], output = new int[v.length];
        for(int d = 1;d <= digits;d++) {
            for (int i = 0; i < v.length; i++) {
                count[(int) (v[i]%pow(10,d)/pow(10,d-1))]++;
            }
            for(int i = 0;i < count.length - 1;i++){
                count[i+1] = count[i] + count[i+1];
            }
            for(int i = v.length - 1;i >= 0;i--){
                output[--count[(int) (v[i]%pow(10,d)/pow(10,d-1))]] = v[i];
            }
            System.arraycopy(output, 0, v, 0, v.length);
            count = new int[10];
        }
    }

    private static int noOfDigits(int[] v){
        int max = v[0];
        for(int a : v){
            if(a > max)
                max = a;
        }
        String i = String.valueOf(max);
        return i.length();
    }

    private static boolean checkSorted(int v[]){
        int max = v[0];
        for(int a:v){
            if(a >= max)
                max = a;
            else {
                System.out.println("Sorting Unsuccessful.");
                return false;
            }
        }
        System.out.println("Sorting Successful.");
        return true;
    }

    private static void empirical(){
        Random rand = new Random();
        for(int n = 100;n <= 1000000;n*=10) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = rand.nextInt(MAX_VALUE);
            }

            long startTime = System.currentTimeMillis();
            radixSort(a);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            checkSorted(a);
            System.out.println("n: " + n);
            System.out.println("Time elapsed: " + elapsedTime + " ms");
        }
    }
}
