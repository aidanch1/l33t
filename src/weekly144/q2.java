package weekly144;

public class q2 {
	public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] b:bookings) {
        	for (int i=b[0]-1; i<=b[1]-1; i++) {
        		ans[i] += b[2];
        	}
        }
        return ans;
    }
}
