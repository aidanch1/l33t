package l33tc0de;

public class medium287findTheDuplicateNumber {
	//constant time and space!
	public static int findDuplicate(int[] nums) {
		int i=0;
		while (i<nums.length) {
			if (i+1 == nums[i]) {
				i++;
			}
			else if (nums[nums[i]-1] == nums[i]) {
				return nums[i];
			}
			else {
				int t = nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
				nums[i] = t;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,4,2,2};
		System.out.println(findDuplicate(nums));
	}
}
