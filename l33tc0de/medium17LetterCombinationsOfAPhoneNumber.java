package l33tc0de;

import java.util.*;

public class medium17LetterCombinationsOfAPhoneNumber {
	static List<String> ans = new ArrayList<>();
	public static List<String> letterCombinations(String digits) {
        ans.clear();
        if (digits.length() == 0) {
        	return ans;
        }
        helper("", digits, 0);
        return ans;
    }
	public static void helper(String soFar, String digits, int index) {
		if (index == digits.length()) {
			ans.add(soFar);
			return;
		}
		else if (digits.charAt(index) == '2') {
			helper(soFar + "a", digits, index+1);
			helper(soFar + "b", digits, index+1);
			helper(soFar + "c", digits, index+1);
		}
		else if (digits.charAt(index) == '3') {
			helper(soFar + "d", digits, index+1);
			helper(soFar + "e", digits, index+1);
			helper(soFar + "f", digits, index+1);
		}
		else if (digits.charAt(index) == '4') {
			helper(soFar + "g", digits, index+1);
			helper(soFar + "h", digits, index+1);
			helper(soFar + "i", digits, index+1);
		}
		else if (digits.charAt(index) == '5') {
			helper(soFar + "j", digits, index+1);
			helper(soFar + "k", digits, index+1);
			helper(soFar + "l", digits, index+1);
		}
		else if (digits.charAt(index) == '6') {
			helper(soFar + "m", digits, index+1);
			helper(soFar + "n", digits, index+1);
			helper(soFar + "o", digits, index+1);
		}
		else if (digits.charAt(index) == '7') {
			helper(soFar + "p", digits, index+1);
			helper(soFar + "q", digits, index+1);
			helper(soFar + "r", digits, index+1);
			helper(soFar + "s", digits, index+1);
		}
		else if (digits.charAt(index) == '8') {
			helper(soFar + "t", digits, index+1);
			helper(soFar + "u", digits, index+1);
			helper(soFar + "v", digits, index+1);
		}
		else if (digits.charAt(index) == '9') {
			helper(soFar + "w", digits, index+1);
			helper(soFar + "x", digits, index+1);
			helper(soFar + "y", digits, index+1);
			helper(soFar + "z", digits, index+1);
		}
	}
	public static void main(String[] args) {
		String digits = "23";
		List<String> res = letterCombinations(digits);
		System.out.println(res);
	}
}
