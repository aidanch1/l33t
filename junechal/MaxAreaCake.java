package junechal;

import java.util.*;

public class MaxAreaCake {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		int mod = (int) 1e9 + 7;
		// sort horizontal cuts and vertical cuts, then find the largest gap in each
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		long maxwidth = horizontalCuts[0];
		for (int i = 1; i < horizontalCuts.length; i++) {
			maxwidth = Math.max(maxwidth, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		maxwidth = Math.max(maxwidth, h - horizontalCuts[horizontalCuts.length - 1]);
		long maxheight = verticalCuts[0];
		for (int i = 1; i < verticalCuts.length; i++) {
			maxheight = Math.max(maxheight, verticalCuts[i] - verticalCuts[i - 1]);
		}
		maxheight = Math.max(maxheight, w - verticalCuts[verticalCuts.length - 1]);
		long ans = maxwidth * maxheight;
		return (int) (ans % mod);
	}
}
