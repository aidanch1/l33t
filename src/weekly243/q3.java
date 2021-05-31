package weekly243;

import java.util.*;

public class q3 {
	public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<server> availableServers = new PriorityQueue<>(10, new Comparator<server>() {
            public int compare(server a, server b) {
                if (a.weight == b.weight) {
                    return a.index - b.index;
                }
                return a.weight - b.weight;
            }
        });
        PriorityQueue<task> working = new PriorityQueue<>(10, new Comparator<task>() {
            public int compare(task a, task b) {
                return a.finishTime - b.finishTime;
            }
        });
        int[] ans = new int[tasks.length];
        for (int i=0; i<servers.length; i++) {
            availableServers.add(new server(servers[i], i));
        }
        int nextTask = 0; //index of next task
        int time = 0;
        while (nextTask < tasks.length) {
            while (!working.isEmpty() && working.peek().finishTime <= time) {
                //that server finished its task
                availableServers.add(working.poll().server);
            }
            while (nextTask<tasks.length && nextTask <= time && !availableServers.isEmpty()) {
                //task[nextTask] can be assigned to a server
                server use = availableServers.poll();
                ans[nextTask] = use.index;
                working.add(new task(use, time+tasks[nextTask]));
                nextTask++;
            }
            if (availableServers.isEmpty()) {
                time = working.peek().finishTime;
            }
            else {
                time++;
            }
        }
        return ans;
    }
}
class server {
    int weight;
    int index;
    public server(int a, int b) {
        this.weight = a;
        this.index = b;
    }
}
class task {
    server server;
    int finishTime;
    public task(server s, int a) {
        this.server = s;
        this.finishTime = a;
    }
}
