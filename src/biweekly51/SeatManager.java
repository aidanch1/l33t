package biweekly51;

import java.util.*;

public class SeatManager {
	Queue<Integer> pq;
	
	public SeatManager(int n) {
        pq = new PriorityQueue<Integer>();
        for (int i=1; i<=n; i++) {
        	pq.add(i);
        }
    }
    
    public int reserve() {
        return pq.remove();
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
