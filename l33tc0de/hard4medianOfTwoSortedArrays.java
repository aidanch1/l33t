package l33tc0de;

public class hard4medianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int[] nums = merge(nums1, nums2);
       int mid = nums.length/2;
       if (nums.length%2 == 1) {
    	   return nums[mid];
       }
       else {
    	   return (nums[mid]+nums[mid-1])/2.0;
       }
    }
	public static int[] merge(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length + nums2.length];
		int i=0;
		int j=0;
		while (i<nums1.length && j<nums2.length) {
			if (nums1[i] < nums2[j]) {
				res[i+j] = nums1[i];
				i++;
			}
			else {
				res[i+j] = nums2[j];
				j++;
			}
		}
		while (i<nums1.length) {
			res[i+j] = nums1[i];
			i++;
		}
		while (j<nums2.length) {
			res[i+j] = nums2[j];
			j++;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2};
		int[] nums2 = new int[] {3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
