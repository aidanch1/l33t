package l33tc0de2;

public class jumpgame2 {
	public int jump(int[] nums) {
		//dp
		int[] dp = new int[nums.length]; //dp[i] stores min jumps from i to get to end
		for (int i=0; i<dp.length-1; i++) {
			dp[i] = Integer.MAX_VALUE-1;
		}
		dp[dp.length-1] = 0;
		for (int i=dp.length-2; i>=0; i--) {
			//check num jumps for all the spots you can go to. the answer for your current spot is the min of those + 1
			for (int j=1; j<=nums[i]; j++) {
                if (i + j == nums.length - 1) {
                    dp[i] = 1;
                    break;
                }
				dp[i] = Math.min(dp[i], dp[i+j]+1);
			}
		}
		return dp[0];
    }
}
