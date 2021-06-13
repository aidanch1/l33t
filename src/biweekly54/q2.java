package biweekly54;

public class q2 {
	public int chalkReplacer(int[] chalk, int k) {
        long[] chalks = new long[chalk.length];
        chalks[0] = chalk[0];
        for (int i=1; i<chalk.length; i++) {
            chalks[i] = chalks[i-1] + chalk[i];
        }
        int left = 0;
        int right = (int) 1e9;
        int n = chalk.length;
        while (left <= right) {
            int m = left + (right-left)/2;
            long a = chalks[n-1] * (long) m;
            if (a == k) {
                return 0;
            }
            if (a < k) {
                left = m+1;
            }
            else {
                right = m-1;
            }
        }
        //use right
        k -= chalks[n-1]*right;
        for (int i=0; i<n; i++) {
            if (chalks[i] > k) {
                return i;
            }
        }
        return -1;
    }
}
