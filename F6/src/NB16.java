import java.util.LinkedList;
import java.util.Queue;

public class NB16 {
    public static void main(String[] args){
        System.out.println(moves(3, 2, 1));
    }

    static int moves(int b, int w, int r){
        Queue<Tillstand> q = new LinkedList<>();
        Tillstand t = new Tillstand(b, w, r, 0);

        while(t.b != t.w || t.b != t.r){
            if(t.b > 0)
                q.offer(new Tillstand(t.b - 1, t.w + 1, t.r + 3, t.count + 1));
            if(t.w > 0)
                q.offer(new Tillstand(t.b + 2, t.w - 1, t.r + 4, t.count + 1));
            if(t.r > 0)
                q.offer(new Tillstand(t.b + 1, t.w + 5, t.r - 1, t.count + 1));
            t = q.poll();
        }

        return t.count;
    }

    private static class Tillstand{
        public int b;
        public int w;
        public int r;
        public int count;

        public Tillstand(int b, int w, int r, int count){
            this.b = b;
            this.w = w;
            this.r = r;
            this.count = count;
        }
    }
}
