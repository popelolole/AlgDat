public class paths {
    public static void main(String[] args){
        System.out.println(noPaths(3, 3));
    }

    static int noPaths(int m, int n){
        //System.out.println(m + ", " +  n);
        if(m == 0 && n == 0)
            return 1;
        else{
            int count = 0;
            if(m > 0)
                count = noPaths(m - 1, n);
            if(n > 0)
                count += noPaths(m, n - 1);
            //System.out.println("count: " + count);
            return count;
        }
    }
}
