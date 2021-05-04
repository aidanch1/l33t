package l33tc0de;

import java.util.*;

public class medium153sum {
	public static List<List<Integer>> threeSum(int[] nums) {
		//need x + y + z = 0, -> x + y = -z
		List<List<Integer>> ans = new ArrayList<>();
		HashSet<List<Integer>> seen = new HashSet<>();
		for (int i=0; i<nums.length; i++) {
			List<List<Integer>> toadd = twoSum(nums, nums[i], i);
			for (List<Integer> l:toadd) {
				Collections.sort(l);
				if (!seen.contains(l)) {
					ans.add(l);
					seen.add(l);
				}
			}
		}
		return ans;
    }
	public static List<List<Integer>> twoSum(int[] nums, int target, int unallowed) {
		List<List<Integer>> ans = new ArrayList<>();
		Set<Integer> m = new HashSet<>();
		for (int i=0; i<nums.length; i++) {
			if (i != unallowed) {
				int b = -1*target - nums[i];
				if (m.contains(b)) {
					List<Integer> t = new ArrayList<>();
					t.add(b);
					t.add(nums[i]);
					t.add(target);
					ans.add(t);
				}
				else {
					m.add(nums[i]);
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		for (List<Integer> i : threeSum(nums)) {
			System.out.println(Arrays.toString(i.toArray()));
		}
	}
}