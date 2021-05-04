package l33tc0de;

public class medium34FindFirstAndLastPosition {
	public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
        	int mid = (left+right)/2;
        	if (nums[mid] == target) {
        		left = mid;
        		while (left >= 0 && nums[left] == target) {
        			left--;
        		}
        		left++;
        		right = mid;
        		while (right < nums.length && nums[right] == target) {
        			right++;
        		}
        		right--;
        		return new int[] {left, right};
        	}
        	else if (nums[mid] < target) {
        		left = mid+1;
        	}
        	else {
        		right = mid-1;
        	}
        }
        return new int[] {-1,-1};
    }
}
