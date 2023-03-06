package se.kth.pellebe.f12;

import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;

public class NB36 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Time start,end;
        Activity[] activities = new Activity[20];
        int i = 0;
        while(true){
            System.out.println("Enter start time (HH:MM): ");
            String input = scan.nextLine();
            if(input.equals(""))
                break;
            if(input.matches("([0-1]?[0-9]|2[0-3]):[0-5][0-9]")){
                start = new Time(Integer.parseInt("" + input.charAt(0) + input.charAt(1)), Integer.parseInt("" + input.charAt(3) + input.charAt(4)), 0);
            }
            else{
                System.out.println("Invalid input.");
                break;
            }
            System.out.println("Enter end time (HH:MM): ");
            input = scan.nextLine();
            if(input.matches("([0-1]?[0-9]|2[0-3]):[0-5][0-9]")){
                end = new Time(Integer.parseInt("" + input.charAt(0) + input.charAt(1)), Integer.parseInt("" + input.charAt(3) + input.charAt(4)), 0);
            }
            else{
                System.out.println("Invalid input.");
                break;
            }
            activities[i++] = new Activity(start, end);
        }
        Activity[] a = new Activity[i];
        System.arraycopy(activities, 0, a, 0, a.length);

        scheduler(a);
        for(Activity ac : a){
            if(ac == null)
                break;
            System.out.println(ac.toString());
        }
    }

    public static Activity[] scheduler(Activity[] activities){
        Arrays.sort(activities);
        int added = 0;
        for(int i = 0;i < activities.length;i++){
            if(activities[i] == null)
                break;
            boolean add = true;
            for(int j = 0;j < added;j++){
                if(i != j) {
                    if (activities[i].startTime.compareTo(activities[j].startTime) >= 0
                            && activities[i].startTime.compareTo(activities[j].endTime) < 0
                            || activities[i].endTime.compareTo(activities[j].startTime) >= 0
                            && activities[i].endTime.compareTo(activities[j].endTime) < 0) {
                        for(int index = i;index < activities.length - 1;index++){
                            activities[index] = activities[index + 1];
                        }
                        activities[activities.length - 1] = null;
                        i--;
                        add = false;
                    }
                }
            }
            if(add){
                added++;
            }
        }
        return activities;
    }

    private static class Activity implements Comparable<Activity>{
        Time startTime;
        Time endTime;

        public Activity(Time start, Time end){
            this.startTime = start;
            this.endTime = end;
        }

        @Override
        public int compareTo(Activity other){
            return startTime.compareTo(other.startTime);
        }

        @Override
        public String toString(){
            return "[Start: " + startTime.toString() + ", end: " + endTime.toString() + "]";
        }
    }
}
