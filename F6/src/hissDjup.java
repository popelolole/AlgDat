import static java.lang.Integer.MAX_VALUE;

public class hissDjup {
    public static void main(String[] args){
        System.out.println(antalResorHiss(7, 3, 1, 2));
    }

    static int antalResorHiss(int n, int upp, int ned, int destination){
        return antalResorHiss(n, upp, ned, 1, destination, 0);
    }

    private static int antalResorHiss(int n, int upp, int ned, int position, int destination, int antalResor){
        if(position == destination)
            return antalResor;
        else if(antalResor > 30)
            return MAX_VALUE;
        else{
            int antalUpp = MAX_VALUE, antalNed = MAX_VALUE;
            if(position + upp <= n)
                antalUpp = antalResorHiss(n, upp, ned, position + upp, destination, antalResor + 1);
            if(position - ned > 0)
                antalNed = antalResorHiss(n, upp, ned, position - ned, destination, antalResor + 1);
            return Math.min(antalUpp, antalNed);
        }
    }
}
