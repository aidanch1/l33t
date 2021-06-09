package junechal;

import java.util.*;

public class JumpGame6 {
	public int maxResult(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        PriorityQueue<X> pq = new PriorityQueue<>(
            (a, b) -> b.val - a.val
        );
        dp[n-1] = nums[n-1];
        pq.add(new X(nums[n-1],n-1));
        for (int i=n-2; i>=0; i--) {
            while (pq.peek().start > i+k) {
                pq.poll();
            }
            int max = pq.peek().val;
            dp[i] = nums[i]+max;
            pq.add(new X(dp[i], i));
        }
        return dp[0];
    }
}
class X {
    int val;
    int start;
    public X(int a, int b) {
        val = a;
        start = b;
    }
}
