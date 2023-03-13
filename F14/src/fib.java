import java.util.Arrays;

public class fib {
    public static void main(String[] args){
        int n = 40;
        Arrays.fill(tab, 0);
        tab[1] = tab[2] = 1;
        System.out.println(fibDyn(n));
        System.out.println(counter);
    }

    static long[] tab = new long[100000];
    static int counter = 0;

    static long fibDyn(int n){
        counter++;
        if(tab[n] != 0)
            return tab[n];
        return tab[n] = fibDyn(n-1) + fibDyn(n-2);
    }

    static long fibIterativ(int nFinal){
        long fn = 0, fnMinus1 = 1, fnMinus2 = 1;
        for(int n = 3;n <= nFinal;n++){
            fn = fnMinus1 + fnMinus2;
            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }
        return fn;
    }
}
