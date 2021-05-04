package biweekly51;

import java.util.*;

public class Biweekly51Q4 {
	public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, new sort());
        int[] ans = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
        	ans[i] = solve(rooms, queries[i]);
        }
        return ans;
    }
	public int solve(int[][] rooms, int[] query) {
		//binary search on room num
		int l = 0, r = rooms.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (rooms[m][0] == query[0]) {
            	l = m;
            	r = m;
            	break;
            }
            if (rooms[m][0] < query[0])
                l = m + 1;
            else
                r = m - 1;
        }
        int i=0;
        if (l == rooms.length) {
        	l--;
        }
        while (l + i < rooms.length || l - i >= 0) {
        	if (l-i >= 0 && rooms[l-i][1] >= query[1]) {
        		return rooms[l-i][0];
        	}
        	else if (l+i < rooms.length && rooms[l+i][1] >= query[1]) {
        		return rooms[l+i][0];
        	}
        	i++;
        }
        return -1;
	}
}

class sort implements Comparator<int[]>{
	@Override
	public int compare(int[] a, int[] b) {
		return a[0] - b[0];
	}
}