package junechal;

import java.util.*;

public class MaxPerformanceOfTeam {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) 1e9+7;
        //try having each worker be the least efficient of the group
        Engineer[] engineers = new Engineer[n];
        for (int i=0; i<n; i++) {
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        }
        Arrays.sort(engineers);
        // track k-1 fastest engineers more efficient than current engineer
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        long sum = 0; // sum of speeds in pq
        long max = 0;
        for (int i=0; i<k-1; i++) {
            long t = (long) (sum+engineers[i].speed) * (long) engineers[i].efficiency;
            if (t > max) {
                max = t;
            }
            sum += engineers[i].speed;
            pq.add(engineers[i].speed);
        }
        for (int i=k-1; i<n; i++) {
            //ith engineer will be added as the least efficient of the group
            long t = (long) (sum+engineers[i].speed) * (long) engineers[i].efficiency;
            if (t > max) {
                max = t;
            }
            if (k > 1 && engineers[i].speed > pq.peek()) {
                sum -= pq.poll();
                pq.add(engineers[i].speed);
                sum += engineers[i].speed;
            }
        }
        return (int) (max%mod);
    }
}
class Engineer implements Comparable<Engineer>{
    int speed;
    int efficiency;
    public Engineer(int a, int b) {
        this.speed = a;
        this.efficiency = b;
    }
    @Override
    public int compareTo(Engineer other) {
        return other.efficiency - this.efficiency; // will sort in descending order
    }
}