package junechal;

public class StoneGame7 {
	// both players want to maximize the score difference on their turn
	int[][] dp;
    int[] prefixsum;
    public int stoneGameVII(int[] stones) {
        dp = new int[stones.length][stones.length+1];
        prefixsum = new int[stones.length+1];
        for (int i=0; i<stones.length; i++) {
            prefixsum[i+1] = prefixsum[i]+stones[i];
        }
        return maxScore(0, stones.length);
    }
    public int maxScore(int start, int end) {
        if (end - start == 1) {
            return 0;
        }
        else if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int left = prefixsum[end] - prefixsum[start+1] - maxScore(start+1, end);
        int right = prefixsum[end-1] - prefixsum[start] - maxScore(start, end-1);
        int ans = Math.max(left, right);
        dp[start][end] = ans;
        return ans;
    }
}
