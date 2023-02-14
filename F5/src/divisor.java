public class divisor {
    public static void main(String[] args){
        System.out.println(gcd(78,21));
    }

    //Euclides
    static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
