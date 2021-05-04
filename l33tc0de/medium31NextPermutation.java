package l33tc0de;

import java.util.Arrays;

public class medium31NextPermutation {
	// Strategy: find the first swap which makes a bigger number
	// then sort the numbers after the swap to make them as small as possible
	public static void nextPermutation(int[] nums) {
		for (int i=nums.length-2; i>=0; i--) {
			int min = Integer.MAX_VALUE;
			int mindex = -1;
			for (int j=i+1; j<nums.length; j++) {
				if (nums[j] > nums[i] && nums[j] < min) {
					min = nums[j];
					mindex = j;
				}
			}
			if (mindex != -1) {
				int t = nums[mindex];
				nums[mindex] = nums[i];
				nums[i] = t;
				bubblesort(nums, i+1);
				return;
			}
		}
		bubblesort(nums, 0);
	}

	public static void bubblesort(int[] nums, int startindex) {
		int n = nums.length;
		for (int i = startindex; i < n - 1; i++) {
			for (int j = startindex; j < n - i + startindex - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int t = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,3,2};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
