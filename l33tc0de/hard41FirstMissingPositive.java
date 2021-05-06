package l33tc0de;

public class hard41FirstMissingPositive {
	//O(n) time, O(1) space
	public int firstMissingPositive(int[] nums) {
        int back = nums.length-1;
        int front = 0;
        while (front < back) {
        	if (nums[front] == front+1) {
        		front++;
        	}
        	else if (nums[front] > nums.length || nums[front] <= 0 || nums[nums[front]-1] == nums[front]) {
        		swap(nums, front, back);
        		back--;
        	}
        	else {
        		swap(nums, front, nums[front]-1);
        	}
        }
        for (int i=0; i<nums.length; i++) {
        	if (nums[i] != i+1) {
        		return i+1;
        	}
        }
        return nums.length+1;
    }
	public void swap(int[] nums, int index1, int index2) {
		int t = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = t;
	}
}
