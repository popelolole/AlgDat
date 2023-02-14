import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class NB14 {
    public static void main(String[] args){
        System.out.println("Myntmaskinen 1.0");
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Vilken poäng ska uppnås: ");
            int points = scan.nextInt();
            if(points == 0)
                break;
            int crowns = minCrowns(points);
            if(crowns == MAX_VALUE)
                System.out.println("Poängen kan inte nås.");
            else
                System.out.println("Poängen kan nås med " + crowns + " kronor");

        }
    }

    static int minCrowns(int points){
        return calculateCrowns(points, 0, 1);
    }

    private static int calculateCrowns(int points, int crowns, int display){
        if(display == points)
            return crowns;
        else {
            System.out.println(display + ", " + crowns);
            int ten = MAX_VALUE;
            int five = MAX_VALUE;
            if (display * 3 <= points) {
                ten = calculateCrowns(points, crowns + 10, display * 3);
            }
            if (display + 4 <= points) {
                five = calculateCrowns(points, crowns + 5, display + 4);
            }
            return Math.min(ten, five);
        }
    }
}
