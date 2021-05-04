package l33tc0de;

import java.util.*;

public class medium3LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		char[] c = s.toCharArray();
		int max = 0;
		for (int i=0; i<c.length; i++) {
			//get longest substring from this index
			Set<Character> seen = new HashSet<>();
			int j = i;
			while (j<c.length && !seen.contains(c[j])) {
				seen.add(c[j]);
				j++;
			}
			if (j-i > max) {
				max = j-i;
			}
		}
		return max;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
