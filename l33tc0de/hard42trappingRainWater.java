package l33tc0de;

public class hard42trappingRainWater {
	//idea: find all bowls from the left then from the right
	public static int trap(int[] height) {
		int water = 0;
		int prevIndex = 0; // index of previously tallest wall
		while (prevIndex < height.length && height[prevIndex] == 0) {
			prevIndex++;
		}
        for (int i=prevIndex; i<height.length; i++) {
        	if (height[i] >= height[prevIndex]) {
        		for (int j=prevIndex+1; j<i; j++) {
        			water += height[prevIndex] - height[j];
        		}
        		prevIndex = i;
        	}
        }
        //same logic but from the other side. height does not count when next wall is equal to avoid double counting
        prevIndex = height.length-1;
        while (prevIndex >= 0 && height[prevIndex] == 0) {
			prevIndex--;
		}
        for (int i=prevIndex; i>=0; i--) {
        	if (height[i] > height[prevIndex]) {
        		for (int j=prevIndex-1; j>i; j--) {
        			water += height[prevIndex] - height[j];
        		}
        		prevIndex = i;
        	}
        }
        return water;
    }
	public static void main(String[] args) {
		int[] height = new int[] {4,2,0,3,2,5};
		System.out.println(trap(height));
	}
}
