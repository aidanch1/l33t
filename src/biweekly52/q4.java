package biweekly52;

import java.util.*;

public class q4 {
	public static int sumOfFlooredPairs(int[] nums) {
		long mod = 1000000007;
		
		long ans = 0;
		Map<Integer, Long> m = new HashMap<>();
		Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
        	if (!m.containsKey(nums[i])) {
        		m.put(nums[i], (long) 0);
        		int div = nums[nums.length-1]/nums[i];
            	for (int j=1; j<=div; j++) {
            		int rt = nums[i] * j + nums[i] - 1; // right target
            		int right = bs(nums, rt, false);
            		int lt = nums[i] * j; // left target
            		int left = bs(nums, lt, true);
            		if (right >= left && nums[left] <= rt && nums[right] >= lt) {
            			int t = (right - left + 1) * j;
                		m.put(nums[i], m.get(nums[i])+t);
            		}
            	}
        	}
        	ans += m.get(nums[i]);
        }
        return (int) (ans % mod);
    }
	public static int bs(int nums[], int target, boolean b) {
		//if b: returns index of first number greater than/equal to target
		//else: returns index of first number less/equal to target
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
    		int mid = left + (right-left)/2;
    		if (nums[mid] < target) {
    			left = mid + 1;
    		}
    		else if (nums[mid] > target) {
    			right = mid - 1;
    		}
    		else {
    			left = mid;
    			right = mid;
    			break;
    		}
    	}
		if (b) {
			while (left >= 0 && nums[left] >= target) {
				left--;
			}
			return left+1;
		}
		else {
			while (right < nums.length && nums[right] <= target) {
				right++;
			}
			return right-1;
		}
	}
	public static void main(String[] args) {
		int[] test = new int[] {2,5,9};
		sumOfFlooredPairs(test);
	}
}
