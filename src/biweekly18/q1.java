package biweekly18;

import java.util.*;

public class q1 {
	public int[] arrayRankTransform(int[] arr) {
		int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<temp.length; i++) {
        	m.putIfAbsent(temp[i], m.size()+1);
        }
        for (int i=0; i<arr.length; i++) {
        	arr[i] = m.get(arr[i]);
        }
        return arr;
    }
}
