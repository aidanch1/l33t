package l33tc0de;

import java.util.*;

public class easy1046LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(new sort());
        for (int i:stones) {
        	pq.add(i);
        }
        while (pq.size() > 1) {
        	int a = pq.poll();
        	int b = pq.poll();
        	int smash = Math.abs(a-b);
        	if (smash > 0) {
        		pq.add(smash);
        	}
        }
        if (pq.size() == 0) {
        	return 0;
        }
        else {
        	return pq.poll();
        }
    }
}
class sort implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		return o1.intValue() - o2.intValue();
	}
}
