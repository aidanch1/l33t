package weekly246;

public class q4 {
	public int[] minDifference(int[] nums, int[][] queries) {
        int[][] cnt = new int[nums.length][101]; // cnt[i][j] is # of occurences of j between [0...i]
        cnt[0][nums[0]]++;
        for (int i=1; i<nums.length; i++) {
            for (int j=1; j<=100; j++) {
                cnt[i][j] = cnt[i-1][j];
            }
            cnt[i][nums[i]]++;
        }
        int[] ans = new int[queries.length];
        for (int i=0; i<ans.length; i++) {
            int[] q = queries[i];
            int prev = 0;
            int min = Integer.MAX_VALUE;
            for (int j=1; j<=100; j++) {
                //see if j occurs in the interval q[0]...q[1]
                int occurences = q[0] == 0 ? cnt[q[1]][j] : cnt[q[1]][j]-cnt[q[0]-1][j];
                if (occurences>0) {
                    if (prev != 0) {
                        min = Math.min(min,j-prev);   
                    }
                    prev = j;
                }
            }
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}
