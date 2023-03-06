package se.kth.pellebe.f12.NB38;

import java.util.BitSet;

import static java.lang.Integer.MAX_VALUE;

public class TravellingSalesMan {
    public static int minDistanceGreedy(int[][] w, int[] route){
        int current = 0, index = 0, distance = 0;
        boolean finished = false;
        route[index] = 0;
        BitSet visited = new BitSet(route.length);
        visited.set(0);
        while(true) {
            if(route[route.length - 1] != 0)
                break;
            int min = MAX_VALUE, minIndex = 0;
            for (int j = 0; j < w[0].length; j++) {
                if (w[current][j] < min && !visited.get(j)) {
                    min = w[current][j];
                    minIndex = j;
                }
            }
            distance += min;
            current = minIndex;
            visited.set(current);
            route[++index] = current;
        }
        return distance;
    }
}
