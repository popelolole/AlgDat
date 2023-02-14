public class factorial {
    public static void main(String[] args){
        System.out.println(fac(5));
    }

    static int fac(int n){
        if(n == 0)
            return 1;
        else
            return n * fac(n - 1);
    } //O(n)

    static int facIterative(int nFinal){
        int facn = 1;
        for(int n = 2;n <= nFinal;n++){
            facn *= n;
        }
        return facn;
    } //O(n)
}
