package biweekly57;

import java.util.*;

public class q4 {
	public int[] canSeePersonsCount(int[] heights) {
        int[] r = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                r[st.pop()]++;
            }
            if (!st.isEmpty()) {
                r[st.peek()]++;
            }
            st.push(i);
        }
        return r;
    }
}