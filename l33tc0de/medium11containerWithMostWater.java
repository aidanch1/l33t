package l33tc0de;

public class medium11containerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;
        int i=0;
        int j=height.length-1;
        while (i < j) {
        	int t = (j-i)*Math.min(height[i], height[j]);
        	if (t > maxArea) {
        		maxArea = t;
        	}
        	if (height[i] < height[j]) {
        		i++;
        	}
        	else {
        		j--;
        	}
        }
        return maxArea;
    }
	public static void main(String[] args) {

	}
}
