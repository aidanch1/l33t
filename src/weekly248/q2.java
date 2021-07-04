package weekly248;

import java.util.PriorityQueue;

public class q2 {
	public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Monster> pq = new PriorityQueue<>(
            (a, b) -> a.time - b.time
        );
        for (int i=0; i<dist.length; i++) {
            pq.add(new Monster(dist[i],speed[i]));
        }
        int time = 0;
        while (!pq.isEmpty() && time < pq.peek().time) {
            pq.poll();
            time++;
        }
        return time;
    }
}
class Monster {
    int dist;
    int speed;
    int time;
    public Monster(int a, int b) {
        dist = a;
        speed = b;
        time = a/b;
        if (a%b != 0) {
            time++;
        }
    }
}