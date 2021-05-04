package l33tc0de;

public class easy278FirstBadVersion {
	private final int badVersion = 1;
	public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {        
        	int mid = left + (right-left)/2;
        	boolean bad = isBadVersion(mid);
        	if (bad) {
        		right = mid-1;
        	}
        	else {
        		left = mid+1;
        	}
        }
        return left;
    }
	private boolean isBadVersion(int i) {
		return i >= badVersion;
	}
}
