package junechal;

import java.util.*;

public class MinimumRefuelStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //max heap of fuels you can grab
        PriorityQueue<Integer> fuel = new PriorityQueue<>(
            (a, b) -> b - a
        );
        int refuels = 0;
        int curstation = 0;
        while (startFuel < target) {
            while (curstation < stations.length && stations[curstation][0] <= startFuel) {
                fuel.add(stations[curstation][1]);
                curstation++;
            }
            if (fuel.isEmpty()) {
                return -1;
            }
            startFuel += fuel.poll();
            refuels++;
        }
        return refuels;
    }
}
