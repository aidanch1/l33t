package weekly245;

import java.util.*;

public class q2 {
	public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (isSS(s,p,removable,mid)) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }
    public boolean isSS(String s, String p, int[] removable, int toRemove) {
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        Set<Integer> r = new HashSet<>();
        for (int i=0; i<=toRemove; i++) {
            r.add(removable[i]);
        }
        int pindex = 0;
        for (int i=0; i<s1.length; i++) {
            if (pindex == p1.length) {
                break;
            }
            if (s1[i] == p1[pindex] && !r.contains(i)) {
                pindex++;
            }
        }
        return pindex == p.length();
    }
}
