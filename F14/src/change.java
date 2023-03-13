import static java.lang.Math.min;

public class change {
    public static void main(String[] args){
        int[] currency = new int[]{1, 5, 10, 20, 50, 100, 1000};
        for(int i = 0;i < currency.length - 1;i++){
            tab[currency[i]] = 1;
        }
        System.out.println(changeDyn(49));
    }

    public static long changeDyn(long amount){
        if(tab[(int) amount] != 0)
            return tab[(int) amount];
        long v = amount;
        for(int i = 1;i <= amount / 2;i++)
            v = min(v, changeDyn(i) + changeDyn(amount - i));
        return tab[(int) amount] = v;
    }

    static long[] tab = new long[100000];
}
