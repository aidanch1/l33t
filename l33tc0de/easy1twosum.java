package l33tc0de;

import java.util.*;

public class easy1twosum {
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
        	int b = target-nums[i];
        	if (m.containsKey(b)) {
        		return new int[] {m.get(b), i};
        	}
        	m.put(nums[i], i);
        }
        return new int[2];
    }
	public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
}
