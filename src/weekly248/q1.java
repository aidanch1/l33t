package weekly248;

public class q1 {
	public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
