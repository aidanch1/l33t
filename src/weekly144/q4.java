package weekly144;

public class q4 {
	public int[] maxDepthAfterSplit(String seq) {
		char[] c = seq.toCharArray();
        int[] ans = new int[c.length];
        int counter = 0;
        int max = 0;
        for (int i=0; i<c.length; i++) {
        	if (c[i] == '(') {
        		counter++;
        		if (counter > max) {
        			max = counter;
        		}
        	}
        	else {
        		counter--;
        	}
        }
        counter = 0;
        for (int i=0; i<c.length; i++) {
        	if (c[i] == '(') {
        		counter++;
        	}
        	if (counter > (max+1)/2) {
    			ans[i] = 1;
    		}
        	if (c[i] == ')') {
        		counter--;
        	}
        }
        return ans;
    }
}
