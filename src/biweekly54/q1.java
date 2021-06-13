package biweekly54;

public class q1 {
	public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] b = new boolean[51];
        for (int[] i : ranges) {
            for (int j=i[0]; j<=i[1]; j++) {
                b[j] = true;
            }
        }
        for (int i=left; i<= right; i++) {
            if (!b[i]) {
                return false;
            }
        }
        return true;
    }
}
