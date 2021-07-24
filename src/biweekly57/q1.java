package biweekly57;

public class q1 {
	public boolean areOccurrencesEqual(String s) {
        int[] cnt = new int[26];
        for (char c:s.toCharArray()) {
            cnt[c-'a']++;
        }
        int n = -1;
        for (int i:cnt) {
            if (i > 0) {
                if (n == -1) {
                    n = i;
                }
                else if (i != n) {
                    return false;
                }
            }
        }
        return true;
    }
}
