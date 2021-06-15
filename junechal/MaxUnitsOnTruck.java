package junechal;

import java.util.*;

public class MaxUnitsOnTruck {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        int ans = 0;
        for (int i=0; i<boxTypes.length; i++) {
            ans += boxTypes[i][0] * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            if (truckSize < 0) {
                ans += truckSize * boxTypes[i][1];
                break;
            }
        }
        return ans;
    }
}
