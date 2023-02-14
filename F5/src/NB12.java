public class NB12 {
    public static void main(String[] args){
        System.out.println("recursive: " + raise(2, 5));
        System.out.println("iterative: " + raiseIterative(2, 5));
    }

    static int raise(int x, int n){
        if(x == 0)
            return 0;
        return raise(x, n, 0, 1);
    }

    private static int raise(int x, int n, int count, int value){
        if(count == n)
            return value;
        return raise(x, n, count + 1, value * x);
    }

    private static int raiseIterative(int x, int n){
        if(x == 0)
            return 0;
        int value = 1;
        for(int i = 0;i < n;i++)
            value *= x;
        return value;
    }
}
