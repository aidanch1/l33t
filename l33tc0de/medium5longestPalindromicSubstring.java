package l33tc0de;

public class medium5longestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		String ans = "";
        for (int i=0; i<s.length(); i++) {
        	int j=0;
        	while (i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j)) {
        		j++;
        	}
        	if (j*2-1 > ans.length()) {
        		ans = s.substring(i-j+1, i+j);
        	}
        	if (i<s.length()-1 && s.charAt(i+1)==s.charAt(i)) {
        		j=0;
            	while (i-j >= 0 && i+j+1 < s.length() && s.charAt(i-j) == s.charAt(i+j+1)) {
            		j++;
            	}
            	if (2*j > ans.length()) {
            		ans = s.substring(i-j+1, i+j+1);
            	}
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
	}
}
