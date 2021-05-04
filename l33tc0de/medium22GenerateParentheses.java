package l33tc0de;

import java.util.*;

public class medium22GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		gen("", n*2, ans);
		for (int i=0; i<ans.size(); i++) {
			if (!isValid(ans.get(i))) {
				ans.remove(i);
				i--;
			}
		}
		return ans;
    }
	public static void gen(String soFar, int n, List<String> ans) {
		if (n == 0) {
			ans.add(soFar);
			return;
		}
		gen(soFar + ")", n-1, ans);
		gen(soFar + "(", n-1, ans);
	}
	public static boolean isValid(String s) {
		int tracker = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '(') {
				tracker++;
			}
			else {
				tracker--;
			}
			if (tracker < 0) {
				return false;
			}
		}
		return tracker == 0;
	}
	public static void main(String[] args) {
		List<String> ans = generateParenthesis(3);
		for (String s:ans) {
			System.out.println(s);
		}
	}
}
