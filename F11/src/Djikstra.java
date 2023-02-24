import java.util.Arrays;

public class Djikstra {
    public static void main(String[] args){
        Djikstra path = new Djikstra();
        path.solution();
        path.print();
    }
    int X = Integer.MAX_VALUE;
    int[][] w = {   {X, 2, X, X, X, 1, X, X}, // A
                    {2, X, 2, 2, 4, X, X, X}, // B
                    {X, 2, X, X, 3, X, X, 1}, // C
                    {X, 2, X, X, 3, 1, X, X}, // etc...
                    {X, 4, 3, 3, X, X, 7, X},
                    {1, X, X, 1, X, X, 5, X},
                    {X, X, X, X, 7, 5, X, 6},
                    {X, X, 1, X, X, X, 6, X}};
    int d[] = {0, X, X, X, X, X, X, X};
    int p[] = new int[8];
    boolean[] taken = new boolean[8];

    public Djikstra(){
        Arrays.fill(taken, false);
    }

    public void solution(){
        for(int i = 0;i < d.length - 1;i++){
            int u = next(d, taken);
            taken[u] = true;
            for(int v = 0;v < w[u].length;v++){
                if(w[u][v] < X && d[v] > d[u] + w[u][v]){
                    d[v] = d[u] + w[u][v];
                    p[v] = u;
                }
            }
        }
    }

    private static int next(int[] d, boolean[] taken){
        int dMin = Integer.MAX_VALUE;
        int minIndex= 0;
        for(int i = 0;i < d.length;i++){
            if(d[i] < dMin && !taken[i]){
                dMin = d[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void print(){
        for(int i = 1;i < d.length;i++){
            System.out.println("Nod " + (char)(i + 'A') + " har avstånd " + d[i] + " till nod A via: " + (char) (p[i] + 'A'));
        }
    }
}
