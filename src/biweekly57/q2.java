package biweekly57;

import java.util.*;

public class q2 {
	public int smallestChair(int[][] times, int targetFriend) {
        helper[] h = new helper[times.length];
        for (int i=0; i<times.length; i++) {
            h[i] = new helper(i, times[i]);
        }
        Arrays.sort(h, new Comparator<helper>() {
            public int compare(helper a, helper b) {
                return a.t[0]-b.t[0];
            }
        });
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        PriorityQueue<take> pq = new PriorityQueue<>(
            (a, b) -> a.leave-b.leave
        );
        for (helper i:h) {
            while (!pq.isEmpty() && pq.peek().leave<=i.t[0]) {
                chairs.add(pq.poll().chair);
            }
            if (i.index == targetFriend) {
                if (chairs.isEmpty()) {
                    return pq.size();
                }
                else {
                    return chairs.peek();
                }
            }
            else {
                if (chairs.isEmpty()) {
                    pq.add(new take(pq.size(), i.t[1]));
                }
                else {
                    pq.add(new take(chairs.poll(), i.t[1]));
                }
            }
        }
        return -1;
    }
}
class helper {
    int index;
    int[] t;
    public helper(int a, int[] b) {
        index = a;
        t = b;
    }
}
class take {
    int chair;
    int leave;
    public take(int a, int b) {
        chair = a;
        leave = b;
    }
}