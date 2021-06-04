package junechal;

public class InterleavingString {
	public int[][] memo; //0 = unknown, 1 = false, 2 = true
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length()+s2.length()) {
            return false;
        }
        memo = new int[s1.length()][s2.length()];
        return isInterleave(s1,0,s2,0,s3,0);
    }
    public boolean isInterleave(String s1, int a, String s2, int b, String s3, int c) {
        if (a == s1.length() && b == s2.length() && c == s3.length()) {
            return true;
        }
        else if (a == s1.length()) {
            return s2.substring(b).equals(s3.substring(c));
        }
        else if (b == s2.length()) {
            return s1.substring(a).equals(s3.substring(c));
        }
        else if (memo[a][b] > 0) {
            if (memo[a][b] == 1) {
                return false;
            }
            else {
                return true;
            }
        }
        boolean t1 = false;
        boolean t2 = false;
        if (s1.charAt(a) == s3.charAt(c)) {
            t1 = isInterleave(s1,a+1,s2,b,s3,c+1);
        }
        if (s2.charAt(b) == s3.charAt(c)) {
            t2 = isInterleave(s1,a,s2,b+1,s3,c+1);
        }
        if (t1 || t2) {
            memo[a][b] = 2;
        }
        else {
            memo[a][b] = 1;
        }
        return memo[a][b] == 2;
    }
}
