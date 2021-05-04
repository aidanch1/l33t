package biweekly18;

public class q4 {
	public int maxValueAfterReverse(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length-1; i++) {
        	sum += Math.abs(nums[i]-nums[i+1]);
        }
        int max = sum;        
        for (int i=0; i<nums.length; i++) {
        	for (int j=i; j<nums.length; j++) {
        		int t = sum;
        		if (i == 0 && j < nums.length-1) {
        			t = t - Math.abs(nums[j]-nums[j+1]) + Math.abs(nums[i]-nums[j+1]);
        		}
        		else if (j == nums.length-1 && i > 0) {
        			t = t - Math.abs(nums[i]-nums[i-1]) + Math.abs(nums[j]-nums[i-1]);
        		}
        		else if (i > 0 && j < nums.length-1) { 
        			t = t - Math.abs(nums[i]-nums[i-1]) - Math.abs(nums[j]-nums[j+1])
        				+ Math.abs(nums[i]-nums[j+1]) + Math.abs(nums[j]-nums[i-1]);
        		}
        		if (t > max) {
        			max = t;
        		}
        	}
        }
        return max;
    }
}
