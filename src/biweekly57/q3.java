package biweekly57;

import java.util.*;

public class q3 {
	public List<List<Long>> splitPainting(int[][] segments) {        
        long[] p = new long[100001];
        boolean[] track = new boolean[100001];
        for (int[] s:segments) {
            p[s[0]] += s[2];
            p[s[1]] -= s[2];
            track[s[0]] = true;
            track[s[1]] = true;
        }
        List<List<Long>> ans = new ArrayList<>();
        long prev = 0;
        long color = 0;
        for (int i=1; i<100001; i++) {
            if (track[i]) {
                if (color != 0) {
                    List<Long> t = new ArrayList<>();
                    t.add(prev);
                    t.add((long) i);
                    t.add(color);
                    ans.add(t);
                }
                color += p[i];
                prev = i;
            }
        }
        return ans;
    }
}