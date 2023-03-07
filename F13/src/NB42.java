import java.util.*;

import static java.lang.Float.MAX_VALUE;
import static java.lang.Float.POSITIVE_INFINITY;
import static java.lang.Math.min;
import static java.lang.Math.pow;

public class NB42 {
    public static void main(String[] args){
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Point[] a;
        while(true){
            System.out.println("Ange antal punkter (n): ");
            int n = scan.nextInt();
            if(n == 0)
                break;
            a = new Point[n];
            for(int i = 0;i < n;i++){
                a[i] = new Point(rand.nextFloat(2) - 1, rand.nextFloat(2) - 1);
                System.out.println(a[i].toString());
            }
            System.out.println("Avstånd mellan närmaste par (effektiv): " + closestPair(a));
            System.out.println("Avstånd mellan närmaste par (ineffektiv): " + closestPairIneffective(a));
        }
    }


    public static float closestPair(Point[] a){
        if(a == null || a.length < 2) {
            return 0;
        }
        Arrays.sort(a, new CompareX());
        return closestPair(a, 0, a.length - 1);
    }

    private static float closestPair(Point[] a, int left, int right){
        if(left >= right){
            return MAX_VALUE;
        }
        else if (left + 1 == right) {
            return a[left].distance(a[right]);
        }
        int center = (left + right) / 2;
        float d = min(closestPair(a, left, center), closestPair(a, center + 1, right));
        Point[] interval = new Point[right - left + 1];
        int j = 0;
        for(int i = left;i <= right;i++){
            if(Math.abs(a[left].x - a[center].x) < d){
                interval[j++] = a[i];
            }
        }
        interval = Arrays.copyOfRange(interval, 0, j);
        Arrays.sort(interval, new CompareY());
        for (int i = 0;i < interval.length; i++) {
            for (int k = i + 1;k < interval.length && Math.abs(a[left].x - a[center].x) < d;k++) {
                d = Math.min(d, interval[i].distance(interval[k]));
            }
        }
        return d;
    }

    public static float closestPairIneffective(Point[] a){
        float min = POSITIVE_INFINITY;
        for (int i = 0;i < a.length;i++) {
            for (int j = i + 1;j < a.length;j++) {
                min = min(a[i].distance(a[j]), min);
            }
        }
        return min;
    }


    private static class Point{
        float x;
        float y;

        public Point(float x, float y){
            this.x = x;
            this.y = y;
        }

        public float distance(Point p){
            return (float) Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof Point){
                return this.x == ((Point) o).x && this.y == ((Point) o).y;
            }
            return false;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private static class CompareX implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            return Float.compare(o1.x, o2.x);
        }
    }

    private static class CompareY implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            return Float.compare(o1.y, o2.y);
        }
    }
}
