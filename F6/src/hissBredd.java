import java.util.LinkedList;
import java.util.Queue;

public class hissBredd {
    public static void main(String[] args){
        System.out.println(antalResorBredd(7, 3, 1, 2));
    }

    private static class Tillstand{
        public int position, antalResor;
        public Tillstand(int position, int antalResor){
            this.position = position;
            this.antalResor = antalResor;
        }
    }

    static int antalResorBredd(int n, int upp, int ned, int destination){
        Queue<Tillstand> q = new LinkedList<Tillstand>();
        Tillstand t = new Tillstand(1, 0);

        while(t.position!=destination){
            if(t.position + upp <= n){
                q.offer(new Tillstand(t.position + upp, t.antalResor + 1));
            }
            if(t.position - ned > 0){
                q.offer(new Tillstand(t.position - ned, t.antalResor + 1));
            }
            t = q.poll();
        }

        return t.antalResor;
    }
}
