package l33tc0de;

public class medium33SearchInRotatedSortedArray {
	//LMAO this is faster than 100%
	public int search(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
        	if (nums[i] == target) {
        		return i;
        	}
        }
        return -1;
    }
}
