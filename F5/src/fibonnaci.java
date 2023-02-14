public class fibonnaci {
    public static void main(String[] args){
        System.out.println(fibIterative(40));
        System.out.println(fibTail(40));
    }

    static int fib(int n){
        if (n == 1 || n == 2)
            return 1;
        else
            return fib(n-1) + fib(n-2);
    } //O(2^n)

    static int fibIterative(int nFinal){
        int fn = 1, fnMinus1 = 1, fnMinus2 = 1;
        for(int n = 3;n <= nFinal;n++){
            fn = fnMinus1 + fnMinus2;
            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }
        return fn;
    } //O(n)

    static int fibTail(int n) //wrapper, kräver n>2
    {
        return fn(1,1,3,n);
    }

    static int fn(int fnMinus1, int fnMinus2, int n,int nFinal){
        if(n == nFinal)
            return fnMinus1+fnMinus2;
        else
            return fn(fnMinus1 + fnMinus2, fnMinus1, n + 1, nFinal);
    }
}
