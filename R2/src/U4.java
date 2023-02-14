import java.util.*;

public class U4 {
    public static void main(String[] args){
        Queue<Plane> arriving = new LinkedList<>(), departing = new LinkedList<>();

        boolean runwayOccupied = false;
        Plane p = null;
        Random rand = new Random();

        ArrayList<Integer> arrivingWaitTimes = new ArrayList<>();
        ArrayList<Integer> departingWaitTimes = new ArrayList<>();

        for(int i = 0;i < 5259600;i += 5){
            arriving = waitAll(arriving);
            departing = waitAll(departing);

            if(rand.nextInt(20) == 0){
                arriving.offer(new Plane());
            }
            if(rand.nextInt(20) == 0){
                departing.offer(new Plane());
            }

            if(runwayOccupied){
                p.workTime -= 5;
                if(p.workTime == 0)
                    runwayOccupied = false;
            }
            if(!runwayOccupied){
                if(!arriving.isEmpty()) {
                    p = arriving.poll();
                    runwayOccupied = true;
                    arrivingWaitTimes.add(p.waitTime);
                }
                else if(!departing.isEmpty()) {
                    p = departing.poll();
                    runwayOccupied = true;
                    departingWaitTimes.add(p.waitTime);
                }
            }
        }

        int total = 0;
        int max = 0;
        for(int time : arrivingWaitTimes){
            total += time;
            if(time > max)
                max = time;
        }
        double arrivingAvgTime = (double) total / arrivingWaitTimes.size();
        int arrivingMaxTime = max;
        total = 0;
        max = 0;
        for(int time : departingWaitTimes){
            total += time;
            if(time > max)
                max = time;
        }
        double departingAvgTime = (double) total / departingWaitTimes.size();
        int departingMaxTime = max;

        System.out.println("Average waiting time for arriving planes: " + Math.round(arrivingAvgTime * 10.0) / 10.0 + " min");
        System.out.println("Maximum waiting time for arriving planes: " + arrivingMaxTime + " min");
        System.out.println("Average waiting time for departing planes: " + Math.round(departingAvgTime * 10.0) / 10.0 + " min");
        System.out.println("Maximum waiting time for departing planes: " + departingMaxTime + " min");
    }

    private static Queue<Plane> waitAll(Queue<Plane> queue){
        Queue<Plane> q = new LinkedList<>();
        int size = queue.size();
        for(int i = 0;i < size;i++) {
            Plane p = queue.poll();
            p.waitTime += 5;
            q.offer(p);
        }
        return q;
    }

    private static class Plane{
        public int workTime;
        public int waitTime;

        public Plane(){
            workTime = 20;
            waitTime = 0;
        }
    }
}
