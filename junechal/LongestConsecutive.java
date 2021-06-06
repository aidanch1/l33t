package junechal;

import java.util.*;

public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
        Ds disjoint = new Ds();
        for (int i:nums) {
            disjoint.add(i);
        }
        return disjoint.largestSet();
    }
}
class Ds {
    List<Integer> pointers;
    Map<Integer, Integer> indexof;
    public Ds () {
        this.pointers = new ArrayList<>();
        this.indexof = new HashMap<>();
    }
    public void add(int a) {
        if (!indexof.containsKey(a)) {
            indexof.put(a, pointers.size());
            pointers.add(-1);
            if (indexof.containsKey(a-1)) {
                this.union(a, a-1);
            }
            if (indexof.containsKey(a+1)) {
                this.union(a, a+1);
            }
        }
    }
    public void union(int a, int b) {
        int set1 = findset(a);
        int set2 = findset(b);
        if (set1 != set2) {
            int e = pointers.get(set1) + pointers.get(set2);
            if (pointers.get(set1) < pointers.get(set2)) {
                pointers.set(set2, set1);
                pointers.set(set1, e);
            }
            else {
                pointers.set(set1, set2);
                pointers.set(set2, e);
            }
        }
    }
    public int findset(int a) {
        int index = indexof.get(a);
        List<Integer> t = new ArrayList<>();
        while (pointers.get(index) >= 0) {
            t.add(index);
            index = pointers.get(index);
        }
        for (int i:t) {
            pointers.set(i,index);
        }
        return index;
    }
    public int largestSet() {
        int max = 0;
        for (int i:pointers) {
            if (i < max) {
                max = i;
            }
        }
        return Math.abs(max);
    }
}