package l33tc0de;

import java.util.*;

public class medium3LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		char[] c = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int start = 0;
        int longest = 0;
        for (int i=0; i<c.length; i++) {
            if (m.containsKey(c[i])) {
                int indexOfDupe = m.get(c[i]);
                for (int j=start; j<=indexOfDupe; j++) {
                    m.remove(c[j]);
                }
                start = indexOfDupe+1;
            }
            m.put(c[i], i);
            if (m.size() > longest) {
                longest = m.size();
            }
        }
        return longest;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bpfbhmipx"));
	}
}
