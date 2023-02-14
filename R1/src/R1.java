public class R1 {
    public static void main(String[] args){
        int r=0, n=100;

        //0 1 7 25 65 140 266 462 750 1155 1705 2431 3367 4550

        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = j; k <= i + j; k++) {
                    for (int m = 1; m <= i + j - k; m++) {
                        r++;//Enkel sats
                    }
                }
            }
        }

        System.out.println(r);
    }
}
