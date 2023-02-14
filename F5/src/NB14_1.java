public class NB14_1 {
    public static void main(String[] args){
        System.out.println(moves(3,2,1));
    }

    static int moves(int b, int w, int r){
        return moves(b, w, r, 0);
    }

    static int moves(int b, int w, int r, int count){
        if(b == w && w == r)
            return count;
        else{
            int blue = 15, white = 15, red = 15;
            if(count < 15) {
                if(b > 0)
                    blue = moves(b - 1, w + 1, r + 3, count + 1);
                if(w > 0)
                    white = moves(b + 2, w - 1, r + 4, count + 1);
                if(r > 0)
                    red = moves(b + 1, w + 5, r - 1, count + 1);
            }
            return Math.min(blue, Math.min(white, red));
        }
    }
}